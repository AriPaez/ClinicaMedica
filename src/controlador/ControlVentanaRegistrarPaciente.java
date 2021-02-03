package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import principal.VentanaAdministrador;
import vista.Login;
import vista.VentanaRegistrarPaciente;

public class ControlVentanaRegistrarPaciente implements ActionListener {

	private VentanaRegistrarPaciente registroPaciente;
	private VentanaAdministrador vA;
	private ConexionBBDD conexionBBDD;
	
	public ControlVentanaRegistrarPaciente(VentanaRegistrarPaciente rP)
	{
		registroPaciente=rP;
		vA=new VentanaAdministrador();
		conexionBBDD=new ConexionBBDD();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		Object botonElegido=e.getSource();
		
		if(botonElegido==registroPaciente.getGuardar())
		{
			try
			{
				CallableStatement registrarPaciente=conexionBBDD.getConexionBBDD().
				prepareCall("{call registrarPaciente(?,?,?,?,?,?,?,?)}");
				 
				 
				registrarPaciente.setString(1,registroPaciente.getIngresoDNI());
				
				/*
				 Un objeto de la clase java.sql.Date se instancia pasándole 
				 un tipo de dato long a su constructor. Esta situación la podemos aprovechar 
				 para convertir una fecha java.util.Date utilizando el 
				 método getTime() que devuelve un long.*/
				Date sqlDate = new Date(registroPaciente.
				getIngresoFechaNacimiento().getTime());
				registrarPaciente.setDate(2,sqlDate);
				registrarPaciente.setString(3,registroPaciente.getIngresoPrimerNombre());
				registrarPaciente.setString(4,registroPaciente.getIngresoSegundoNombre());
				registrarPaciente.setString(5,registroPaciente.getIngresoApellido());
				registrarPaciente.setString(6,registroPaciente.getIngresoCelular());
				registrarPaciente.setString(7,registroPaciente.getIngresoEmail());
				registrarPaciente.setString(8,Login.getDniUsuario().getText());
				
				registrarPaciente.execute();
				
				JOptionPane.showMessageDialog(null, "Registrado Correctamente", "BBDD", 1, null);
				
				conexionBBDD.cerrarConexionBBDD();
			 
				registroPaciente.dispose();
				 
				 vA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 vA.setVisible(true);
				 
				
			}
			catch (SQLException e1)
			{
				
				JOptionPane.showMessageDialog(null, "No se podido registrar! Vuelva a intentar.", "BBDD", 2, null);

				e1.printStackTrace();
			}
		}
		else
		{
			//Cierre de la ventanaRegistrarPaciente
			registroPaciente.dispose();
			
			//Apertura de la ventanaAdministrador.
			vA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vA.setVisible(true);
		}
		
		

	}

}
