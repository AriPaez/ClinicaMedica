package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.Login;
import vista.RegistroAdministrador;
import vista.RegistroMedico;
import vista.TipoUsuario;

public class ControlTipoUsuario implements ActionListener {

	private TipoUsuario tipoUsuario;
	private static String  tipoUsuarioElegido=null;
	
	//Constructor por defecto.
	public ControlTipoUsuario()
	{
		
	}
	
	
	
	public ControlTipoUsuario(TipoUsuario tU)
	{
		tipoUsuario=tU;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		Object botonElegido = e.getSource();
		
		
		if(botonElegido==tipoUsuario.getAdministrador())
		{
			tipoUsuarioElegido="Administrador";
			tipoUsuario.dispose();
			RegistroAdministrador rA=new RegistroAdministrador();
			rA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			rA.setVisible(true);
			
		}
		else if(botonElegido==tipoUsuario.getMedico())
		{
			tipoUsuarioElegido="Medico";
			tipoUsuario.dispose();
			RegistroMedico m=new RegistroMedico();
			m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			m.setVisible(true);
		}
		else
		{
			tipoUsuario.dispose();
			Login l=new Login();
			l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			l.setVisible(true);
		}
		
		

	}

	public static String getTipoUsuarioElegido() {
		return tipoUsuarioElegido;
	}
	
	

}
