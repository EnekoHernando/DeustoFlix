package clases;

public class Capitulo extends Stream{
	private int nroTemporadas=0;
	private int nroEpisodiosXTemporada=0;
	
	public Capitulo(String titulo, String genero, String creador, int duracion, int nroTemporadas,
			int nroEpisodiosXTemporada) {
		super(titulo, genero, creador, duracion);
		this.nroTemporadas = nroTemporadas;
		this.nroEpisodiosXTemporada = nroEpisodiosXTemporada;
	}

	public int getNroTemporadas() {
		return nroTemporadas;
	}

	public void setNroTemporadas(int nroTemporadas) {
		this.nroTemporadas = nroTemporadas;
	}

	public int getNroEpisodiosXTemporada() {
		return nroEpisodiosXTemporada;
	}

	public void setNroEpisodiosXTemporada(int nroEpisodiosXTemporada) {
		this.nroEpisodiosXTemporada = nroEpisodiosXTemporada;
	}

	@Override
	public String toString() {
		return "Capitulo [nroTemporadas=" + nroTemporadas + ", nroEpisodiosXTemporada=" + nroEpisodiosXTemporada + "]";
	}
}
