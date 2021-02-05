package vista;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.ControlVentanaTurnoDisponibles;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class VentanaTurnoDisponibles extends JFrame 
{
	private JTextField dniPaciente;
	private JButton filtrar;
	private JButton salir;
	private JTable tabla;
	
	public VentanaTurnoDisponibles() {
		
		//Caracteristica ventana.
		setSize(800, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		  
		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 784, 461);
		laminaPrincipal.setLayout(null);
		getContentPane().add(laminaPrincipal);
		
		JLabel msjeSistemaMedico = new JLabel("SISTEMA MÉDICO");
		msjeSistemaMedico.setFont(new Font("Arial", Font.PLAIN, 30));
		msjeSistemaMedico.setBounds(85, 0, 257, 59);
		laminaPrincipal.add(msjeSistemaMedico);
		
		JLabel msjeTurnosDisponibles = new JLabel("TURNOS DISPONIBLES");
		msjeTurnosDisponibles.setFont(new Font("Arial", Font.PLAIN, 20));
		msjeTurnosDisponibles.setBounds(10, 48, 246, 33);
		laminaPrincipal.add(msjeTurnosDisponibles);
		
		JLabel msjeDNI = new JLabel("DNI Paciente");
		msjeDNI.setFont(new Font("Arial", Font.BOLD, 12));
		msjeDNI.setBounds(10, 97, 86, 16);
		laminaPrincipal.add(msjeDNI);
		
		dniPaciente = new JTextField();
		dniPaciente.setBounds(111, 95, 127, 20);
		laminaPrincipal.add(dniPaciente);
		dniPaciente.setColumns(10);
		
		filtrar = new JButton();
		filtrar.setBounds(279, 373, 50, 50);
		laminaPrincipal.add(filtrar);
		filtrar.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaMedico\\filtrar.png"));
		
		salir = new JButton();
		salir.setBounds(489, 373, 50, 50);
		laminaPrincipal.add(salir);
		salir.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaMedico\\salir.png"));
		
		JLabel msjeFiltrar = new JLabel("Filtrar");
		msjeFiltrar.setBounds(283, 425, 46, 14);
		laminaPrincipal.add(msjeFiltrar);
		msjeFiltrar.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel msjeSalir = new JLabel("Salir");
		msjeSalir.setBounds(499, 425, 46, 14);
		laminaPrincipal.add(msjeSalir);
		msjeSalir.setFont(new Font("Arial", Font.BOLD, 12));
		
		
		
		tabla = new JTable(); 
		JScrollPane barraDesplazamientoTabla = new JScrollPane(tabla);
		barraDesplazamientoTabla.setBounds(0, 127, 784, 209);
		laminaPrincipal.add(barraDesplazamientoTabla);
		
		ControlVentanaTurnoDisponibles cVTD=new ControlVentanaTurnoDisponibles(this);
		
		//Eventos.
		salir.addActionListener(cVTD);
		filtrar.addActionListener(cVTD);
		//Pemite cargar el area de texto al abrirse la ventana
		//ventanaturnosdisponibles.
		addWindowListener(cVTD);
		
	}

	public String getDniPaciente() {
		return dniPaciente.getText();
	}

	public JButton getFiltrar() {
		return filtrar;
	}

	public JButton getSalir() {
		return salir;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente.setText(dniPaciente);;
	}
 
	
}
