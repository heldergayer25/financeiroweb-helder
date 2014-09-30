package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.Endereco;

@SuppressWarnings("rawtypes")
public class EnderecoDao extends AbstractDao{

	public EnderecoDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(Endereco endereco){
        super.saveOrUpdate(endereco);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(Endereco endereco){
        super.delete(endereco);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public Endereco find(Integer id){
        return (Endereco) super.find(Endereco.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(Endereco endereco){
        super.saveOrUpdate(endereco);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(Endereco.class);
    }    
	
}
