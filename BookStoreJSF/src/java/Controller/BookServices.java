/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Book;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jgutierrez
 */
@Stateful
public class BookServices {
    
    @PersistenceContext(unitName = "BookStoreJSFPU")
    private EntityManager entityManager;

    public BookServices() {

        if (entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory("BookStoreJSFPU").createEntityManager();
        }

    }
    
    public List<Book> getAllBooks(){
        return entityManager.createNamedQuery("Book.findAll").getResultList();
    }
    
}
