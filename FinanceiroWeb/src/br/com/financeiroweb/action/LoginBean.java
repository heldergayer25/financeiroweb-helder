package br.com.financeiroweb.action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.financeiroweb.dao.AcessoDao;
import br.com.financeiroweb.pojo.Acesso;
import br.com.financeiroweb.util.Criptografia;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	
    private String password;
    private String message, uname;
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public String loginProject() {
        boolean result = false; 
        AcessoDao acessoDao = new AcessoDao();
        Acesso acesso = new Acesso();
        
        Criptografia criptografia = new Criptografia();
        String md5 = criptografia .md5(password);
        
        acesso.setLogin(uname);
        acesso.setSenha(md5);
                
        result = acessoDao.validaLogin(acesso);
        
        if (result){
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", uname);
 
            return "home";
        } else {
 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Login inválido!",
                    "Por favor tente novamente!"));
 
            // invalidate session, and redirect to other pages
 
            //message = "Invalid Login. Please Try Again!";
            return "login";
        }
    }
 
    public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "login";
   }
	
}
