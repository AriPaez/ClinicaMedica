package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import vista.VentanaAdministrador;

public class ControlNotificacion extends WindowAdapter{
 
	private VentanaAdministrador ventanaAdministrador;
	private ConexionBBDD conexionBBDD;
	private int cantidadDeInasistenciaDePacientes;
	
	public ControlNotificacion(VentanaAdministrador vA)
	{
		ventanaAdministrador=vA;
		conexionBBDD=new ConexionBBDD();
	}
	
	//Al abrirse la ventana verifica si existe pacientes que no ha conurrido
	//al turno mayor o igual a 4 veces consecutivos.
	public void windowOpened(WindowEvent e)
	{
		try
		{
			CallableStatement notificaciones=conexionBBDD.getConexionBBDD().
			prepareCall("{call notificaciones()}");
			  
			ResultSet tabla=notificaciones.executeQuery();
			 
			while(tabla.next())
			{
				//Si un paciente al faltado >=4 veces ==>
				//cantidadDeInasistenciaDePacientes para respectivamente
				//mostrar la notificacion en la campanilla de notificacion.
				if(tabla.getInt(2)>=4)
				{
					cantidadDeInasistenciaDePacientes++;
				}
			}
			 
			if(cantidadDeInasistenciaDePacientes>0)
			{
				ventanaAdministrador.getNotificaciones().setNumero(cantidadDeInasistenciaDePacientes);
			}
			  
			conexionBBDD.cerrarConexionBBDD();
		  
		}
		catch (SQLException e1){}
	}

}
