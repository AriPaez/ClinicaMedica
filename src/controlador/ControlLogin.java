package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import vista.Login;

public class ControlLogin implements ActionListener
{
	private Login login;
	private PreparedStatement autenticacion;
	private ConexionBBDD conexionBBDD;
	
	//Constructor por defecto.
	public ControlLogin()
	{
		 
	}
	
	public ControlLogin(Login l)
	{
		login=l;
		conexionBBDD=new ConexionBBDD();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		 Object botonElegido=e.getSource();
		 
		 if(botonElegido==login.getRegistrar())
		 {
			 
			 if(login.getCargo().getSelectedItem().equals("Medico"))
			 {
				try 
				{
					autenticacion=conexionBBDD.getConexionBBDD().
					prepareStatement("SELECT dni,password FROM "
					+ "login.getCargo().getSelectedItem()"
					+ "WHERE dni=? and password=?");
					
					autenticacion.setString(1,login.getIngresoDNI().getSelectedText());
					autenticacion.setString(2,login.getIngresoPass().getSelectedText());
					
					ResultSet tabla = autenticacion.executeQuery();
					
					if (tabla.absolute(1))
					{
						  //Aca se llama a la ventana del medico.
					}
					else
					{
						 JOptionPane.showMessageDialog(null,
						"No se ha encontrado el usuario","BBDD",2, null); 
					}
					
				}
				catch (SQLException e1) 
				{
					 JOptionPane.showMessageDialog(null,
					 "No se ha encontrado el usuario","BBDD",2, null);
				}
			 }
			 else
			 {
				 try 
				 {
					autenticacion=conexionBBDD.getConexionBBDD().
					prepareStatement("SELECT dni,password FROM "
					+ "login.getCargo().getSelectedItem()"
					+ "WHERE dni=? and password=?");
					
					autenticacion.setString(1,login.getIngresoDNI().getSelectedText());
					autenticacion.setString(2,login.getIngresoPass().getSelectedText());
					
					ResultSet tabla = autenticacion.executeQuery();
					
					if (tabla.absolute(1))
					{
						  //Aca se llama a la ventana del administrador.
					}
					else
					{
						 JOptionPane.showMessageDialog(null,
						"No se ha encontrado el usuario","BBDD",2, null); 
					}
				 
				 }
				 catch (SQLException e1)
				 {
					 JOptionPane.showMessageDialog(null,
					 "No se ha encontrado el usuario","BBDD",2, null);
				 }
			 }
			 
			 
		 }
		 else
		 {
			 
		 }
		 
		 
	}

}
