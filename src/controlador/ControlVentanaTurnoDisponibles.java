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
import javax.swing.table.AbstractTableModel;

import modelo.ModeloTabla;
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

	// Carga los datos de la tabla estudio y receta al area de texto
	// al abrise la ventana ventenaTurnosDisponible.
	public void windowOpened(WindowEvent e) {

		try {

			CallableStatement mostrarEstudioYReceta = conexionBBDD.getConexionBBDD().prepareCall(
			"{call mostrarEstudioYReceta()}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet tabla = mostrarEstudioYReceta.executeQuery();

			AbstractTableModel mTN = new ModeloTabla(tabla);

			ventanaTurnosDisponibles.getTabla().setModel(mTN);
			ventanaTurnosDisponibles.getTabla().validate();

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
				.prepareCall("{call filtrarEstudioYReceta(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				filtrarEstudioYReceta.setString(1, ventanaTurnosDisponibles.getDniPaciente());

				ResultSet tabla = filtrarEstudioYReceta.executeQuery();
 
				 
				
				AbstractTableModel mTN=new ModeloTabla(tabla);
				
				ventanaTurnosDisponibles.getTabla().setModel(mTN);
				ventanaTurnosDisponibles.getTabla().validate();
				 

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
