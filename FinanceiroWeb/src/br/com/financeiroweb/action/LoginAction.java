package br.com.financeiroweb.action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import br.com.financeiroweb.dao.UsuarioDao;
import br.com.financeiroweb.pojo.Acesso;
import br.com.financeiroweb.pojo.Usuario;

@ManagedBean
@RequestScoped
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

	public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        
        Usuario usuario = new Usuario();
        Acesso acesso = new Acesso();
        acesso.setLogin(txNome);
        acesso.setSenha(txSenha);
        usuario.setAcesso(acesso);
        UsuarioDao dao = new UsuarioDao();
        Usuario user = dao.validaLogin(usuario);
         
        if(user.getAcesso().getLogin() != null && user.getAcesso().getLogin().equals("admin") && user.getAcesso().getSenha() != null && user.getAcesso().getSenha().equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo!", txNome);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao Logar!", "Login/Senha inválidos!");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }
	
}
