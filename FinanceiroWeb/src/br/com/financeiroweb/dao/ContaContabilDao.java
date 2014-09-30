package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.ContaContabil;

@SuppressWarnings("rawtypes")
public class ContaContabilDao extends AbstractDao{

	public ContaContabilDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(ContaContabil conta){
        super.saveOrUpdate(conta);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(ContaContabil conta){
        super.delete(conta);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public ContaContabil find(Integer id){
        return (ContaContabil) super.find(ContaContabil.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(ContaContabil conta){
        super.saveOrUpdate(conta);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(ContaContabil.class);
    }    
	
}
