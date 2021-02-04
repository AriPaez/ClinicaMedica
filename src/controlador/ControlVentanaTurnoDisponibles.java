package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.VentanaMedico;
import vista.VentanaTurnoDisponibles;

public class ControlVentanaTurnoDisponibles extends WindowAdapter implements ActionListener {

	private VentanaTurnoDisponibles ventanaTurnosDisponibles;
	private ConexionBBDD conexionBBDD;
	private VentanaMedico vM;

	public ControlVentanaTurnoDisponibles(VentanaTurnoDisponibles vTD) {
		ventanaTurnosDisponibles = vTD;
		conexionBBDD = new ConexionBBDD();
		vM = new VentanaMedico();
	}

	//Carga los datos de la tabla estudio y receta al area de texto
	//al abrise la ventana ventenaTurnosDisponible.
	public void windowOpened(WindowEvent e) {

		try {
			
			CallableStatement mostrarEstudioYReceta = conexionBBDD.getConexionBBDD()
			.prepareCall("{call mostrarEstudioYReceta()}");

			ResultSet tabla = mostrarEstudioYReceta.executeQuery();

			while (tabla.next()) {
				ventanaTurnosDisponibles.getTurnosPacientes()
				.append(tabla.getDate(1) + " " + tabla.getFloat(2) + " " + tabla.getFloat(3) + " "
				+ tabla.getString(4) + " " + tabla.getString(5) + " " + tabla.getString(6) + " "
				+ tabla.getString(7) + " " + tabla.getString(8) + " " + tabla.getString(9));
			}

		} catch (SQLException e1) {

			JOptionPane.showMessageDialog(null, e1.getMessage(), "BBDD", 2, null);
			ventanaTurnosDisponibles.setDniPaciente("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object botonElegido = e.getSource();

		if (botonElegido == ventanaTurnosDisponibles.getFiltrar()) {
			// Se registra asistencia de paciente al turno.
			try {
				CallableStatement filtrarEstudioYReceta = conexionBBDD.getConexionBBDD()
						.prepareCall("{call filtrarEstudioYReceta(?)}");

				filtrarEstudioYReceta.setString(1, ventanaTurnosDisponibles.getDniPaciente());

				ResultSet tabla = filtrarEstudioYReceta.executeQuery();

				while (tabla.next()) {
					ventanaTurnosDisponibles.getTurnosPacientes()
							.append(tabla.getDate(1) + " " + tabla.getFloat(2) + " " + tabla.getFloat(3) + " "
									+ tabla.getString(4) + " " + tabla.getString(5) + " " + tabla.getString(6) + " "
									+ tabla.getString(7) + " " + tabla.getString(8) + " " + tabla.getString(9));
				}

			} catch (SQLException e1) {

				JOptionPane.showMessageDialog(null, e1.getMessage(), "BBDD", 2, null);
				ventanaTurnosDisponibles.setDniPaciente("");
			}
		} else {
			cerrarVentanaTurnosDisponibles();
			abrirVentanaMedico();
		}

	}

	public void cerrarVentanaTurnosDisponibles() {

		ventanaTurnosDisponibles.dispose();
		vM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vM.setVisible(true);
	}

	public void abrirVentanaMedico() {
		ventanaTurnosDisponibles.dispose();
		vM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vM.setVisible(true);
	}

}
