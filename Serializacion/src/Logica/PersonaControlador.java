package Logica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObjectOutputStream escrituraDatos;
	private ObjectInputStream leerDatos;

	
	public void escribir(Object p,String archivoNombre){
		
        try {
            escrituraDatos = new ObjectOutputStream(new FileOutputStream(archivoNombre+".txt"));
            escrituraDatos.writeObject(p);
        
        } catch (IOException ex) {
            Logger.getLogger(PersonaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public Object leer(String nombreArchivo){
		
		Object resultado = null;
		
		try {
			leerDatos= new ObjectInputStream(new FileInputStream(nombreArchivo+".txt"));
		} catch (IOException ex) {
            Logger.getLogger(PersonaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
		try {
			resultado=leerDatos.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return resultado;
	}
	
	
	
}
