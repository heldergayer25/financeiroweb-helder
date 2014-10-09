package br.com.financeiroweb.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.financeiroweb.pojo.Acesso;
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
    
    /**
     * Retorna dados do usuário logado
     * @param acesso
     * @return
     */
    public Usuario buscaUsuario(Acesso acesso){
    	SessionFactory factory = HibernateUtil.getSessionFactory();		
	    Transaction tx;
	    Session session = factory.openSession();
	    
	    Usuario usuario = new Usuario();
	    	    
	    try {	            
            tx = session.beginTransaction();
            
            Query query = session.createQuery("from Usuario u where u.acesso.id = :logon");
            query.setParameter("logon", acesso.getId());            
            
            usuario = (Usuario) query.uniqueResult();            
            
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Login e Senha não encontrados!" + e.getStackTrace() + e.getMessage());
        } finally {
            session.flush();
        }
    	return usuario;
    }
	
}
