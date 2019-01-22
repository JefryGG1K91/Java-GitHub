package mx.com.gm.sga.cliente.transacciones;

import javax.naming.Context;
import javax.naming.InitialContext;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaManejoTransacciones {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) throws Exception {
        Context jndi = new InitialContext();
        PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");

        log.debug("Iniciando prueba Manejo Transaccional PersonaService");

        //Buscamos un objeto persona
        Persona persona1 = personaService.encontrarPersonaPorId(new Persona(1));

        //Cambiamos la persona
        //persona1.setApellidoMaterno("Cambio con error....................................................................");
        persona1.setApellidoMaterno("Cambio sin errror");

        personaService.modificarPersona(persona1);

        log.debug("Objeto modificado:" + persona1);
        log.debug("Fin prueba EJB PersonaService");

    }
}
