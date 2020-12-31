package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import vista.Login;
import vista.Registro;

public class ControlRegistro implements ActionListener {
	private Registro registro;
	private ConexionBBDD conexionBBDD;

	public ControlRegistro(Registro r) {
		registro = r;
		conexionBBDD = new ConexionBBDD();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			String TipoCargo=(String)registro.getTipocargo().getSelectedItem();
			
			 
			
			if (TipoCargo.equals("Medico")) {
				
				CallableStatement registrarMedico = conexionBBDD.getConexionBBDD()
				.prepareCall("{call registrarMedico(?,?,?,?,?,?)}");

				registrarMedico.setString(1, registro.getIngresoDNI());
				registrarMedico.setString(2, registro.getIngresoPrimerNombre());

				registrarMedico.setString(3, registro.getIngresoSegundoNombre());
				registrarMedico.setString(4, registro.getIngresoApellido());
				registrarMedico.setString(5,TipoCargo);
				registrarMedico.setString(6, registro.getIngresoPass());

				registrarMedico.execute();

				conexionBBDD.cerrarConexionBBDD();
			} 
			else
			{
				CallableStatement registraAdmnistrador = conexionBBDD.getConexionBBDD()
				.prepareCall("{call registrarAdministrador(?,?,?,?,?,?)}");

				registraAdmnistrador.setString(1, registro.getIngresoDNI());
				registraAdmnistrador.setString(2, registro.getIngresoPrimerNombre());

				registraAdmnistrador.setString(3, registro.getIngresoSegundoNombre());
				registraAdmnistrador.setString(4, registro.getIngresoApellido());
				registraAdmnistrador.setString(5,TipoCargo);
				registraAdmnistrador.setString(6, registro.getIngresoPass());

				registraAdmnistrador.execute();

				conexionBBDD.cerrarConexionBBDD();
			}

			JOptionPane.showMessageDialog(null, "Registrado Correctamente'", "BBDD", 1, null);

			registro.dispose();
			
			Login l=new Login();
			l.setVisible(true);
			
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}

}
