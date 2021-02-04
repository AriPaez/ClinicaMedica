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

public class VentanaTurnoDisponibles extends JFrame 
{
	private JTextField dniPaciente;
	private JButton filtrar;
	private JButton salir;
	private JTextArea turnosPacientes;
	
	public VentanaTurnoDisponibles() {
		
		//Caracteristica ventana.
		setSize(460, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		  
		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 434, 350);
		laminaPrincipal.setLayout(null);
		getContentPane().add(laminaPrincipal);
		
		JLabel msjeSistemaMedico = new JLabel("SISTEMA MÉDICO");
		msjeSistemaMedico.setFont(new Font("Arial", Font.PLAIN, 30));
		msjeSistemaMedico.setBounds(85, 0, 257, 59);
		laminaPrincipal.add(msjeSistemaMedico);
		
		turnosPacientes = new JTextArea();
		turnosPacientes.setEditable(false);
		turnosPacientes.setLineWrap(true);
		turnosPacientes.setBounds(10, 140, 424, 233);
		laminaPrincipal.add(turnosPacientes);
		
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
		filtrar.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaMedico\\filtrar.png"));
		filtrar.setBounds(96, 385, 50, 50);
		getContentPane().add(filtrar);
		
		salir = new JButton();
		salir.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaMedico\\salir.png"));
		salir.setBounds(279, 385, 50, 50);
		getContentPane().add(salir);
		
		JLabel msjeFiltrar = new JLabel("Filtrar");
		msjeFiltrar.setFont(new Font("Arial", Font.BOLD, 12));
		msjeFiltrar.setBounds(100, 436, 46, 14);
		getContentPane().add(msjeFiltrar);
		
		JLabel msjeSalir = new JLabel("Salir");
		msjeSalir.setFont(new Font("Arial", Font.BOLD, 12));
		msjeSalir.setBounds(295, 436, 46, 14);
		getContentPane().add(msjeSalir);
		 
		
		ControlVentanaTurnoDisponibles cVTD=new ControlVentanaTurnoDisponibles(this);
		
		
		filtrar.addActionListener(cVTD);
		salir.addActionListener(cVTD);
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

	public JTextArea getTurnosPacientes() {
		return turnosPacientes;
	}

	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente.setText(dniPaciente);;
	}
 
	
}
