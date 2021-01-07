package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.VentanaAdministrador;
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
			
			System.out.println("asignar turno");
		}
		else if(botonSeleccionado==ventanaAdministrador.getConsultarTurno())
		{
			
			System.out.println("turno");
			
		}
		else if(botonSeleccionado==ventanaAdministrador.getSobreTurno())
		{
			
			System.out.println("sobreturnp");
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
