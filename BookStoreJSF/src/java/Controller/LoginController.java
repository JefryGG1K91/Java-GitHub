/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class LoginController implements Serializable {

    @PersistenceContext(unitName = "BookStoreJSFPU")
    private EntityManager entityManager;

    public LoginController() {

        if (entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory("BookStoreJSFPU").createEntityManager();
        }

    }

    public boolean validateAccess(String user, String pass) {
        boolean result = false;

        if (!user.equals("") && user.length() > 0 && !pass.equals("") && pass.length() > 0) {

            try {

                Query query = entityManager.createNativeQuery("select * from user_xp where user_xp.username=?1 and user_xp.password=?2");
                query.setParameter(1, user);
                query.setParameter(2, pass);

                if (query.getResultList().size() == 1) {
                    result = true;
                }
            } catch (Exception e) {

                result = false;
                System.out.println(e.getClass() + " " + e.getMessage() + " " + e.getLocalizedMessage());
                Logger.getLogger(LoginController.class.getName()).log(Level.WARNING, null, e);
            }

        } else {
            result = false;
        }

        return result;
    }

}
