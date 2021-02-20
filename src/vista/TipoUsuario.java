package vista;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ControlTipoUsuario;

public class TipoUsuario extends JFrame {
	
	private JButton volverALogin;
	private JButton medico;
	private JButton administrador;
	
	

	public TipoUsuario() {
		getContentPane().setLayout(null);
		setSize(400,304);
		setLocationRelativeTo(null);
		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 384, 271);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		JLabel msjeTipoUsuario = new JLabel("TIPO DE USUARIO");
		msjeTipoUsuario.setFont(new Font("Arial", Font.BOLD, 30));
		msjeTipoUsuario.setBounds(58, 22, 289, 58);
		laminaPrincipal.add(msjeTipoUsuario);
		
		administrador = new JButton(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\clinicaMedica\\ClinicaMedica\\src\\icon\\tipoUsuario\\administrador.png"));
		 
		administrador.setBounds(68, 99, 100, 100);
		laminaPrincipal.add(administrador);
		
		medico = new JButton(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\clinicaMedica\\ClinicaMedica\\src\\icon\\tipoUsuario\\medico.png"));
		medico.setBounds(217, 99, 100, 100);
		laminaPrincipal.add(medico);
		
		volverALogin = new JButton("Atr\u00E1s");
		volverALogin.setFont(new Font("Arial", Font.PLAIN, 12));
		volverALogin.setBounds(141, 235, 89, 23);
		laminaPrincipal.add(volverALogin);
		
		JLabel msjeAdministrador = new JLabel("Administrador");
		msjeAdministrador.setFont(new Font("Arial", Font.BOLD, 12));
		msjeAdministrador.setBounds(78, 210, 90, 14);
		laminaPrincipal.add(msjeAdministrador);
		
		JLabel msjeMedico = new JLabel("M\u00E9dico");
		msjeMedico.setFont(new Font("Arial", Font.BOLD, 12));
		msjeMedico.setBounds(244, 210, 90, 14);
		laminaPrincipal.add(msjeMedico);
		
		ControlTipoUsuario cTU=new ControlTipoUsuario(this);
		
		volverALogin.addActionListener(cTU);
		medico.addActionListener(cTU);
		administrador.addActionListener(cTU);
		
		
	}
	
	public JButton getVolverALogin() {
		return volverALogin;
	}

	public JButton getMedico() {
		return medico;
	}

	public JButton getAdministrador() {
		return administrador;
	}
	
}
