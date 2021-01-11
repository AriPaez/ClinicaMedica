package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.VentanaAdministrador;
import vista.VentanaAsignacionTurno;

public class ControlAsignacionTurno implements ActionListener {

	private VentanaAsignacionTurno vetanaAsignacionTurno;
	private ConexionBBDD conexionBBDD;
	
	public ControlAsignacionTurno(VentanaAsignacionTurno vAT)
	{
		vetanaAsignacionTurno=vAT;
		conexionBBDD=new ConexionBBDD();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object botonElegido=e.getSource();
		
		if(botonElegido==vetanaAsignacionTurno.getAsignarTurno())
		{
			//Se verifica existencia de dniPaciente en el sismtema.
			try 
			{
				PreparedStatement dniPaciente=conexionBBDD
				.getConexionBBDD().prepareStatement("SELECT dniPaciente"
				+"FROM Paciente WHERE dniPaciente=?");
			}
			catch (SQLException e1)
			{
				JOptionPane.showMessageDialog
				(null, "No existe paciente en la BBDD", "BBDD", 2, null);
				e1.printStackTrace();
			}
			
			//Se carga las especialides en el comboBox especialides.
			try
			{
				Statement especialides=conexionBBDD
				.getConexionBBDD().createStatement();
				 
				ResultSet tabla=especialides.executeQuery("SELECT especialidades"
				+ "FROM Medico");
				
				while(tabla.next())
				{
					vetanaAsignacionTurno.setEspecialidad(tabla.getString(7));
				}
				
				 
			} 
			catch (SQLException e1) 
			{
				 
				e1.printStackTrace();
			}
			 
		}
		else
		{
			vetanaAsignacionTurno.dispose();
			
			VentanaAdministrador vA=new VentanaAdministrador();
			vA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vA.setVisible(true);
		}
			
		
	}
	
	public void cargarProfesional()
	{
		String cargo = (String) vetanaAsignacionTurno.getEspecialidad().getSelectedItem();
		
		
		
	}

}
