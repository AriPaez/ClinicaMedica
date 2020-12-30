package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConexionBBDD {

	private Connection conexionABBDD;
	
	
	public ConexionBBDD() 
	{
		try 
		{
			conexionABBDD = DriverManager
			.getConnection("jdbc:sqlserver://;database=SistemaMedico;integratedSecurity=true;");
		
		} catch (SQLException e) 
		{
			
			JOptionPane.showMessageDialog(null,
			"No se ha podido conecta a la BBDD 'Sistema Médico'","BBDD",2, null);
			 
		}

	}
	
	
	
	
	public Connection getConexionBBDD()
	{
		return conexionABBDD;
	}
	
}
