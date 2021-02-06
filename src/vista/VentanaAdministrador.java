package vista;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ControlNotificacion;
import controlador.ControlVentanaAdministrador;

public class VentanaAdministrador extends JFrame {


	private JButton consultarTurno;
	private JButton asignarTurno;
	private JButton sobreTurno;
	private JButton registrarPaciente;
	private JLabel msjeAsignarTurno;
	private JLabel msjeConsultarTurno;
	private JLabel msjeSobreTurno;
	private JLabel msjeRegistrarPaciente;
	private Notificacion notificaciones;
	 
	public VentanaAdministrador() {

	 
		setBounds(400, 400, 350, 324);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setTitle("Sesión Administrador");

		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 334, 285);
		laminaPrincipal.setLayout(null);
		getContentPane().add(laminaPrincipal);

		JLabel msjeTituloPrincipal = new JLabel("SISTEMA M\u00C9DICO");
		msjeTituloPrincipal.setFont(new Font("Arial", Font.PLAIN, 30));
		msjeTituloPrincipal.setBounds(48, 11, 269, 36);
		laminaPrincipal.add(msjeTituloPrincipal);

		JLabel msjePanelDeControl = new JLabel("PANEL DE CONTROL");
		msjePanelDeControl.setFont(new Font("Arial", Font.BOLD, 12));
		msjePanelDeControl.setBounds(10, 51, 128, 36);
		laminaPrincipal.add(msjePanelDeControl);

		consultarTurno = new JButton("");
		consultarTurno.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaAdministrador\\consultarTurno.png"));
		consultarTurno.setBounds(221, 98, 50, 50);
		laminaPrincipal.add(consultarTurno);

		asignarTurno = new JButton("");
		asignarTurno.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaAdministrador\\asignarTurno.png"));
		asignarTurno.setBounds(68, 98, 50, 50);
		laminaPrincipal.add(asignarTurno);

		sobreTurno = new JButton("");
		sobreTurno.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaAdministrador\\sobreTurno.png"));
		sobreTurno.setBounds(68, 192, 50, 50);
		laminaPrincipal.add(sobreTurno);

		registrarPaciente = new JButton("");
		registrarPaciente.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaAdministrador\\registrarPaciente.png"));
		registrarPaciente.setBounds(221, 192, 50, 50);
		laminaPrincipal.add(registrarPaciente);

		 
		notificaciones=new Notificacion();
		notificaciones.setBounds(291, 43, 33, 29);
		laminaPrincipal.add(notificaciones);
		
		msjeAsignarTurno = new JLabel("Asignar Turno");
		msjeAsignarTurno.setFont(new Font("Arial", Font.BOLD, 12));
		msjeAsignarTurno.setBounds(52, 156, 86, 14);
		laminaPrincipal.add(msjeAsignarTurno);
		
		msjeConsultarTurno = new JLabel("ConsultarTurno");
		msjeConsultarTurno.setFont(new Font("Arial", Font.BOLD, 12));
		msjeConsultarTurno.setBounds(202, 159, 99, 14);
		laminaPrincipal.add(msjeConsultarTurno);
		
		msjeSobreTurno = new JLabel("Sobre Turno");
		msjeSobreTurno.setFont(new Font("Arial", Font.BOLD, 12));
		msjeSobreTurno.setBounds(48, 253, 90, 14);
		laminaPrincipal.add(msjeSobreTurno);
		
		msjeRegistrarPaciente = new JLabel("Registrar Paciente");
		msjeRegistrarPaciente.setFont(new Font("Arial", Font.BOLD, 12));
		msjeRegistrarPaciente.setBounds(202, 253, 106, 14);
		laminaPrincipal.add(msjeRegistrarPaciente);
		
		
		ControlVentanaAdministrador cVA =new ControlVentanaAdministrador(this);

		consultarTurno.addActionListener(cVA);
		asignarTurno.addActionListener(cVA);
		sobreTurno.addActionListener(cVA);
		registrarPaciente.addActionListener(cVA);
		notificaciones.addActionListener(cVA);
		
		ControlNotificacion cN=new ControlNotificacion(this);
		
		addWindowListener(cN);

	}

	public JButton getConsultarTurno() {
		return consultarTurno;
	}

	public JButton getAsignarTurno() {
		return asignarTurno;
	}

	public JButton getSobreTurno() {
		return sobreTurno;
	}

	public JButton getRegistrarPaciente() {
		return registrarPaciente;
	}

	public Notificacion getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(int valor) {
		
		this.notificaciones.setNumero(valor);
	}
	 
	
}
