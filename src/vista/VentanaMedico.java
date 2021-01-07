package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ControlVentanaMedico;

public class VentanaMedico extends JFrame
{
	private JButton planillaPacientes;
	private JButton turnoPacientes;
	
	
	public VentanaMedico()
	{
		 //Propiedades de la ventana principal.
		 setTitle("Sistema Médico");
		 setSize(400,300);
		 setLocationRelativeTo(null);
		 setResizable(false);
		 setLayout(new BorderLayout());
		 
		 //Propieades de la lamina superior
		 JPanel laminaSuperior=new JPanel();
		 laminaSuperior.setLayout(new FlowLayout());
		 JLabel tituloPrincipal=new JLabel("SISTEMA MÉDICO");
		 tituloPrincipal.setFont(new Font("Arial",Font.BOLD,40));
		 laminaSuperior.add(tituloPrincipal);
		 add(laminaSuperior,BorderLayout.NORTH);
		 
		 //Propieades de la laminaCentral
		 JPanel laminaCentral=new JPanel();
		 laminaCentral.setLayout(new FlowLayout());
		 JLabel panelDeControl=new JLabel("PANEL DE CONTROL MÉDICO");
		 laminaCentral.add(panelDeControl);
		 panelDeControl.setFont(new Font("Arial",Font.BOLD,25));
		 planillaPacientes=new JButton("PLANILLA PACIENTE");	 
		 laminaCentral.add(planillaPacientes);
		 turnoPacientes=new JButton("TURNO PACIENTE");
		 laminaCentral.add(turnoPacientes);
		 add(laminaCentral,BorderLayout.CENTER);
		 
		 
		 ControlVentanaMedico cVM=new ControlVentanaMedico(this);
		 
		 turnoPacientes.addActionListener(cVM);
		 planillaPacientes.addActionListener(cVM);
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

	

}
