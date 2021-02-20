package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ControlVentanaMedico;
import javax.swing.ImageIcon;

public class VentanaMedico extends JFrame {
	
	private  JButton turnoPacientes;
	private JButton planillaPacientes;
	private  JButton salir;
	
	public VentanaMedico()
	{
		 //Propiedades de la ventana principal.
		 setTitle("Sesión de Médico");
		 setSize(321,376);
		 setLocationRelativeTo(null);
		 setResizable(false);
		 getContentPane().setLayout(null);
		 
		 JLabel tituloPrincipal = new JLabel("SISTEMA M\u00C9DICO");
		 tituloPrincipal.setFont(new Font("Arial", Font.BOLD, 20));
		 tituloPrincipal.setBounds(71, 11, 177, 38);
		 getContentPane().add(tituloPrincipal);
		 
		 planillaPacientes = new JButton("");
		 planillaPacientes.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaMedico\\planillaPaciente.png"));
		 planillaPacientes.setBounds(55, 87, 50, 50);
		 getContentPane().add(planillaPacientes);
		 
		 JLabel msjePlanilaPaciente = new JLabel("Planilla Paciente");
		 msjePlanilaPaciente.setFont(new Font("Arial", Font.BOLD, 12));
		 msjePlanilaPaciente.setBounds(38, 148, 94, 14);
		 getContentPane().add(msjePlanilaPaciente);
		 
		 turnoPacientes = new JButton();
		 turnoPacientes.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaMedico\\turno.png"));
		 turnoPacientes.setBounds(198, 87, 50, 50);
		 getContentPane().add(turnoPacientes);
		 
		 JLabel msjeTurnoPacientes = new JLabel("Turno de Pacientes");
		 msjeTurnoPacientes.setFont(new Font("Arial", Font.BOLD, 12));
		 msjeTurnoPacientes.setBounds(171, 148, 110, 14);
		 getContentPane().add(msjeTurnoPacientes);
		 
		 salir = new JButton();
		 salir.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaMedico\\salir.png"));
		 salir.setBounds(125, 238, 50, 50);
		 getContentPane().add(salir);
		 
		 JLabel msjeSalir = new JLabel("Salir");
		 msjeSalir.setFont(new Font("Arial", Font.BOLD, 12));
		 msjeSalir.setBounds(135, 293, 26, 14);
		 getContentPane().add(msjeSalir);
		 
		 ControlVentanaMedico cVM=new ControlVentanaMedico(this);
		 
		 turnoPacientes.addActionListener(cVM);
		 planillaPacientes.addActionListener(cVM);
		 salir.addActionListener(cVM);
	}
	
	public JButton getPlanillaPacientes() 
	{
		return planillaPacientes;
	}

	public void setPlanillaPacientes(JButton planillaPacientes)
	{
		this.planillaPacientes = planillaPacientes;
	}

	public JButton getTurnoPacientes()
	{
		return turnoPacientes;
	}

	public void setTurnoPacientes(JButton turnoPacientes) 
	{
		this.turnoPacientes = turnoPacientes;
	}

	public JButton getSalir() {
		return salir;
	}
	
	
}
