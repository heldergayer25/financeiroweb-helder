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
    
    public Usuario validaLogin(Usuario usuario){
    	SessionFactory factory = HibernateUtil.getSessionFactory();		
	    Transaction tx;
	    Session session = factory.openSession();
	    Usuario a = new Usuario();
	    Acesso b = new Acesso();
	    try {	            
            tx = session.beginTransaction();
            
            AcessoDao aces = new AcessoDao();
            b = aces.validaLogin(usuario.getAcesso());
            
            Query query2 = session.createQuery("from Usuario where Usuario.id = :acesso");
            query2.setParameter("acesso", b.getId());
                        
            a = (Usuario) query2.uniqueResult();            
            
            a.setAcesso(b);
            
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Falha ao Salvar/Alterar Classe." + e.getStackTrace() + e.getMessage());
        } finally {
            session.flush();
        }
    	return a;
    }
	
}
