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
import java.sql.Time;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.VentanaAdministrador;
import vista.VentanaAsignacionTurno;

public class ControlAsignacionTurno extends WindowAdapter implements ActionListener,PropertyChangeListener,ItemListener {

	private VentanaAsignacionTurno vetanaAsignacionTurno;
	private ConexionBBDD conexionBBDD;
	private LinkedList<String> listaDeDniMedicos;
	private String dniMedico;
	private Time  horaInicio;
	private Time  horaFin;
	private boolean controlAsignacionTurno;
	
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
				 
				PreparedStatement dniPaciente=conexionBBDD.getConexionBBDD().prepareStatement("SELECT dniPaciente"
				+" FROM Paciente WHERE dniPaciente=?");
				
				dniPaciente.setString(1,vetanaAsignacionTurno.getDniPaciente());
				
				 
				//4-Se almacena la consulta en una tabla virtual. 
				ResultSet tabla=dniPaciente.executeQuery();
				
				boolean sesion = false;

				while (tabla.next() && !sesion) {
					sesion = true;

				}

				if(sesion==false)
				{
					JOptionPane.showMessageDialog(null, "No encontrado. Vuelva a ingresar"
					+ " el dni del paciente.\nNota: Asegúrese de que el paciente se encuentre registrado", "BBDD", 2, null);
					
					//Reseteo de datos ingresados dni
					vetanaAsignacionTurno.setDniPaciente("");
					
				}
				
				
				  
				CallableStatement asignarTurno=conexionBBDD.getConexionBBDD()
				.prepareCall("{call asignarTurno(?,?,?,?,?)}") ;
				asignarTurno.setDate(1, new Date(vetanaAsignacionTurno.getDateChooser().getTime()));
				asignarTurno.setTime(2,this.horaInicio);
				asignarTurno.setTime(3,this.horaFin);
				asignarTurno.setString(4,vetanaAsignacionTurno.getDniPaciente());
				asignarTurno.setString(5,dniMedico);
				
				asignarTurno.execute();
				
				JOptionPane.showMessageDialog(null, 
				"Turno asignado correctamente para el paciente con dni: "+vetanaAsignacionTurno.getDniPaciente()
				+"\n para el día "+new Date(vetanaAsignacionTurno.getDateChooser().getTime())+ " y horario: "+this.horaInicio+" a "+this.horaFin,
				"BBDD", 1, null);
				
				
				vetanaAsignacionTurno.dispose();
				
