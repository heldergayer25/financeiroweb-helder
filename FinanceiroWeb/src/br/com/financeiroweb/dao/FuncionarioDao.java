package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.Funcionario;

@SuppressWarnings("rawtypes")
public class FuncionarioDao extends AbstractDao{

	public FuncionarioDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(Funcionario funcionario){
        super.saveOrUpdate(funcionario);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(Funcionario funcionario){
        super.delete(funcionario);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public Funcionario find(Integer id){
        return (Funcionario) super.find(Funcionario.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(Funcionario funcionario){
        super.saveOrUpdate(funcionario);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(Funcionario.class);
    }    
	
}
