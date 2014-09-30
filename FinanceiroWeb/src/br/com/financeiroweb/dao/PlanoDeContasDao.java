package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.PlanoDeContas;

@SuppressWarnings("rawtypes")
public class PlanoDeContasDao extends AbstractDao{

	public PlanoDeContasDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(PlanoDeContas plano){
        super.saveOrUpdate(plano);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(PlanoDeContas plano){
        super.delete(plano);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public PlanoDeContas find(Integer id){
        return (PlanoDeContas) super.find(PlanoDeContas.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(PlanoDeContas plano){
        super.saveOrUpdate(plano);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(PlanoDeContas.class);
    }    
	
}
