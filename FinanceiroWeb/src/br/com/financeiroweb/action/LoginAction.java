package br.com.financeiroweb.action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.financeiroweb.dao.AcessoDao;
import br.com.financeiroweb.dao.UsuarioDao;
import br.com.financeiroweb.pojo.Acesso;
import br.com.financeiroweb.pojo.Usuario;
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
    private Usuario usuario;
         
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

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
        AcessoDao acessoDao = new AcessoDao();
        Acesso acesso = new Acesso();
                
        Criptografia criptografia = new Criptografia();
        String md5 = criptografia .md5(senha);
        
        acesso.setLogin(login);
        acesso.setSenha(md5);
                
        Acesso access = acessoDao.validaLogin(acesso);
        
        if(access != null) {     
        	UsuarioDao usuarioDao = new UsuarioDao();
        	usuario = usuarioDao.buscaUsuario(access);
            HttpSession session = Util.getSession();
            session.setAttribute("usuario", usuario);            
 
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
