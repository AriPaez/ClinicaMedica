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

public class VentanaConsultaTurno extends JFrame {
	
	private JTextField dniPaciente;
	private JTextArea areaDeDatos;
	private JButton cancelar ;
	private JButton buscar ;
	
	public VentanaConsultaTurno()
	{
		setTitle("CONSULTA DE TURNOS");
		getContentPane().setLayout(null);
		setSize(482, 282);
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
		
		areaDeDatos = new JTextArea();
		areaDeDatos.setEditable(false);
		areaDeDatos.setBounds(10, 105, 457, 30);
		laminaPrincipal.add(areaDeDatos);
		
		buscar = new JButton();
		buscar.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaAdministrador\\buscar.jpg"));
		buscar.setBounds(99, 162, 50, 50);
		laminaPrincipal.add(buscar);
		
		JLabel msjeBuscar = new JLabel("Buscar");
		msjeBuscar.setFont(new Font("Arial", Font.BOLD, 12));
		msjeBuscar.setBounds(99, 223, 46, 14);
		laminaPrincipal.add(msjeBuscar);
		
		cancelar = new JButton();
		cancelar.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\registrarPaciente\\cancelar.jpg"));
		cancelar.setBounds(308, 162, 50, 50);
		laminaPrincipal.add(cancelar);
		
		JLabel msjeCancelar = new JLabel("Cancelar");
		msjeCancelar.setFont(new Font("Arial", Font.BOLD, 12));
		msjeCancelar.setBounds(308, 223, 65, 14);
		laminaPrincipal.add(msjeCancelar);
		
		
		ControlVentanaConsultaTurno cVCT=new ControlVentanaConsultaTurno(this);
		
		buscar.addActionListener(cVCT);
		cancelar.addActionListener(cVCT);
		
		 

	}

	public String getDniPaciente() {
		return dniPaciente.getText();
	}

	public void setDniPaciente(JTextField dniPaciente) {
		this.dniPaciente = dniPaciente;
	}

	public JTextArea getAreaDeDatos() {
		return areaDeDatos;
	}

	public void setAreaDeDatos(JTextArea areaDeDatos) {
		this.areaDeDatos = areaDeDatos;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}
	
	
	
	
}
