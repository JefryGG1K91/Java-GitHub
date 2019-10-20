package mockup.principal;

public class Verificacion {

	private String comentario;
	private String imagen;
	private boolean estado;
	
	public Verificacion(String comentario, String imagen, boolean estado) {
		this.comentario = comentario;
		this.imagen = imagen;
		this.estado = estado;
	}

	public Verificacion() {
		// TODO Auto-generated constructor stub
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
