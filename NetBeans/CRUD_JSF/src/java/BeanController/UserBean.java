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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jgutierrez
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

    @EJB
    private UserInterfaceLocal userInterfaceLocal;
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private List<Users> users;
    
    @PostConstruct
    public void init(){
    
        this.users = userInterfaceLocal.getAllUsers();
    
    }
    
//    public void addNewUser(){
//    
//    
//    }
//    
//    public void updateUser(){
//    
//    
//    }
//    
//    public void deleteUser(){
//    
//    
//    }
    
    
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
