/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanController;

import Model.Users;
import Service.user.UserInterfaceLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author jgutierrez
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserInterfaceLocal userInterfaceLocal;
    private static int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password1;
    private List<Users> users;
    private Users selectedUser;

    @PostConstruct
    public void init() {
        this.users = userInterfaceLocal.getAllUsers();
        selectedUser = new Users();
    }

    public void save() {

        if (getId() == 0) {

            Users userTemp = new Users();

            userTemp.setFirstName(firstName);

            userTemp.setLastName(lastName);

            userTemp.setUserName(userName);

            userTemp.setUserPassword(password1);

            if (userInterfaceLocal.addUser(userTemp)) {

                clearValues();
            }

        } else {

            if (userInterfaceLocal.updateUser(new Users(id, firstName, lastName, userName, password1))) {

                clearValues();
            }

        }
    }

    public void loadUser(Users us) {
        //this.selectedUser = us;
        setId(us.getUserId());
        setFirstName(us.getFirstName());
        setLastName(us.getLastName());
        setUserName(us.getUserName());
        setPassword1(us.getUserPassword());

    }

    public void deleteUser(Users us) {

        if (userInterfaceLocal.deleteUser(us.getUserId())) {

            FacesMessage fm = new FacesMessage("Notification", "User " + us.getUserName() + " has been deleted.");
            FacesContext.getCurrentInstance().addMessage(null, fm);

        }

    }

    public void clearValues() {
        this.firstName = "";
        this.lastName = "";
        this.userName = "";
        this.password1 = "";
        id = 0;
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

    /**
     * @return the selectedUser
     */
    public Users getSelectedUser() {
        return selectedUser;
    }

    /**
     * @param selectedUser the selectedUser to set
     */
    public void setSelectedUser(Users selectedUser) {
        this.selectedUser = selectedUser;
    }

}
