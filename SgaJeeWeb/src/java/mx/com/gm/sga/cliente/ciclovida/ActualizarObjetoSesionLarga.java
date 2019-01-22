package mx.com.gm.sga.cliente.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoSesionLarga {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Paso 1. Inicia transaccion 1
        tx.begin();

        //Paso 2. Ejecuta SQL de tipo select
        //Puede ser un find o un merge si ya tenemos el objeto
        Persona persona1 = em.find(Persona.class, 1);
        
        log.debug("Objeto encontrado:" + persona1);        

        //Paso 3. setValue (nuevoValor)
        persona1.setApellidoMaterno("Aguirre");

        persona1.setApellidoMaterno("Torres");

        //Paso 4. Termina transaccion 1
        //Ejecuta el update, aunque hayamos hecho 2 cambios sobre el objeto
        //unicamente persiste el último cambio del objeto
        //es decir, el valor de apeMaterno=Torres
        tx.commit();

        //Objeto en estado detached
        log.debug("Objeto modificado:" + persona1);
    }
}
