package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vista.Login;
import vista.TipoUsuario;
import vista.VentanaAdministrador;
import vista.VentanaMedico;

public class ControlLoginRegistro implements ActionListener {

	private PreparedStatement autenticacion;
	private ConexionBBDD conexionBBDD;
	private Login login;
	private TipoUsuario tipoUsuario;
	private String dniUsuario;
	public ControlLoginRegistro(Login l) {
		login = l;
		conexionBBDD = new ConexionBBDD();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 
		
		Object botonElegido = e.getSource();

		if (botonElegido==login.getIniciarSesion()) {
			
			String cargo = (String) login.getCargo().getSelectedItem();

			if (cargo.equals("Medico")) {
				try {

					autenticacion = conexionBBDD.getConexionBBDD().prepareStatement(
							"SELECT dniMedico,contrasenia FROM Medico WHERE dniMedico=? and contrasenia=?");

					autenticacion.setString(1, login.getIngresoDNI().getText());
					char[] arrayC = login.getIngresoPass().getPassword();
					String pass = new String(arrayC);
					autenticacion.setString(2, pass);

					ResultSet tabla = autenticacion.executeQuery();

					boolean sesion = false;

					while (tabla.next() && !sesion) {
						sesion = true;

					}

					if (sesion) {
						JOptionPane.showMessageDialog(null, "Iniciado Correctamente", "BBDD", 1, null);

						// Cierre de la ventana login.
						login.dispose();

						// Aca se llama a la ventana del Medico.
						VentanaMedico v = new VentanaMedico();
						v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						v.setVisible(true);

						conexionBBDD.cerrarConexionBBDD();

					}
					else
					{
						JOptionPane.showMessageDialog(null, "No encontrado. Vuelva a ingresar", "BBDD", 2, null);
						
						//Reseteo de datos ingresados login
						 login.setIngresoDNI("");
						 login.setIngresoPass("");
					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario", "BBDD", 2, null);
				}
			} else {
				try {

					autenticacion = conexionBBDD.getConexionBBDD().prepareStatement(
							"SELECT dniAdministrador,contrasenia FROM Administrador WHERE dniAdministrador=? and contrasenia=?");

					autenticacion.setString(1, login.getIngresoDNI().getText());
					char[] arrayC = login.getIngresoPass().getPassword();
					dniUsuario = new String(arrayC);
					
					autenticacion.setString(2, dniUsuario);
					ResultSet tabla = autenticacion.executeQuery();

					boolean sesion = false;

					while (tabla.next() && !sesion) {
						sesion = true;

					}

					if (sesion) {

						JOptionPane.showMessageDialog(null, "Iniciado Correctamente", "BBDD", 1, null);

						login.dispose();
						// Aca se llama a la ventana del administrador.
						VentanaAdministrador v = new VentanaAdministrador();
						v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						v.setVisible(true);

						conexionBBDD.cerrarConexionBBDD();

					}
					else {

						JOptionPane.showMessageDialog(null, "No encontrado. Vuelva a ingresar", "BBDD", 2, null);
						
						//Reseteo de datos ingresados login
						 login.setIngresoDNI("");
						 login.setIngresoPass("");
					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario", "BBDD", 2, null);
				}

			}

		} else if (botonElegido == login.getRegistrar()) {

			// Cierre de la vetana login.
			login.dispose();

			// Acá se llama a la ventana de tipoUsuario.
			tipoUsuario = new TipoUsuario();
			tipoUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tipoUsuario.setVisible(true);
		}

	}
 
}
