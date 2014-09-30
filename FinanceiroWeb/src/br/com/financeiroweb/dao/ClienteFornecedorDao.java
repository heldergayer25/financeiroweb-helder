package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.ClienteFornecedor;

@SuppressWarnings("rawtypes")
public class ClienteFornecedorDao extends AbstractDao{

	public ClienteFornecedorDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(ClienteFornecedor cliente){
        super.saveOrUpdate(cliente);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(ClienteFornecedor cliente){
        super.delete(cliente);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public ClienteFornecedor find(Integer id){
        return (ClienteFornecedor) super.find(ClienteFornecedor.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(ClienteFornecedor cliente){
        super.saveOrUpdate(cliente);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(ClienteFornecedor.class);
    }    
	
}
