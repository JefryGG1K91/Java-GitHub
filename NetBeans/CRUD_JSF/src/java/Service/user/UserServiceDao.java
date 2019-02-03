/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.user;

import Model.Users;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class UserServiceDao implements UserInterfaceDao {

    @PersistenceContext(unitName = "CRUD_JSFPU")
    EntityManager em;
    
  //  private EntityTransaction et;
  //  private final static String PERSISTENCE_UNIT = "CRUD_JSFPU";
  //  public UserServiceDao() { em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager(); }
    
    @Override
    public boolean addUser(Users usr) {
        if (usr != null) {

//            et = em.getTransaction();

//            et.begin();

            em.persist(usr);

//            et.commit();

            return true;

        } else {

            return false;
        }
    }

    @Override
    public boolean updateUser(Users usr) {
        if (usr != null) {

            Users tempUser = em.find(Users.class, usr.getUserId());

//            et = em.getTransaction();

//            et.begin();

            tempUser.setFirstName(usr.getFirstName());

            tempUser.setLastName(usr.getLastName());

            tempUser.setUserName(usr.getUserName());

            tempUser.setUserPassword(usr.getUserPassword());

            try {

                em.merge(tempUser);

//                et.commit();

            } catch (Exception e) {

//                em.setRollbackOnly();

            }
            return true;

        } else {

            return false;
        }
    }

    @Override
    public List<Users> getAllUsers() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }

    @Override
    public boolean deleteUser(int id) {
        if (id > 0) {

            Users tempUser = em.find(Users.class, id);

            em.remove(tempUser);

            return true;

        } else {

            return false;

        }
    }

    @Override
    public Users findById(int id) {

        Users user = em.find(Users.class, id);

        return user;
    }

}
