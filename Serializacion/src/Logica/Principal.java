package Logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class Principal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Persona p1= new Persona();
		p1.setNombre("Gabriela");
		p1.setSueldo(15000.00);
		PersonaControlador pc1= new PersonaControlador();
    	pc1.escribir(p1,"p1");
		
		Persona p2=(Persona)pc1.leer("p1");
		System.out.println("Nombre: "+p2.getNombre()+" Sueldo: "+p2.getSueldo());
		
		
		
		
	}

}
