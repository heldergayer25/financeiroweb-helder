package br.com.financeiroweb.action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.financeiroweb.dao.AcessoDao;
import br.com.financeiroweb.pojo.Acesso;
import br.com.financeiroweb.util.Criptografia;

/**
 * ManagedBean responsável pelo Login de acesso do usuário ao sistema
 * @author Helder
 *
 */
@ManagedBean(name = "loginAction")
@SessionScoped
public class LoginAction {
	
    private String senha;
    private String mensagens;
    private String login;
 
    public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMensagens() {
		return mensagens;
	}

	public void setMensagens(String mensagens) {
		this.mensagens = mensagens;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Verifica login e senha e efetua o logon do usuário criando uma sessão
	 * @return
	 */
	public String logon() {
        boolean result = false; 
        AcessoDao acessoDao = new AcessoDao();
        Acesso acesso = new Acesso();
        
        Criptografia criptografia = new Criptografia();
        String md5 = criptografia .md5(senha);
        
        acesso.setLogin(login);
        acesso.setSenha(md5);
                
        result = acessoDao.validaLogin(acesso);
        
        if(result) {            
            HttpSession session = Util.getSession();
            session.setAttribute("login", login);
 
            return "home";
        } else { 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Login inválido!",
                    "Por favor tente novamente!")); 
            
            return "login";
        }
    }
 
	/**
	 * Encerra a sessão
	 * @return
	 */
    public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "login";
   }
	
}
