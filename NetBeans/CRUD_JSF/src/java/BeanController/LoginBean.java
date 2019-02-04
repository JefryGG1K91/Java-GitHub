/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanController;
import Service.login.LoginInterfaceLocal;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jgutierrez
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    @EJB
    private LoginInterfaceLocal interfaceDao;
    private String user;
    private String pass;
    private String page;

    public void validateAccess() {

        FacesContext fc= FacesContext.getCurrentInstance();
        
        if (interfaceDao.verifyLogin(user, pass)) {
            
            fc.getExternalContext().getSessionMap().put("user", user);
            
            try {
                
                 fc.getExternalContext().redirect("MainPage.xhtml");
                
            } catch (Exception e) {
                
                e.getCause();
                
            }
            
        } else {
           
            fc.addMessage(null , new FacesMessage("Login incorrect"));
            
        }
        

    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

 }
