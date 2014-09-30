package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.Contato;

@SuppressWarnings("rawtypes")
public class ContatoDao extends AbstractDao{

	public ContatoDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(Contato contato){
        super.saveOrUpdate(contato);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(Contato contato){
        super.delete(contato);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public Contato find(Integer id){
        return (Contato) super.find(Contato.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(Contato contato){
        super.saveOrUpdate(contato);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(Contato.class);
    }    
	
}
