package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import vista.PlanillaPaciente;

public class ControlPlanillaPaciente implements ActionListener
{
	private PlanillaPaciente panillaPaciente;
	private ConexionBBDD conexionBBDD;
	
	public ControlPlanillaPaciente(PlanillaPaciente p)
	{
		panillaPaciente=p;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object botonElegido = e.getSource();
		
		if(botonElegido==panillaPaciente.getCargar())
		{
			//Aca se carga en la BBDD.
			
			try
			{ 
				
				PreparedStatement dniPaciente=conexionBBDD.getConexionBBDD()
				.prepareStatement("SELECT dniPaciente,max(fecha) FROM Turno"
				 +"WHERE dniPaciente=? GROUP BY dniPaciente ");
				
				dniPaciente.setString(1,panillaPaciente.getIngresoDNIPaciente());
				
				ResultSet tabla=dniPaciente.executeQuery();
				
				 boolean dniPacienteEncontrado=false;
				
				 while(tabla.next() && !dniPacienteEncontrado)
				 {
					 dniPacienteEncontrado=true;
				 }
				
				 if(dniPacienteEncontrado)
				 {
					 System.out.println("Existe paciente");
				 }
				 else
				 {
					 System.out.println("No existe");
				 }
				 
			
			}
			catch (SQLException e1) 
			{
				 
				 JOptionPane.showMessageDialog(null,
				 "Paciente no encontrado","BBDD",1, null);
				e1.printStackTrace();
			}
			
		}
		else
		{
			//Aca se cierra la ventana PlanillaPaciente.
			panillaPaciente.dispose();
		}
		 
		
	}
	
	
	

}
