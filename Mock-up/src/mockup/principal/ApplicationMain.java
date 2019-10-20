package mockup.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ApplicationMain {

	private static int orden =  1;

	public static void main(String[] args) {

		List<Verificacion> coleccion = new ArrayList<Verificacion>();

		coleccion.add(new Verificacion("Comentario1.1","Imagen1.1",true));

		coleccion.add(new Verificacion("comentario1.2","null",false));

		coleccion.add(new Verificacion("comentario1.3","null",false));

		coleccion.add(new Verificacion("comentario2.1","null",false));

		coleccion.add(new Verificacion("comentario2.1.2","null",false));

		coleccion.add(new Verificacion("comentario2.2","Imagen2.2",false));

		coleccion.add(new Verificacion("comentario2.3","null",false));

		coleccion.add(new Verificacion("comentario2.3.1","null",false));
		
		coleccion.add(new Verificacion("comentario3.1","Imagen3.1",true));
		
		coleccion.add(new Verificacion("comentario3.1.2","null",false));
		
		coleccion.add(new Verificacion("comentario3.1.3","null",false));
		
		if (!coleccion.isEmpty()) {
			
			for (int i = 0; i < coleccion.size(); i++) {

				if (!coleccion.get(i).getImagen().equals("null") && !coleccion.get(i).getComentario().equals("null")) {
					
					if(!coleccion.get(i).getImagen().equals(ReporteOrdenado.obtenerInstancia().getImagenCodificada())) {
					
						imprimirInstancia();
						
						String resultdo =coleccion.get(i).isEstado() == true ? "Exitoso" : "Fallido";
						
						ReporteOrdenado.obtenerInstancia().cargarDatos(coleccion.get(i).getImagen(), coleccion.get(i).getComentario()+" "+resultdo, new ArrayList<String>());
						
					}
					
				}
				
				if(coleccion.get(i).getImagen().equals("null") && coleccion.get(i).isEstado() == false) {
					ReporteOrdenado.obtenerInstancia().getListadoProcesoAdjunto().add(coleccion.get(i).getComentario());
				}
				
				if((i+1) ==  coleccion.size()) {
					imprimirInstancia();
				}
				
			}
		}
	}

	private static void imprimirInstancia() {
		if (ReporteOrdenado.obtenerInstancia()!=null && 
				ReporteOrdenado.obtenerInstancia().getComentario() !=null && ReporteOrdenado.obtenerInstancia().getImagenCodificada() !=null) {

			System.out.println("Paso # "+orden);
			
			List<String> arregloComentario = ReporteOrdenado.obtenerInstancia().getListadoProcesoAdjunto();
			
			for (int i = 0; i < arregloComentario.size(); i++) {
				System.out.println(arregloComentario.get(i));
			}
			System.out.println(ReporteOrdenado.obtenerInstancia().getComentario());
			System.out.println(ReporteOrdenado.obtenerInstancia().getImagenCodificada());
			System.out.println("\n");
			ReporteOrdenado.destruirInstancia();
			arregloComentario = new ArrayList<String>();
			orden ++;
		}
	}
}
