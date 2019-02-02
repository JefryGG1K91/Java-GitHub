/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanController;

import Model.Users;
import Service.user.UserInterfaceLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

/**
 *
 * @author jgutierrez
 */
@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {

    @EJB
    private UserInterfaceLocal userInterfaceLocal;
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password1;
    private String password2;
    private List<Users> users;

    @PostConstruct
    public void init() {

        this.users = userInterfaceLocal.getAllUsers();

    }

    public void addNewUser() {

        Users userTemp = new Users();

        userTemp.setFirstName(firstName);

        userTemp.setLastName(lastName);

        userTemp.setUserName(userName);

        userTemp.setUserPassword(password1);

        if (userInterfaceLocal.addUser(userTemp)) {

          clearValues();

        }

    }

    public void updateUser() {

    }

    public void deleteUser() {

    }

    public void validatePassword(ComponentSystemEvent event) {

        FacesContext fc = FacesContext.getCurrentInstance();

        UIComponent component = event.getComponent();

        UIInput passOneInput = (UIInput) component.findComponent("passOne");
        String passwordOne = passOneInput.getLocalValue() == null ? "" : passOneInput.getLocalValue().toString();
        String passIdOne = passOneInput.getClientId();

        UIInput uiInputConfirmPassword = (UIInput) component.findComponent("passTwo");
        String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
                : uiInputConfirmPassword.getLocalValue().toString();

        if (passwordOne.isEmpty() || confirmPassword.isEmpty()) {
            return;
        }

        if (!passwordOne.equals(confirmPassword)) {

            FacesMessage msg = new FacesMessage("Password must match confirm password");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc.addMessage(passIdOne, msg);
            fc.renderResponse();

        }

    }

    public int getId() {
        return id;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password) {
        this.password1 = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password) {
        this.password2 = password;
    }

    public void clearValues() {
            firstName = "";
            lastName = "";
            userName = "";
            password1 = "";
            password2 = "";
    }

}
