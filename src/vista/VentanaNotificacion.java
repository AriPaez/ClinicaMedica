package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ConexionBBDD;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaNotificacion extends JFrame {
	
	public VentanaNotificacion() {
		
		getContentPane().setLayout(null);	
		JPanel laminaPrincipal = new JPanel();
		setSize( 434, 261);
		setTitle("Inasistencias a turnos");
		setLocationRelativeTo(null);
		laminaPrincipal.setBounds(0, 0, 434, 261);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		JLabel tituloPrincipal = new JLabel("Inasistencias a Turnos");
		tituloPrincipal.setFont(new Font("Arial", Font.BOLD, 18));
		tituloPrincipal.setBounds(117, 11, 205, 28);
		laminaPrincipal.add(tituloPrincipal);
		
		JButton salir = new JButton("");
		salir.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaMedico\\salir.png"));
		salir.setBounds(184, 146, 50, 50);
		laminaPrincipal.add(salir);
		
		JLabel msjeSalir = new JLabel("Salir");
		msjeSalir.setFont(new Font("Arial", Font.BOLD, 12));
		msjeSalir.setBounds(194, 195, 46, 14);
		laminaPrincipal.add(msjeSalir);
	}
}
