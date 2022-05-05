package clases;
import java.util.ArrayList;
import java.util.HashMap;

public class Cuenta {
	private String email="";
	private String contrasenya="";
	private TipoPlan planCuenta=TipoPlan.ESTANDAR;
	private ArrayList<Usuario> usuarios= new ArrayList<>();
	
	
	public Cuenta(String email, String contrasena, TipoPlan planCuenta, ArrayList<Usuario> usuarios) {
		super();
		this.email = email;
		this.contrasenya = contrasena;
		this.planCuenta = planCuenta;
		this.usuarios = usuarios;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasena(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public TipoPlan getPlanCuenta() {
		return planCuenta;
	}

	public void setPlanCuenta(TipoPlan planCuenta) {
		this.planCuenta = planCuenta;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	//esto preguntar
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		if(usuarios.size()<5) {
			this.usuarios = usuarios;
		}
	}

	public static HashMap<String, Cuenta> getCuentasRegistradas() {
		return cuentasRegistradas;
	}

	public static void setCuentasRegistradas(HashMap<String, Cuenta> cuentasRegistradas) {
		Cuenta.cuentasRegistradas = cuentasRegistradas;
	}

	@Override
	public String toString() {
		return "Cuenta [email=" + email + ", contraseña=" + contrasenya + ", planCuenta=" + planCuenta + ", usuarios="
				+ usuarios + "]";
	}

	//esto lo he cambiado a public para que me deje hacer la ventana, problemas??
	public static HashMap<String,Cuenta> cuentasRegistradas = new HashMap<>();
}
