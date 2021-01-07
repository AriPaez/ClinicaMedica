package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ControlLogin;
import controlador.ControlVentanaAdministrador;

public class VentanaAdministrador extends JFrame {

	private JButton consultarTurno;
	private JButton asignarTurno;
	private JButton sobreTurno;
	private JButton registrarPaciente;
	private JButton notificaciones;
 
	 
	public VentanaAdministrador() {

	 
		setBounds(400, 400, 450, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setTitle("Sistema Médico");

		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 420, 245);
		laminaPrincipal.setLayout(null);
		add(laminaPrincipal);

		JLabel msjeTituloPrincipal = new JLabel("SISTEMA M\u00C9DICO");
		msjeTituloPrincipal.setFont(new Font("Arial", Font.PLAIN, 30));
		msjeTituloPrincipal.setBounds(100, 11, 269, 36);
		laminaPrincipal.add(msjeTituloPrincipal);

		JLabel msjePanelDeControl = new JLabel("PANEL DE CONTROL");
		msjePanelDeControl.setFont(new Font("Arial", Font.BOLD, 12));
		msjePanelDeControl.setBounds(10, 51, 128, 36);
		laminaPrincipal.add(msjePanelDeControl);

		consultarTurno = new JButton("Consultar Turno");
		consultarTurno.setBounds(237, 111, 158, 59);
		laminaPrincipal.add(consultarTurno);

		asignarTurno = new JButton("Asignar Turno");
		asignarTurno.setBounds(32, 111, 165, 59);
		laminaPrincipal.add(asignarTurno);

		sobreTurno = new JButton("Sobreturno");
		sobreTurno.setBounds(32, 181, 165, 59);
		laminaPrincipal.add(sobreTurno);

		registrarPaciente = new JButton("Registrar Paciente");
		registrarPaciente.setBounds(237, 181, 159, 59);
		laminaPrincipal.add(registrarPaciente);

		notificaciones = new JButton("Notificaciones");
		notificaciones.setBounds(227, 58, 183, 36);
		laminaPrincipal.add(notificaciones);

		ControlVentanaAdministrador cVA = new ControlVentanaAdministrador(this);

		consultarTurno.addActionListener(cVA);
		asignarTurno.addActionListener(cVA);
		sobreTurno.addActionListener(cVA);
		registrarPaciente.addActionListener(cVA);
		notificaciones.addActionListener(cVA);

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

	public JButton getNotificaciones() {
		return notificaciones;
	}
	 
}
