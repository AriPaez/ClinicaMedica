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

public class Login extends JFrame {


	public Login() {

		setBounds(300,300,300,300);
		setResizable(false);
		setLayout(new BorderLayout());
		
		
		JPanel laminaSuperior=new JPanel();
		laminaSuperior.setLayout(new FlowLayout());
		JLabel tituloPrincipal=new JLabel("SISTEMA CLÍNICO");
		tituloPrincipal.setFont(new Font("Arial",Font.BOLD,30));
		laminaSuperior.add(tituloPrincipal);
		 
		
		JPanel laminaCentral=new JPanel();
		laminaCentral.setLayout(new BorderLayout());
		
		JPanel laminaCentralIngresoDatos=new JPanel();
		laminaCentralIngresoDatos.setLayout(new GridLayout(3,3));
		laminaCentral.add(laminaCentralIngresoDatos,BorderLayout.NORTH);
		 
		
		JLabel msjeDNI=new JLabel("DNI");
		laminaCentralIngresoDatos.add(msjeDNI);
		JTextField ingresoDNI=new JTextField();
		laminaCentralIngresoDatos.add(ingresoDNI);
		
		
		JLabel msjePass=new JLabel("Password");
		laminaCentralIngresoDatos.add(msjePass);
		JPasswordField ingresoPass=new JPasswordField();
		laminaCentralIngresoDatos.add(ingresoPass);
		
		
		JLabel msjeCargo=new JLabel("Cargo");
		laminaCentralIngresoDatos.add(msjeCargo);
		JComboBox cargo=new JComboBox();
		cargo.addItem("Medico");
		cargo.addItem("Administrador");
		laminaCentralIngresoDatos.add(cargo);
		
		JPanel laminaInferior=new JPanel();
		laminaInferior.setLayout(new FlowLayout());
		JButton iniciarSesion=new JButton("Iniciar Sesion");
		JButton registrase=new JButton("Registrase");
		laminaInferior.add(iniciarSesion);
		laminaInferior.add(registrase);
		
		add(laminaSuperior,BorderLayout.NORTH);
		add(laminaCentral,BorderLayout.CENTER);
		add(laminaInferior,BorderLayout.SOUTH);
	}

}
