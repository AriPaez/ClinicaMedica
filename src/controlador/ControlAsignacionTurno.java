package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.VentanaAdministrador;
import vista.VentanaAsignacionTurno;

public class ControlAsignacionTurno extends WindowAdapter implements ActionListener,PropertyChangeListener,ItemListener {

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
			
			 
		}
		else
		{
			vetanaAsignacionTurno.dispose();
			
			VentanaAdministrador vA=new VentanaAdministrador();
			vA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vA.setVisible(true);
		}
			
		
	}
	
	//Al abrirse la VentanaAsignacionTurno se ejecuta windowOpened
	//para cargar las especialides en el comboBox especialides
	public void windowOpened(WindowEvent e)
	{
		 
		try
		{
			Statement especialides=conexionBBDD
			.getConexionBBDD().createStatement();
			 
			ResultSet tabla=especialides.executeQuery("SELECT DISTINCT especialidad"
			+" FROM Medico");
			
			while(tabla.next())
			{
				vetanaAsignacionTurno.setEspecialidad(tabla.getString(1));
			}
			
			 
		} 
		catch (SQLException e1) 
		{
			 
			e1.printStackTrace();
		}
	}
	
	 
	//Al seleccionar una fecha se consulta en la BBDD
	//los horariosIncio de la tabla turno.
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Probando hora!"); 
		/*
		try 
		{
			CallableStatement fechaDeTurnosReservados=conexionBBDD
			.getConexionBBDD().prepareCall("{?=call fechaDeTurnosReservados(?,?)}") ;
		
			
			Date sqlDate = new Date(vetanaAsignacionTurno.getDateChooser().getTime());
			
			fechaDeTurnosReservados.setDate(1,sqlDate);
			fechaDeTurnosReservados.setString(2, vetanaAsignacionTurno.getd);
			
			
		
		}
		catch (SQLException e) 
		{
			 
			e.printStackTrace();
		}*/
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		 
	     if (e.getStateChange() == e.SELECTED) 
	     {
	    	 //Borra todos los item agregados de otras selecciones
	    	 //del combo
	    	 vetanaAsignacionTurno.getProfesional().removeAllItems(); 
	    	 
	    	String especialidad = (String) vetanaAsignacionTurno.getEspecialidad().getSelectedItem();
	 		 
	 		try
	 		{
	 			PreparedStatement cargaDeProfesionales=conexionBBDD
	 			.getConexionBBDD().prepareStatement("SELECT DISTINCT  primerNombre,segundoNombre,apellido"
	 			+" FROM Medico WHERE especialidad=?");

	 			cargaDeProfesionales.setString(1,especialidad);
	 			
	 			ResultSet tabla=cargaDeProfesionales.executeQuery();
	 			
	 			while(tabla.next())
	 			{
	 				vetanaAsignacionTurno.setProfesional("Dr. "+tabla.getString(1)+" "+
	 				tabla.getString(2)+" "+tabla.getString(3)); 
	 			}
	 		} 
	 		catch (SQLException ee) 
	 		{
	 			ee.printStackTrace();
	 		}
	     }  
		
	}

}
