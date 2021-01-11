package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.Login;
import vista.RegistroAdministrador;
import vista.RegistroMedico;

public class ControlRegistro implements ActionListener {
	private RegistroMedico registroMedico;
	private RegistroAdministrador registroAdministrador;
	private ConexionBBDD conexionBBDD;

	//Constructor por defecto.
	public ControlRegistro()
	{
		 
		
	}
	
	
	public ControlRegistro(RegistroAdministrador rA) {
		registroAdministrador=rA;
		
		
	}
	
	public ControlRegistro(RegistroMedico rM) {
		registroMedico=rM;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		conexionBBDD = new ConexionBBDD();
		
		
		try {
 
			
			if (ControlTipoUsuario.getTipoUsuarioElegido()=="Medico") {
				System.out.println("Hola, regisntrando medico");
				 
				
				CallableStatement registrarMedico = conexionBBDD.getConexionBBDD()
				.prepareCall("{call registrarMedico(?,?,?,?,?,?,?,?)}");


				registrarMedico.setString(1, registroMedico.getIngresoDNI());
				registrarMedico.setString(2, registroMedico.getIngresoPrimerNombre());
				registrarMedico.setString(3, registroMedico.getIngresoSegundoNombre());
				registrarMedico.setString(4, registroMedico.getIngresoApellido());
				registrarMedico.setString(5,ControlTipoUsuario.getTipoUsuarioElegido());
				registrarMedico.setInt(6, registroMedico.getIngresoConsultorio());
				registrarMedico.setString(7, registroMedico.getIngresoEspecialidad());
				registrarMedico.setString(8, registroMedico.getIngresoPass());

				registrarMedico.execute();

				
				JOptionPane.showMessageDialog(null, "Registrado Correctamente", "BBDD", 1, null);
				
				//Cierre de la ventana registroMedico.
				registroMedico.dispose();
				
				//Una vez registrado, se abra nuevamente la ventana login.
				Login l=new Login();
				l.setVisible(true);
				
				conexionBBDD.cerrarConexionBBDD();
			} 
			else
			{
				 
				
				CallableStatement registraAdmnistrador = conexionBBDD.getConexionBBDD()
				.prepareCall("{call registrarAdministrador(?,?,?,?,?,?)}");

				registraAdmnistrador.setString(1, registroAdministrador.getIngresoDNI());
				registraAdmnistrador.setString(2, registroAdministrador.getIngresoPrimerNombre());
				registraAdmnistrador.setString(3, registroAdministrador.getIngresoSegundoNombre());
				registraAdmnistrador.setString(4, registroAdministrador.getIngresoApellido());
				registraAdmnistrador.setString(5,ControlTipoUsuario.getTipoUsuarioElegido());
				registraAdmnistrador.setString(6, registroAdministrador.getIngresoPass());

				registraAdmnistrador.execute();

				
				JOptionPane.showMessageDialog(null, "Registrado Correctamente", "BBDD", 1, null);
				
				//Cierre de la ventana registroAdministrador.
				registroAdministrador.dispose();
				
				//Una vez registrado, se abra nuevamente la ventana login.
				Login l=new Login();
				l.setVisible(true);
				
				conexionBBDD.cerrarConexionBBDD();
			 
			}

			
			
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}

}
