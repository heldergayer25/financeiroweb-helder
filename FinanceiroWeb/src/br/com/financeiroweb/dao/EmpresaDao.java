package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.Empresa;


@SuppressWarnings("rawtypes")
public class EmpresaDao extends AbstractDao{

	public EmpresaDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(Empresa empresa){
        super.saveOrUpdate(empresa);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(Empresa empresa){
        super.delete(empresa);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public Empresa find(Integer id){
        return (Empresa) super.find(Empresa.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(Empresa empresa){
        super.saveOrUpdate(empresa);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(Empresa.class);
    }    
	
}
