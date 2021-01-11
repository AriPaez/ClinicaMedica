package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.ControlRegistro;

public class RegistroAdministrador extends JFrame {

	private JTextField ingresoDNI;
	private JPasswordField ingresoPass;
	private JButton registrar;
	private JComboBox Tipocargo;
	private JLabel msjePrimerNombre;
	private JTextField ingresoPrimerNombre;
	private JLabel msjeSegundoNombre;
	private JTextField ingresoSegundoNombre;
	private JLabel msjeApellido;
	private JTextField ingresoApellido;
	 
	public RegistroAdministrador() 
	{
		setTitle("Registro Administrador");
		setBounds(300, 300, 300, 300);
		setResizable(false);
		setLayout(new BorderLayout());

		JPanel laminaSuperior = new JPanel();
		laminaSuperior.setLayout(new FlowLayout());
		JLabel tituloPrincipal = new JLabel("SISTEMA CLÍNICO");
		tituloPrincipal.setFont(new Font("Arial", Font.BOLD, 30));
		laminaSuperior.add(tituloPrincipal);

		JPanel laminaCentral = new JPanel();
		laminaCentral.setLayout(new BorderLayout());

		JPanel laminaCentralIngresoDatos = new JPanel();
		laminaCentralIngresoDatos.setLayout(new GridLayout(5,5));
		laminaCentral.add(laminaCentralIngresoDatos, BorderLayout.NORTH);

		this.msjePrimerNombre=new JLabel("Primer Nombre");
		laminaCentralIngresoDatos.add(msjePrimerNombre);
		this.ingresoPrimerNombre=new JTextField();
		laminaCentralIngresoDatos.add(ingresoPrimerNombre);
		this.msjeSegundoNombre=new JLabel("Segundo Nombre");
		laminaCentralIngresoDatos.add(msjeSegundoNombre);
		this.ingresoSegundoNombre=new JTextField();
		laminaCentralIngresoDatos.add(ingresoSegundoNombre);
		
		this.msjeApellido=new JLabel("Apellido");
		laminaCentralIngresoDatos.add(msjeApellido);
		this.ingresoApellido=new JTextField();
		laminaCentralIngresoDatos.add(ingresoApellido);
		
		JLabel msjeDNI = new JLabel("DNI");
		laminaCentralIngresoDatos.add(msjeDNI);
		ingresoDNI = new JTextField();
		laminaCentralIngresoDatos.add(ingresoDNI);

		JLabel msjePass = new JLabel("Password");
		laminaCentralIngresoDatos.add(msjePass);
		ingresoPass = new JPasswordField();
		laminaCentralIngresoDatos.add(ingresoPass);

	 

		JPanel laminaInferior = new JPanel();
		laminaInferior.setLayout(new FlowLayout());
		registrar = new JButton("Registrarse");
		laminaInferior.add(registrar);
		add(laminaSuperior, BorderLayout.NORTH);
		add(laminaCentral, BorderLayout.CENTER);
		add(laminaInferior, BorderLayout.SOUTH);
		 
		//Se invoca a la clase ControlRegistro(this) pasandole por parametro un objeto Registro.
		registrar.addActionListener(new ControlRegistro(this));
		
		
	}

	public JComboBox getTipocargo() {
		return Tipocargo;
	}

	public String getIngresoDNI() {
		return ingresoDNI.getText();
	}

	public String getIngresoPass() {
		return ingresoPass.getText();
	}

	public String getIngresoPrimerNombre() {
		return ingresoPrimerNombre.getText();
	}

	public String getIngresoSegundoNombre() {
		return ingresoSegundoNombre.getText();
	}

	public String getIngresoApellido() {
		return ingresoApellido.getText();
	}

	
	 


	 
}