				VentanaAdministrador vA=new VentanaAdministrador();
				vA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				vA.setVisible(true);
				
				
			}
			catch (SQLException e1)
			{
				JOptionPane.showMessageDialog(null, 
				"Error de BBDD", "BBDD", 2, null);

				e1.printStackTrace();
			}
			

			 
		}
		else if(botonElegido==vetanaAsignacionTurno.getCancelarTurno())
		{
			vetanaAsignacionTurno.dispose();
			
			VentanaAdministrador vA=new VentanaAdministrador();
			vA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vA.setVisible(true);
		}
		else
		{
			//Aca al presionar se un radioButton se almacena en las variables horaInicio horaFin el horario selecionado.
			
			if(vetanaAsignacionTurno.getT1().isSelected())
			{
				this.horaInicio=vetanaAsignacionTurno.getTurno1HoraInicio();
				this.horaFin=vetanaAsignacionTurno.getTurno1HoraFin();
			}
			if(vetanaAsignacionTurno.getT2().isSelected())
			{
				this.horaInicio=vetanaAsignacionTurno.getTurno2HoraInicio();
				this.horaFin=vetanaAsignacionTurno.getTurno2HoraFin();
			}
			if(vetanaAsignacionTurno.getT3().isSelected())
			{
				this.horaInicio=vetanaAsignacionTurno.getTurno3HoraInicio();
				this.horaFin=vetanaAsignacionTurno.getTurno3HoraFin();
			}
			if(vetanaAsignacionTurno.getT4().isSelected())
			{
				this.horaInicio=vetanaAsignacionTurno.getTurno4HoraInicio();
				this.horaFin=vetanaAsignacionTurno.getTurno4HoraFin();
			}
			if(vetanaAsignacionTurno.getT5().isSelected())
			{
				this.horaInicio=vetanaAsignacionTurno.getTurno5HoraInicio();
				this.horaFin=vetanaAsignacionTurno.getTurno5HoraFin();
			}
			if(vetanaAsignacionTurno.getT6().isSelected())
			{
				this.horaInicio=vetanaAsignacionTurno.getTurno6HoraInicio();
				this.horaFin=vetanaAsignacionTurno.getTurno6HoraFin();
			}
			if(vetanaAsignacionTurno.getT7().isSelected())
			{
				this.horaInicio=vetanaAsignacionTurno.getTurno7HoraInicio();
				this.horaFin=vetanaAsignacionTurno.getTurno7HoraFin();
			}
			if(vetanaAsignacionTurno.getT8().isSelected())
			{
				this.horaInicio=vetanaAsignacionTurno.getT8HoraInicio();
				this.horaFin=vetanaAsignacionTurno.getTurno8HoraFin();
			}
			if(vetanaAsignacionTurno.getT9().isSelected())
			{
				this.horaInicio=vetanaAsignacionTurno.getTurno9HoraInicio();
				this.horaFin=vetanaAsignacionTurno.getTurno9HoraFin();
			}
			if(vetanaAsignacionTurno.getT10().isSelected())
			{
				this.horaInicio=vetanaAsignacionTurno.getTurno10HoraInicio();
				this.horaFin=vetanaAsignacionTurno.getT10HoraFin();
			}
		}
		
		if(controlAsignacionTurno)
		{
			controlarHorarioDeTurnoOcupado();
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
		 
		if(vetanaAsignacionTurno.getDateChooser()!=null)
		{
			controlarHorarioDeTurnoOcupado();
		}
		
	 
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		Object comboboxElegido=e.getSource();
		 
		if(comboboxElegido==vetanaAsignacionTurno.getEspecialidad())
		 {
			 
		     if (e.getStateChange() == ItemEvent.SELECTED) 
		     {
		    	 //Borra todos los item agregados de otras selecciones
		    	 //del combo
		    	 vetanaAsignacionTurno.getProfesional().removeAllItems(); 
		    	 
		    	String especialidad = (String) vetanaAsignacionTurno.getEspecialidad().getSelectedItem();
		 		 
		 		try
		 		{
		 			PreparedStatement cargaDeProfesionales=conexionBBDD
		 			.getConexionBBDD().prepareStatement("SELECT DISTINCT dniMedico,primerNombre,segundoNombre,apellido"
		 			+" FROM Medico WHERE especialidad=?");
	
		 			cargaDeProfesionales.setString(1,especialidad);
		 			
		 			ResultSet tabla=cargaDeProfesionales.executeQuery();
		 			
		 			listaDeDniMedicos=new LinkedList<String>();
		 			
		 			while(tabla.next())
		 			{   
		 				listaDeDniMedicos.add(tabla.getString(1));
		 				vetanaAsignacionTurno.setProfesional("Dr. "+tabla.getString(2)+" "+
		 				tabla.getString(3)+" "+tabla.getString(4)); 
		 			}
		 		} 
		 		catch (SQLException ee) 
		 		{
		 			ee.printStackTrace();
		 		}
		     }
	     
		 }
		 else
		{
			if (e.getStateChange() == ItemEvent.SELECTED) {
				
				//Aca se determina el dniMedico seleccionado en el
				//combobox profesionales.
				int posicionDeComboBoxSeleccionado=vetanaAsignacionTurno.getProfesional().getSelectedIndex();
				dniMedico=listaDeDniMedicos.get(posicionDeComboBoxSeleccionado);
			 }
				
		}
	 			
		if(controlAsignacionTurno)
		{
			controlarHorarioDeTurnoOcupado();
		}
	}
	
	public void controlarHorarioDeTurnoOcupado()
	{
		//Esta se activa para saber que ya se ha ejcutado la fecha de turno;
		controlAsignacionTurno=true;
		
		//Activacion po defecto de radioButton  en caso de cambiarse la fecha de turno.
		
		vetanaAsignacionTurno.setTurno1(true);
		vetanaAsignacionTurno.setTurno2(true);
		vetanaAsignacionTurno.setTurno3(true);
		vetanaAsignacionTurno.setTurno4(true);
		vetanaAsignacionTurno.setTurno5(true);
		vetanaAsignacionTurno.setTurno6(true);
		vetanaAsignacionTurno.setTurno7(true);
		vetanaAsignacionTurno.setTurno8(true);
		vetanaAsignacionTurno.setTurno9(true);
		vetanaAsignacionTurno.setTurno10(true);
		
		
		
		try 
		{ 
			 
			//Desactivacion de radioButton en caso de ya exista en la BBDD
			CallableStatement horarioInicioTurnosReservados=
			conexionBBDD.getConexionBBDD()
			.prepareCall("{call horarioInicioTurnosReservados(?,?)}") ;
			
			horarioInicioTurnosReservados.setString(1,this.dniMedico);
			horarioInicioTurnosReservados.setDate(2,new Date(vetanaAsignacionTurno.getDateChooser().getTime()) );
			
			 
			ResultSet tabla=horarioInicioTurnosReservados.executeQuery();
			 
			while(tabla.next())
			{
				
				
				if(vetanaAsignacionTurno.getTurno1HoraInicio().equals(tabla.getTime(1)))
				{ 
					vetanaAsignacionTurno.setTurno1(false);
				}
				if(vetanaAsignacionTurno.getTurno2HoraInicio().equals(tabla.getTime(1)))
				{
					vetanaAsignacionTurno.setTurno2(false);
				}
				if(vetanaAsignacionTurno.getTurno3HoraInicio().equals(tabla.getTime(1)))
				{
					vetanaAsignacionTurno.setTurno3(false);
				}
				if(vetanaAsignacionTurno.getTurno4HoraInicio().equals(tabla.getTime(1)))
				{
					vetanaAsignacionTurno.setTurno4(false);
				}
				if(vetanaAsignacionTurno.getTurno5HoraInicio().equals(tabla.getTime(1)))
				{
					vetanaAsignacionTurno.setTurno5(false);
				}
				if(vetanaAsignacionTurno.getTurno6HoraInicio().equals(tabla.getTime(1)))
				{
					vetanaAsignacionTurno.setTurno6(false);
				}
				if(vetanaAsignacionTurno.getTurno7HoraInicio().equals(tabla.getTime(1)))
				{
					vetanaAsignacionTurno.setTurno7(false);
				}
				if(vetanaAsignacionTurno.getT8HoraInicio().equals(tabla.getTime(1)))
				{
					vetanaAsignacionTurno.setTurno8(false);
				}
				if(vetanaAsignacionTurno.getTurno9HoraInicio().equals(tabla.getTime(1)))
				{
					vetanaAsignacionTurno.setTurno9(false);
				}
				if(vetanaAsignacionTurno.getTurno10HoraInicio().equals(tabla.getTime(1)))
				{
					vetanaAsignacionTurno.setTurno10(false);
				}
				 
			}
			
			  
		}
		catch (SQLException e) 
		{  
			e.printStackTrace();
		}
	
	 
	}  

}
		  
 
