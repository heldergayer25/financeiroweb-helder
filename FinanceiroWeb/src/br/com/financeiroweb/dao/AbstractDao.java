package br.com.financeiroweb.dao;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.financeiroweb.util.HibernateUtil;

/**
 * 
 * @author Helder
 * 
 * Classe Dao Abstrata com os principais métodos 
 * de interação com o banco de dados
 * utilizando o Framework Hibernate Annotations 4.3.6 
 *
 * @param <E>
 */

public abstract class AbstractDao<E> {
	
		private SessionFactory factory = HibernateUtil.getSessionFactory();		
	    private Transaction tx;

	    protected void saveOrUpdate(Object obj) {	    	
	    	Session session = factory.openSession();	    	
	        try {	            
	            tx = session.beginTransaction();
	            session.saveOrUpdate(obj);
	            tx.commit();
	        } catch (HibernateException e) {
	            System.out.println("Falha ao Salvar/Alterar Classe." + e.getStackTrace());
	        } finally {
	            session.flush();
	        }
	    }

	    protected void delete(Object obj) {
	    	Session session = factory.openSession();
	        try {
	        	tx = session.beginTransaction();	        	
	            session.delete(obj);
	            tx.commit();
	        } catch (HibernateException e) {
	        	System.out.println("Falha ao Remover Classe." + e.getStackTrace());
	        } finally {
	        	session.flush();
	        }
	    }

	    @SuppressWarnings("rawtypes")
		protected Object find(Class clazz, Integer id) {
	        Object obj = null;
	        Session session = factory.openSession();
	        try {
	        	tx = session.beginTransaction();	        	
	            obj = session.load(clazz, id);
	            tx.commit();
	        } catch (HibernateException e) {
	        	System.out.println("Falha ao Pesquisar Classe." + e.getStackTrace());
	        } finally {
	        	session.flush();
	        }
	        return obj;
	    }

	    @SuppressWarnings({ "rawtypes", "unchecked" })
		protected ArrayList findAll(Class clazz) {
	        ArrayList<E> objects = null;
	        Session session = factory.openSession();
	        try {
	        	tx = session.beginTransaction();
	            Query query = session.createQuery("from " + clazz.getName());
	            objects = new ArrayList<E>(query.list());
	            
	            tx.commit();
	        } catch (HibernateException e) {
	        	System.out.println("Falha ao Listar Classe." + e.getStackTrace());
	        } finally {
	        	session.flush();
	        }
	        return objects;
	    }    
	   
}
