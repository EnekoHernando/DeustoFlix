package clases;
import java.util.ArrayList;

public class Usuario {
	private String nombre="";
	private boolean infantil=false;
	private ArrayList<Stream> miLista= new ArrayList<>();
	private ArrayList<Stream> favoritos= new ArrayList<>();
	private ArrayList<Stream> visto= new ArrayList<>();
	
	public Usuario(String nombre, boolean infantil, ArrayList<Stream> miLista, ArrayList<Stream> favoritos,
			ArrayList<Stream> visto) {
		super();
		this.nombre = nombre;
		this.infantil = infantil;
		this.miLista = miLista;
		this.favoritos = favoritos;
		this.visto = visto;
	}

	public Usuario(String nombre, boolean infantil) {
		super();
		this.nombre = nombre;
		this.infantil = infantil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isInfantil() {
		return infantil;
	}

	public void setInfantil(boolean infantil) {
		this.infantil = infantil;
	}

	public ArrayList<Stream> getMiLista() {
		return miLista;
	}

	public void setMiLista(ArrayList<Stream> miLista) {
		this.miLista = miLista;
	}

	public ArrayList<Stream> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(ArrayList<Stream> favoritos) {
		this.favoritos = favoritos;
	}

	public ArrayList<Stream> getVisto() {
		return visto;
	}

	public void setVisto(ArrayList<Stream> visto) {
		this.visto = visto;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", infantil=" + infantil + ", miLista=" + miLista + ", favoritos="
				+ favoritos + ", visto=" + visto + "]";
	}
	
}
