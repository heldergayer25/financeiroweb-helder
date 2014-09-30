package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.Acesso;

@SuppressWarnings("rawtypes")
public class AcessoDao extends AbstractDao{

	public AcessoDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(Acesso acesso){
        super.saveOrUpdate(acesso);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(Acesso acesso){
        super.delete(acesso);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public Acesso find(Integer id){
        return (Acesso) super.find(Acesso.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(Acesso acesso){
        super.saveOrUpdate(acesso);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(Acesso.class);
    }    
	
}
