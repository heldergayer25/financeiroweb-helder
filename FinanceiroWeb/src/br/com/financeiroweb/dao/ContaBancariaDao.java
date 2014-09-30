package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.ContaBancaria;

@SuppressWarnings("rawtypes")
public class ContaBancariaDao extends AbstractDao{

	public ContaBancariaDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(ContaBancaria conta){
        super.saveOrUpdate(conta);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(ContaBancaria conta){
        super.delete(conta);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public ContaBancaria find(Integer id){
        return (ContaBancaria) super.find(ContaBancaria.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(ContaBancaria conta){
        super.saveOrUpdate(conta);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(ContaBancaria.class);
    }    
	
}
