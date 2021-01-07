package vista;

import java.awt.BorderLayout;
import java.awt.Color;
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

import controlador.ControlLogin;

public class Login extends JFrame {

	private static JTextField  ingresoDNI;
	private JPasswordField ingresoPass;
	private JButton iniciarSesion;
	private JButton registrar;
	private JComboBox cargo;
	 
	public Login() {

		setTitle("Login");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		
		JPanel laminaSuperior = new JPanel();
		laminaSuperior.setLayout(new FlowLayout());
		JLabel tituloPrincipal = new JLabel("SISTEMA CLÍNICO");
		tituloPrincipal.setFont(new Font("Arial", Font.BOLD, 30));
		laminaSuperior.add(tituloPrincipal);

		JPanel laminaCentral = new JPanel();
		laminaCentral.setLayout(new BorderLayout());

		JPanel laminaCentralIngresoDatos = new JPanel();
		laminaCentralIngresoDatos.setLayout(new GridLayout(3, 3));
		laminaCentral.add(laminaCentralIngresoDatos, BorderLayout.NORTH);

		JLabel msjeDNI = new JLabel("DNI");
		laminaCentralIngresoDatos.add(msjeDNI);
		ingresoDNI = new JTextField();
		laminaCentralIngresoDatos.add(ingresoDNI);

		JLabel msjePass = new JLabel("Password");
		laminaCentralIngresoDatos.add(msjePass);
		ingresoPass = new JPasswordField();
		laminaCentralIngresoDatos.add(ingresoPass);

		JLabel msjeCargo = new JLabel("Cargo");
		laminaCentralIngresoDatos.add(msjeCargo);
		cargo = new JComboBox();
		cargo.addItem("Medico");
		cargo.addItem("Administrador");
		laminaCentralIngresoDatos.add(cargo);

		JPanel laminaInferior = new JPanel();
		laminaInferior.setLayout(new FlowLayout());
		iniciarSesion = new JButton("Iniciar Sesion");
		registrar = new JButton("Registrarse");
		laminaInferior.add(iniciarSesion);
		laminaInferior.add(registrar);

		add(laminaSuperior, BorderLayout.NORTH);
		add(laminaCentral, BorderLayout.CENTER);
		add(laminaInferior, BorderLayout.SOUTH);

		ControlLogin controlBotones = new ControlLogin(this);

		iniciarSesion.addActionListener(controlBotones);
		registrar.addActionListener(controlBotones);

	}

	public JButton getIniciarSesion() {
		return iniciarSesion;
	}

	public JButton getRegistrar() {
		return registrar;
	}

	public  static JTextField getIngresoDNI() {
		return ingresoDNI;
	}
	 
	public JPasswordField getIngresoPass() {
		return ingresoPass;
	}

	public JComboBox getCargo() {
		return cargo;
	}
	
	public void setIngresoDNI(String ingresoDNI) {
		this.ingresoDNI.setText(ingresoDNI);
	}

	public void setIngresoPass(String ingresoPass) {
		this.ingresoPass.setText(ingresoPass);
	}
	
	 
}
