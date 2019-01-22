package mx.com.gm.sga.cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class ClienteEntidadPersona {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Inicia la transaccion
        tx.begin();
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        for(Persona p : personas){
            log.debug(p);
        }
        //Terminamos la transaccion
        tx.commit();
        em.close();
    }
}