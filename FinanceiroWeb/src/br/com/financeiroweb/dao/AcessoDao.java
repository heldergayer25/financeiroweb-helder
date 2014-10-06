package br.com.financeiroweb.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.financeiroweb.pojo.Acesso;
import br.com.financeiroweb.util.HibernateUtil;

@SuppressWarnings("rawtypes")
public class AcessoDao extends AbstractDao{

	public AcessoDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(Acesso acesso){
        super.saveOrUpdate(acesso);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(Acesso acesso){
        super.delete(acesso);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public Acesso find(Integer id){
        return (Acesso) super.find(Acesso.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(Acesso acesso){
        super.saveOrUpdate(acesso);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(Acesso.class);
    }    
    
    /*public Acesso validaLogin(Acesso acesso){
    	SessionFactory factory = HibernateUtil.getSessionFactory();		
	    Transaction tx;
	    Session session = factory.openSession();
	    Acesso access = new Acesso();
	    
	    try {	            
            tx = session.beginTransaction();
            
            Query query = session.createQuery("from Acesso a where a.login = :login and a.senha = :senha");
            query.setParameter("login", acesso.getLogin());
            query.setParameter("senha", acesso.getSenha());
            
            access = (Acesso) query.uniqueResult();
            
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Login e Senha não encontrados!" + e.getStackTrace() + e.getMessage());
        } finally {
            session.flush();
        }
    	return access;
    }*/
    
    public boolean validaLogin(Acesso acesso){
    	SessionFactory factory = HibernateUtil.getSessionFactory();		
	    Transaction tx;
	    Session session = factory.openSession();
	    Acesso access = new Acesso();
	    boolean valido = false;
	    
	    try {	            
            tx = session.beginTransaction();
            
            Query query = session.createQuery("from Acesso a where a.login = :login and a.senha = :senha");
            query.setParameter("login", acesso.getLogin());
            query.setParameter("senha", acesso.getSenha());
            
            access = (Acesso) query.uniqueResult();
            if(access != null){
            	valido = true;
            }
            
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Login e Senha não encontrados!" + e.getStackTrace() + e.getMessage());
        } finally {
            session.flush();
        }
    	return valido;
    }

	
}
