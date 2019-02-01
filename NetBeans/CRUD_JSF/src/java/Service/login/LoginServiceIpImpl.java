/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.login;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class LoginServiceIpImpl implements LoginInterfaceLocal, LoginInterfaceRemote{

    @EJB
    private LoginInterfaceDao dao;
    
    @Override
    public boolean verifyLogin(String user, String pass) {
      
        return dao.verifyLogin(user, pass);
        
    }
    
}
