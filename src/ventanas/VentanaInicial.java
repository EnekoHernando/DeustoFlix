package ventanas;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Cuenta;
import clases.TipoPlan;
import clases.Usuario;

public class VentanaInicial extends JFrame{
	//Componentes del Log In
	private JLabel email;
	private JTextField txtemail;
	private JLabel contrasenya;
	private JTextField txtcontrasenya;
	private JButton registrarse;
	private JButton entrar;
	private JPanel panelCentral;
	private JPanel botonera;
	
	//Componentes del registro, de momento ocultos
	private JLabel infoCuenta;
	private JLabel emailRegistro;
	private JTextField txtemailRegistro;
	private JLabel contrasenyaRegistro;
	private JTextField txtcontrasenyaRegistro;
	private JLabel tipoPlan;
	private JComboBox cbtipoPlan;
	private JLabel infoUsuario;
	private JLabel nombreUsuario;
	private JTextField txtnombreUsuario;
	private JLabel usuarioInfantil;
	private JCheckBox cbusuarioInfantil;
	private JPanel datosCuenta;
	private JPanel datosUsuarios;
	private JButton guardarDatos;
	private JButton anyadirUsuario;
	private JPanel botoneraRegistro;
	
	public VentanaInicial()  {
		inicializar();
	}

	private void inicializar() {
		//Inicializamos elementos 
		email= new JLabel("Email: ");
		contrasenya= new JLabel("Contraseña: ");
		txtemail= new JTextField(25);
		txtcontrasenya= new JTextField(25);
		registrarse= new JButton("Registrarse");
		entrar= new JButton("Entrar");
		panelCentral= new JPanel();
		botonera= new JPanel();
		registrarse.setFont(new Font("Serif", Font.PLAIN, 20));
		entrar.setFont(new Font("Serif", Font.PLAIN, 20));
		infoCuenta=new JLabel("DATOS DE LA CUENTA");
		emailRegistro= new JLabel("Email: ");
		txtemailRegistro= new JTextField(25);
		contrasenyaRegistro= new JLabel("Contraseña: ");
		txtcontrasenyaRegistro= new JTextField(25);
		tipoPlan= new JLabel("Tipo de Plan: ");
		cbtipoPlan= new JComboBox();
		cbtipoPlan.setModel((ComboBoxModel) new DefaultComboBoxModel(TipoPlan.values()));
		nombreUsuario= new JLabel("Nombre usuario: ");
		txtnombreUsuario= new JTextField(25);
		usuarioInfantil= new JLabel("Usuario infantil");
		cbusuarioInfantil= new JCheckBox();
		cbusuarioInfantil.setName("SI");
		infoUsuario= new JLabel("CREAR USUARIO");
		datosCuenta= new JPanel();
		datosUsuarios= new JPanel();
		botoneraRegistro= new JPanel();
		guardarDatos= new JButton("Registrarse");
		anyadirUsuario= new JButton("Añadir usuario");
		
		//Añadimos a la ventana
		panelCentral.add(email);
		panelCentral.add(txtemail);
		panelCentral.add(contrasenya);
		panelCentral.add(txtcontrasenya);
		botonera.add(registrarse);
		botonera.add(entrar);
	
		//Dejamos añadidos los elementos a los paneles que visibilizaremos después
		datosCuenta.add(emailRegistro);
		datosCuenta.add(txtemailRegistro);
		datosCuenta.add(contrasenyaRegistro);
		datosCuenta.add(txtcontrasenyaRegistro);
		datosCuenta.add(tipoPlan);
		datosCuenta.add(cbtipoPlan);
		datosCuenta.setLayout(new GridLayout(3,2));
		
		datosUsuarios.add(nombreUsuario);
		datosUsuarios.add(txtnombreUsuario);
		datosUsuarios.add(usuarioInfantil);
		datosUsuarios.add(cbusuarioInfantil);
		datosUsuarios.setLayout(new GridLayout(2,2));
		
		botoneraRegistro.add(anyadirUsuario);
		botoneraRegistro.add(guardarDatos);
		botoneraRegistro.setLayout(new GridLayout(1,2));
		
		//Caracteristicas de la ventana
		setSize(400,200);
		setTitle("NETFLIX LOG IN");
		getContentPane().setLayout(new GridLayout(2,1));
		panelCentral.setLayout(new GridLayout(2,2));
		this.add(panelCentral);
		this.add(botonera);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("Cerrando");
				System.exit(0);
			}
		});
		
		//como poner el infoUsuario y infoCuenta en el centro y los botones mas pequeños??
		registrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setSize(500,600);
				setTitle("REGISTRO");
				getContentPane().removeAll();
				getContentPane().add(infoCuenta);
				getContentPane().add(datosCuenta);
				getContentPane().add(infoUsuario);
				getContentPane().add(datosUsuarios);
				getContentPane().add(botoneraRegistro);
				getContentPane().setLayout(new GridLayout(5,1));
			}
			
		});
		
		//3 intentos para la contraseña y mejor con excepciones??
		entrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Cuenta.cuentasRegistradas.containsKey(txtemail.getText()));
				if(Cuenta.cuentasRegistradas.containsKey(txtemail.getText())==false) {
					JOptionPane.showMessageDialog(null, "ERROR: No existe ninguna cuenta con ese email. REGISTRESE");
					txtemail.setText("");
					txtcontrasenya.setText("");
				}else {
					if((Cuenta.cuentasRegistradas.get(txtemail.getText())).getContrasenya().contentEquals(txtcontrasenya.getText())==true){
						VentanaUsuarios ventana= new VentanaUsuarios();
						ventana.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "ERROR: Contraseña incorrecta. Vuelva a intentarlo");
						txtemail.setText("");
						txtcontrasenya.setText("");
					}
				}
			}
		});
		
		ArrayList<Usuario> usuarios=new ArrayList<>();
		guardarDatos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//Comprueba que no exista una cuenta con ese email
					if(Cuenta.cuentasRegistradas.containsKey(txtemail.getText())==true) {
						JOptionPane.showMessageDialog(null, "ERROR: Ya existe una cuenta con ese email. Utilice otro");
						txtemailRegistro.setText("");
					}
					
					//Guarda los datos del usuario y la cuenta y lo añade al HashMap
					Usuario u1= new Usuario(txtnombreUsuario.getText(), cbusuarioInfantil.isSelected());
					usuarios.add(u1);
					Cuenta c1= new Cuenta(txtemailRegistro.getText(),txtcontrasenyaRegistro.getText(),(TipoPlan)cbtipoPlan.getSelectedItem(), usuarios);
					Cuenta.cuentasRegistradas.put(txtemailRegistro.getText(),c1);
					
					//Después de que se guarden todos los datos, vuelve a la ventana del Log In para poder entrar con la cuenta creada
					txtemailRegistro.setText("");
					txtcontrasenyaRegistro.setText("");
					cbtipoPlan.setToolTipText("");
					txtnombreUsuario.setText("");
					cbusuarioInfantil.setSelected(false);
					getContentPane().removeAll();
					setSize(400,200);
					setTitle("NETFLIX LOG IN");
					getContentPane().setLayout(new GridLayout(2,1));
					panelCentral.setLayout(new GridLayout(2,2));
					getContentPane().add(panelCentral);
					getContentPane().add(botonera);
					setVisible(true);
				//Aqui que tipo de exception es cuando esta vacio algun campo del registro?
				}catch (Exception t){
					System.out.println(t.getMessage());
				}
			}
		});
		
		anyadirUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//No se pueden añadir más que 5 usuarios
				if (usuarios.size()<5) {
					Usuario u1= new Usuario(txtnombreUsuario.getText(), cbusuarioInfantil.isSelected());
					usuarios.add(u1);
					txtnombreUsuario.setText("");
					cbusuarioInfantil.setSelected(false);
				}else {
					JOptionPane.showMessageDialog(null, "ERROR: No se pueden añadir más usuarios");
					txtnombreUsuario.setText("");
					cbusuarioInfantil.setSelected(false);
				}
				
			}
			
		});
	}
}
