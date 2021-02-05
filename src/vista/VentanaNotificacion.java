package vista;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import controlador.ControlVentanaNotificacion;
import javax.swing.JScrollPane;

public class VentanaNotificacion extends JFrame {
	private JButton salir;
	private JTable tabla;
	
	public VentanaNotificacion() {
		
		getContentPane().setLayout(null);	
		JPanel laminaPrincipal = new JPanel();
		setSize( 434, 345);
		setTitle("Inasistencias a turnos");
		setLocationRelativeTo(null);
		laminaPrincipal.setBounds(0, 0, 418, 306);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		JLabel tituloPrincipal = new JLabel("Inasistencias a Turnos");
		tituloPrincipal.setFont(new Font("Arial", Font.BOLD, 18));
		tituloPrincipal.setBounds(117, 11, 205, 28);
		laminaPrincipal.add(tituloPrincipal);
		
		salir = new JButton("");
		salir.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaMedico\\salir.png"));
		salir.setBounds(192, 230, 50, 50);
		laminaPrincipal.add(salir);
		
		JLabel msjeSalir = new JLabel("Salir");
		msjeSalir.setFont(new Font("Arial", Font.BOLD, 12));
		msjeSalir.setBounds(205, 281, 46, 14);
		laminaPrincipal.add(msjeSalir);
		
		 
		tabla = new JTable();
		JScrollPane barraDesplazamientoTabla = new JScrollPane(tabla);
		barraDesplazamientoTabla.setBounds(54, 61, 311, 94);
		laminaPrincipal.add(barraDesplazamientoTabla);
		 
		
		ControlVentanaNotificacion cVN=new ControlVentanaNotificacion(this);
	
		//eventos 
		addWindowListener(cVN);	
		salir.addActionListener(cVN);
		
	}

	public JTable getTabla() {
		return tabla;
	}
}
