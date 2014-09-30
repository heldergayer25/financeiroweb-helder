package br.com.financeiroweb.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.financeiroweb.pojo.Usuario;
import br.com.financeiroweb.util.HibernateUtil;

@SuppressWarnings("rawtypes")
public class UsuarioDao extends AbstractDao{

	public UsuarioDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(Usuario usuario){
        super.saveOrUpdate(usuario);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(Usuario usuario){
        super.delete(usuario);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public Usuario find(Integer id){
        return (Usuario) super.find(Usuario.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(Usuario usuario){
        super.saveOrUpdate(usuario);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(Usuario.class);
    }    
    
    public Usuario validaLogin(Usuario usuario){
    	
        //Criteria criteria = sessao.createCriteria(CadastroLogin.class).add(Restrictions.eq("login", p.getLogin())); 

        //return (CadastroLogin) criteria.uniqueResult();
    	
    	
    	SessionFactory factory = HibernateUtil.getSessionFactory();		
	    Transaction tx;
    	Usuario user = null;
        Session session = factory.openSession();
        try {
        	Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("login", usuario.getAcesso().getLogin())).add(Restrictions.eq("senha", usuario.getAcesso().getSenha()));
        	
        	tx = session.beginTransaction();	        	
            user = (Usuario) criteria;
            tx.commit();
        } catch (HibernateException e) {
        	System.out.println("Falha ao validar acesso." + e.getStackTrace());
        } finally {
        	session.flush();
        }
        return user;
    	
    }
	
}
