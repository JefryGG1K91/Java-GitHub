/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.login;

import Model.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class LoginServiceDao implements LoginInterfaceDao {

    @PersistenceContext(unitName = "CRUD_JSFPU")
    EntityManager em;
    //private static final String PERSISTENCE_UNIT="CRUD_JSFPU";
    
    public LoginServiceDao(){
    // em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }
    
    @Override
    public boolean verifyLogin(String user, String pass) {
       
        List<Users> result =em.createNamedQuery("Users.veryfyLogin",Users.class).setParameter(1, user).setParameter(2, pass).getResultList();
         
        for (int i = 0; i < result.size(); i++) {
            
            if (result.get(i).getUserName().equals(user) && result.get(i).getUserPassword().equals(pass)) {
                 
                return true;
                
            }
            
        }
             
        return false;
    }
    
}
