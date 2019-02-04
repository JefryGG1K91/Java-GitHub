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
import javax.persistence.Query;

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
              
        Query query = em.createNativeQuery("SELECT * FROM users where users.user_name=?1 and users.user_password=?2", Users.class);
        query.setParameter(1, user);
        query.setParameter(2, pass);
        List<Users> result2 = (List<Users>)query.getResultList();
        
        for (int i = 0; i < result2.size(); i++) {
            
            if (result2.get(i).getUserName().equals(user) && result2.get(i).getUserPassword().equals(pass)) {
                 
                return true;
                
            }
            
        }
             
        return false;
    }
    
}
