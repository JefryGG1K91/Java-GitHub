/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Controller.LoginController;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author jgutierrez
 */
@SessionScoped
@Named("loginBean")
public class LoginBean implements Serializable {

    private String userName;
    private String password;
    @Inject
    private LoginController controller;

    public void verifyLogin() {

        if (controller.validateAccess(getUserName(), getPassword())) {

            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().getSessionMap().put("user", userName);

            try {

                fc.getExternalContext().redirect("faces/MainPage.xhtml");

            } catch (IOException ex) {

                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    public void logoutSession() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().invalidateSession();
            fc.getExternalContext().redirect("../index.xhtml");
            this.setUserName("");
            this.setPassword("");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
