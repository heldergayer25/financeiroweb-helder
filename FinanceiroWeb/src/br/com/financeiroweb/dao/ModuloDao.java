package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.Modulo;

@SuppressWarnings("rawtypes")
public class ModuloDao extends AbstractDao{

	public ModuloDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(Modulo modulo){
        super.saveOrUpdate(modulo);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(Modulo modulo){
        super.delete(modulo);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public Modulo find(Integer id){
        return (Modulo) super.find(Modulo.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(Modulo modulo){
        super.saveOrUpdate(modulo);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(Modulo.class);
    }    
	
}
