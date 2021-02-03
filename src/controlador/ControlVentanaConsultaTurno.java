package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import principal.VentanaAdministrador;
import vista.VentanaConsultaTurno;

public class ControlVentanaConsultaTurno implements ActionListener {

	private VentanaConsultaTurno ventanaConsultaTurno;
	private ConexionBBDD conexionBBDD;

	public ControlVentanaConsultaTurno(VentanaConsultaTurno vCT) {
		ventanaConsultaTurno = vCT;
		conexionBBDD = new ConexionBBDD();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object botonElegido = e.getSource();

		if (botonElegido == ventanaConsultaTurno.getBuscar()) {

			// reset de area de texto.
			ventanaConsultaTurno.getAreaDeDatos().setText("");

			try {

				CallableStatement obtenerTurnoDePaciente = conexionBBDD.getConexionBBDD()
				.prepareCall("{call obtenerTurnoDePaciente(?)}");

				obtenerTurnoDePaciente.setString(1, ventanaConsultaTurno.getDniPaciente());

				ResultSet tabla = obtenerTurnoDePaciente.executeQuery();

				while (tabla.next()) {

					ventanaConsultaTurno.getAreaDeDatos()
					.append(tabla.getString(1) + "   " + tabla.getString(2) + "   " + tabla.getString(3) + "   "
					+ tabla.getString(4) + "   " + tabla.getString(5) + "   " + tabla.getString(6));

				}


			} catch (Exception exeptionBBDD) {

				JOptionPane.showMessageDialog(null, exeptionBBDD.getMessage(), "BBDD", 2, null);

				ventanaConsultaTurno.getAreaDeDatos().setText("");

			}
		} else {
			ventanaConsultaTurno.dispose();

			VentanaAdministrador vA = new VentanaAdministrador();
			vA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vA.setVisible(true);
		}

	}

}
