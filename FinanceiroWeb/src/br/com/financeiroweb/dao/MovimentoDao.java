package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.Movimento;

@SuppressWarnings("rawtypes")
public class MovimentoDao extends AbstractDao {

	public MovimentoDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(Movimento movimento){
        super.saveOrUpdate(movimento);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(Movimento movimento){
        super.delete(movimento);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public Movimento find(Integer id){
        return (Movimento) super.find(Movimento.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(Movimento movimento){
        super.saveOrUpdate(movimento);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(Movimento.class);
    }    
	
}
