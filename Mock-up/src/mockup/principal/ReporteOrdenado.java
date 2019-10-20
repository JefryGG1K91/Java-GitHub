package mockup.principal;

import java.util.ArrayList;
import java.util.List;

public class ReporteOrdenado {

	private String imagenCodificada;
	private String comentario;
	private  List<String> listadoProcesoAdjunto= new ArrayList<String>();
	private static ReporteOrdenado instancia;
	
	public static ReporteOrdenado obtenerInstancia() {
		if(instancia == null) {
			instancia = new ReporteOrdenado();
		}
		return instancia;
	}
	
	public static ReporteOrdenado destruirInstancia() {
		if(instancia != null) {
			instancia = new ReporteOrdenado();
		}
		return instancia;
	}

	public void cargarDatos(String imagenCodificada, String comentario, List<String> listadoProcesoAdjunto) {
		this.imagenCodificada = imagenCodificada;
		this.comentario = comentario;
		this.listadoProcesoAdjunto = listadoProcesoAdjunto;
	}
	
	private ReporteOrdenado() {
	}

	public String getImagenCodificada() {
		return imagenCodificada;
	}
	public void setImagenCodificada(String imagenCodificada) {
		this.imagenCodificada = imagenCodificada;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public List<String> getListadoProcesoAdjunto() {
		return listadoProcesoAdjunto;
	}
	public void setListadoProcesoAdjunto(List<String> listadoProcesoAdjunto) {
		this.listadoProcesoAdjunto = listadoProcesoAdjunto;
	}
	
	

}
