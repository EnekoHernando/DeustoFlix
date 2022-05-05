package clases;

public class Stream {
	private String titulo="";
	private String genero= "";
	private String creador="";
	private int duracion=0;
	
	public Stream(String titulo, String genero, String creador, int duracion) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.creador = creador;
		this.duracion = duracion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Stream [titulo=" + titulo + ", genero=" + genero + ", creador=" + creador + ", duracion=" + duracion
				+ "]";
	}
	
}
