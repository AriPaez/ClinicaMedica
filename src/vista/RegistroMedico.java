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

public class RegistroMedico extends JFrame {

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
	private JLabel msjeConsultorio;
	private JTextField ingresoConsultorio;
	private JLabel msjeEspecialidad;
	private JComboBox ingresoEspecialidad;
	
	public RegistroMedico() 
	{
		setTitle("Registro de Médico");
		setBounds(300, 300, 300, 350);
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
		laminaCentralIngresoDatos.setLayout(new GridLayout(7,7));
		laminaCentral.add(laminaCentralIngresoDatos, BorderLayout.NORTH);

		JLabel msjeDNI = new JLabel("DNI");
		laminaCentralIngresoDatos.add(msjeDNI);
		ingresoDNI = new JTextField();
		laminaCentralIngresoDatos.add(ingresoDNI);
		
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
		
		this.msjeConsultorio=new JLabel("Consultorio");
		laminaCentralIngresoDatos.add(msjeConsultorio);
		this.ingresoConsultorio=new JTextField();
		laminaCentralIngresoDatos.add(ingresoConsultorio);
		
		
		this.msjeEspecialidad=new JLabel("Especialidad");
		laminaCentralIngresoDatos.add(msjeEspecialidad);
		this.ingresoEspecialidad=new JComboBox();
		ingresoEspecialidad.addItem("Cardiología");
		ingresoEspecialidad.addItem("Odontología");
		ingresoEspecialidad.addItem("Obstetricia");
		ingresoEspecialidad.addItem("Oftamología");
		laminaCentralIngresoDatos.add(ingresoEspecialidad);
		

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

	public int getIngresoConsultorio() {
		return  Integer.parseInt(this.ingresoConsultorio.getText());
	}

	public String getIngresoEspecialidad() {
		 
		return (String) ingresoEspecialidad.getSelectedItem();
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
