package ventanas;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	private static final long serialVersionUID = 1L;
		
	public VentanaPrincipal(){
			inicializar();
		}
	
		private void inicializar() {
			setTitle("NETFLIX");
			setSize(400,400);
			
		}
}
