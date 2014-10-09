package br.com.financeiroweb.action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.financeiroweb.dao.ContatoDao;
import br.com.financeiroweb.dao.EmpresaDao;
import br.com.financeiroweb.dao.EnderecoDao;
import br.com.financeiroweb.pojo.ContaBancaria;
import br.com.financeiroweb.pojo.ContaContabil;
import br.com.financeiroweb.pojo.Contato;
import br.com.financeiroweb.pojo.Empresa;
import br.com.financeiroweb.pojo.Endereco;
import br.com.financeiroweb.pojo.PlanoDeContas;

@ManagedBean(name="empresaAction")
@RequestScoped
public class EmpresaAction {
	
	private Empresa empresa;
	private Endereco endereco;
	private Contato contato;
	
	public EmpresaAction() {		
		this.empresa = new Empresa();
		this.endereco = new Endereco();
		this.contato = new Contato();
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public void salvarEmpresa(){
		
		EmpresaDao empresaDao = new EmpresaDao();
		ContatoDao contatoDao = new ContatoDao();
		EnderecoDao enderecoDao = new EnderecoDao();
				
		contatoDao.create(contato);		
		
		
		enderecoDao.create(endereco);
		
		empresa.setEndereco(endereco);
		empresa.setContato(contato);		
		
		contato.getEmpresas().add(empresa);
		endereco.getEmpresas().add(empresa);
		
		ContaBancaria conta = new ContaBancaria();
		conta.setAgencia(123);
		conta.setConta(123);
		conta.setDigito(9);
		conta.setNome("a");
		conta.setSaldoInicial(0);
		conta.getEmpresas().add(empresa);
		
		PlanoDeContas plano = new PlanoDeContas();
		ContaContabil contabil = new ContaContabil();
		contabil.setCodigo("0");
		contabil.setNome("a");
		contabil.getPlanoDeContases().add(plano);
		
		plano.setContaContabil(contabil);
		plano.setDescricao("a");
		plano.getEmpresas().add(empresa);
		plano.setPlanoDeContas(plano);
		
		empresa.setContaBancaria(conta);		
		empresa.setPlanoDeContas(plano);
		empresa.setContaBancaria(conta);
		empresa.setPlanoDeContas(plano);
				
		empresaDao.create(empresa);
		
		FacesMessage msg = new FacesMessage("Empresa salva com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
}
