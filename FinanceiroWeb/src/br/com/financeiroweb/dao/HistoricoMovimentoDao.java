package br.com.financeiroweb.dao;

import java.util.ArrayList;

import br.com.financeiroweb.pojo.HistoricoMovimento;


@SuppressWarnings("rawtypes")
public class HistoricoMovimentoDao extends AbstractDao{

	public HistoricoMovimentoDao() {	
		super();
	}

    /**
     * Insere um novo objeto no banco
     * @param movimento
     */
    public void create(HistoricoMovimento historico){
        super.saveOrUpdate(historico);
    }


    /**
     * Deleta um objeto do banco
     * @param movimento
     */
    public void delete(HistoricoMovimento historico){
        super.delete(historico);
    }

    /**
     * Busca um objeto no banco com sua Chave
     * @param id
     * @return
     */
    public HistoricoMovimento find(Integer id){
        return (HistoricoMovimento) super.find(HistoricoMovimento.class, id);
    }

    /**
     * Altera um objeto no banco
     *
     * @param movimento
     */
    public void update(HistoricoMovimento historico){
        super.saveOrUpdate(historico);
    }

    /**
     * Busca todos os objetos no banco
     * @return
     */
    public ArrayList findAll(){
        return super.findAll(HistoricoMovimento.class);
    }    
	
}
