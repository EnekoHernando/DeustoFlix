package clases;

public class Pelicula extends Stream{
	private int anyo=0;

	public Pelicula(String titulo, String genero, String creador, int duracion, int anyo) {
		super(titulo, genero, creador, duracion);
		this.anyo = anyo;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	@Override
	public String toString() {
		return "Pelicula [anyo=" + anyo + "]";
	}
}
