/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.login;

import javax.ejb.Remote;

/**
 *
 * @author jgutierrez
 */
@Remote
public interface LoginInterfaceRemote {
    
    public boolean verifyLogin(String user, String pass);
    
}
