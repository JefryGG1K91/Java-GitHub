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
import org.primefaces.context.RequestContext;

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
    private Users selectedUser;

    @PostConstruct
    public void init() {

        this.users = userInterfaceLocal.getAllUsers();
        this.selectedUser=new Users();
        
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

    public void deleteUser(Users us) {

         if (userInterfaceLocal.deleteUser(us.getUserId())) {
            
          RequestContext.getCurrentInstance().showMessageInDialog(
                  new FacesMessage(FacesMessage.SEVERITY_INFO, "User notification", "User has been deleted"));
            
        }
         
    }

    public void loadUser(Users us){
    
        this.id=us.getUserId();
        this.firstName=us.getFirstName();
        this.lastName=us.getLastName();
        this.userName=us.getUserName();
        this.password1=us.getUserPassword();
        this.password2=us.getUserPassword();
              
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
