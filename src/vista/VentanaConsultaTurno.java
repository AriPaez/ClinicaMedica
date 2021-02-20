package vista;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.ControlVentanaConsultaTurno;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class VentanaConsultaTurno extends JFrame {
	
	private JTextField dniPaciente;
	private JButton salir ;
	private JButton buscar ;
	private JTable tabla;
	
	public VentanaConsultaTurno()
	{
		setTitle("CONSULTA DE TURNOS");
		getContentPane().setLayout(null);
		setSize(470, 282);
		setLocationRelativeTo(null);
		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 473, 249);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		JLabel tituloPrincipal = new JLabel("CONSULTA DE TURNO");
		tituloPrincipal.setFont(new Font("Arial", Font.BOLD, 20));
		tituloPrincipal.setBounds(99, 11, 263, 30);
		laminaPrincipal.add(tituloPrincipal);
		
		JLabel mjeDniPaciente = new JLabel("DNI Paciente");
		mjeDniPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		mjeDniPaciente.setBounds(73, 63, 79, 14);
		laminaPrincipal.add(mjeDniPaciente);
		
		dniPaciente = new JTextField();
		dniPaciente.setBounds(222, 60, 125, 20);
		laminaPrincipal.add(dniPaciente);
		dniPaciente.setColumns(10);
		
		buscar = new JButton();
		buscar.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaAdministrador\\buscar.jpg"));
		buscar.setBounds(99, 172, 50, 50);
		laminaPrincipal.add(buscar);
		
		JLabel msjeBuscar = new JLabel("Buscar");
		msjeBuscar.setFont(new Font("Arial", Font.BOLD, 12));
		msjeBuscar.setBounds(99, 223, 46, 14);
		laminaPrincipal.add(msjeBuscar);
		
		salir = new JButton();
		salir.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaMedico\\salir.png"));
		salir.setBounds(312, 172, 50, 50);
		laminaPrincipal.add(salir);
		
		JLabel msjeSalir = new JLabel("Salir");
		msjeSalir.setFont(new Font("Arial", Font.BOLD, 12));
		msjeSalir.setBounds(318, 223, 65, 14);
		laminaPrincipal.add(msjeSalir);
		
		
		
		tabla = new JTable();
		JScrollPane barraDesplazamientoTabla = new JScrollPane(tabla);
		barraDesplazamientoTabla.setBounds(10, 88, 439, 41);
		laminaPrincipal.add(barraDesplazamientoTabla);
		 
		 
		ControlVentanaConsultaTurno cVCT=new ControlVentanaConsultaTurno(this);
		
		buscar.addActionListener(cVCT);
		salir.addActionListener(cVCT);
		
		 

	}

	public String getDniPaciente() {
		return dniPaciente.getText();
	}

	public void setDniPaciente(JTextField dniPaciente) {
		this.dniPaciente = dniPaciente;
	}

	public JButton getsalir() {
		return salir;
	}

	public void setsalir(JButton cancelar) {
		this.salir = cancelar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTable getTabla() {
		return tabla;
	}
	
	
}
