/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanController;

import Model.Users;
import Service.user.UserInterfaceLocal;
import java.io.Serializable;
import java.util.List;
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
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password1;
    private String password2;
    private List<Users> users;
    private Users selectedUser;
//<!--https://www.primefaces.org/showcase/ui/data/datatable/selection.xhtml-->
    @PostConstruct
    public void init() {
        this.users = userInterfaceLocal.getAllUsers();
        selectedUser = new Users();
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
    
    public void loadUser(Users us){
    
        this.selectedUser.setUserId(us.getUserId());
        this.selectedUser.setUserName(us.getUserName());
        this.selectedUser.setUserPassword(us.getUserPassword());
        this.selectedUser.setFirstName(us.getFirstName());
        this.selectedUser.setLastName(us.getLastName());
        
    }

    public void deleteUser(Users us) {

         if (userInterfaceLocal.deleteUser(us.getUserId())) {
            
          FacesMessage fm = new FacesMessage("Notification", "User "+ us.getUserName()+" has been deleted.");
             FacesContext.getCurrentInstance().addMessage(null, fm);
            
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
