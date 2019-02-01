/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.user;

import Model.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jgutierrez
 */
@Local
public interface UserInterfaceLocal {
    
    public boolean addUser(Users usr);
    
    public boolean updateUser(Users usr);
    
    public List<Users> getAllUsers();
    
    public boolean deleteUser(int id);
    
    public Users findById(int id);
    
}
