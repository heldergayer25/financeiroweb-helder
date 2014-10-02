package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.Usuario;

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
	
}
