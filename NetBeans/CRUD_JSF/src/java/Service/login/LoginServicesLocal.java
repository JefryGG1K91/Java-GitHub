/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.login;

import javax.ejb.Local;

/**
 *
 * @author jgutierrez
 */
@Local
public interface LoginServicesLocal {
   
    public void verifyLogin(String user, String pass);
    
}
