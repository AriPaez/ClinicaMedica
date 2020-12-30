package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.ConexionBBDD;

public class BBDD 
{
	
	private ConexionBBDD conexionBBDD;
	private ResultSet tabla;
	
	public BBDD()
	{
		conexionBBDD=new ConexionBBDD();
		
	}
	
	public void setSentenciaSQL(String instruccionSQL)
	{
		try 
		{
			Statement sentenciaSQL=conexionBBDD.getConexionBBDD().createStatement();
			tabla=sentenciaSQL.executeQuery(instruccionSQL);
		}
		catch (SQLException e)
		{
			 
		}
	}
	
	public ResultSet getTabla()
	{
		return tabla;
	}
	 	
}
