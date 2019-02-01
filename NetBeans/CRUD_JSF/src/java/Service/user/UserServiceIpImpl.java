/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.user;

import Model.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author jgutierrez
 */
@Stateful
public class UserServiceIpImpl implements UserInterfaceLocal, UserInterfaceRemote {

    @EJB
    private UserInterfaceDao userInterfaceDao;
    
    @Override
    public boolean addUser(Users usr) {
      return userInterfaceDao.addUser(usr);
    }

    @Override
    public boolean updateUser(Users usr) {
        return userInterfaceDao.updateUser(usr);
    }

    @Override
    public List<Users> getAllUsers() {
       return userInterfaceDao.getAllUsers();
    }

    @Override
    public boolean deleteUser(int id) {
        return userInterfaceDao.deleteUser(id);
    }

    @Override
    public Users findById(int id) {
      return userInterfaceDao.findById(id);
    }
    
}
