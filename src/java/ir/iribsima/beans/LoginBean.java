package ir.iribsima.beans;

import ir.iribsima.dao.UsersFacade;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "loginBean")
@SessionScoped

public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String uname;
    private String password;

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
//        boolean result = UserDAO.login(uname, password);
//        if (result) {
//            return "home";
//        } else {
//            FacesContext.getCurrentInstance().addMessage(
//                    null,
//                    new FacesMessage(FacesMessage.SEVERITY_WARN,
//                    "Invalid Login!",
//                    "Please Try Again!"));
        if (uname.equals("reza") && password.equals("ali")) {
            return "index";
        }
        return "login";
    }
}
