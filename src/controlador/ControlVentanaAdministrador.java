package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.VentanaAdministrador;
import vista.VentanaAsignacionSobreTurno;
import vista.VentanaAsignacionTurno;
import vista.VentanaConsultaTurno;
import vista.VentanaRegistrarPaciente;

public class ControlVentanaAdministrador implements ActionListener 
{
	
	private VentanaAdministrador ventanaAdministrador;
	 
	
	public ControlVentanaAdministrador(VentanaAdministrador vA)
	{
		ventanaAdministrador=vA;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
	 
		Object botonSeleccionado= e.getSource();
		
		if(botonSeleccionado==ventanaAdministrador.getNotificaciones())
		{
		
			System.out.println("noificaciones");
			
		}
		else if(botonSeleccionado==ventanaAdministrador.getAsignarTurno())
		{
			ventanaAdministrador.dispose();
			VentanaAsignacionTurno vAT=new VentanaAsignacionTurno();
			ventanaAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vAT.setVisible(true);
		}
		else if(botonSeleccionado==ventanaAdministrador.getConsultarTurno())
		{
			ventanaAdministrador.dispose();
			VentanaConsultaTurno vCT=new VentanaConsultaTurno();
			vCT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vCT.setVisible(true);
			
		}
		else if(botonSeleccionado==ventanaAdministrador.getSobreTurno())
		{
			//Cierre de la ventanaAdministrador.
			ventanaAdministrador.dispose();
			VentanaAsignacionSobreTurno sobreTurno=new VentanaAsignacionSobreTurno();
			//Apertura de la ventana VentanaAsignacionSobreTurno
			sobreTurno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			sobreTurno.setVisible(true);
		}
		else if(botonSeleccionado==ventanaAdministrador.getRegistrarPaciente())
		{
			//Cierre de la ventanaAdministrador.
			ventanaAdministrador.dispose();
			VentanaRegistrarPaciente registrarPaciente=new VentanaRegistrarPaciente();
			//Apertura de la venenta VentanaRegistrarPaciente
			registrarPaciente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			registrarPaciente.setVisible(true);
		}
		
	}

}
