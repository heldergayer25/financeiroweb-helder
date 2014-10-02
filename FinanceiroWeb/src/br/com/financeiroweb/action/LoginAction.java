package br.com.financeiroweb.action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import br.com.financeiroweb.dao.AcessoDao;
import br.com.financeiroweb.pojo.Acesso;
import br.com.financeiroweb.util.Criptografia;

@ManagedBean
@SessionScoped
public class LoginAction {

	private String txNome;    
    private String txSenha;
    
    public String getTxNome() {
		return txNome;
	}
    
	public void setTxNome(String txNome) {
		this.txNome = txNome;
	}
	
	public String getTxSenha() {
		return txSenha;
	}
	
	public void setTxSenha(String txSenha) {
		this.txSenha = txSenha;
	}

	public String login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        
        Criptografia criptografia = new Criptografia();
        String senhaCriptografada = criptografia.md5(txSenha);
        
        Acesso acesso = new Acesso();
        acesso.setLogin(txNome);
        acesso.setSenha(senhaCriptografada);
        
        AcessoDao acessoDao = new AcessoDao();
        Acesso resultado = acessoDao.validaLogin(acesso);  
        
        if(resultado != null){        	
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo!", txNome);
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
            return "/layout.xhtml?faces-redirect=true";
        }else{
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao Logar!", "Login/Senha inválidos!");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        return "/index.xhtml?faces-redirect=true";
    }
	
}
