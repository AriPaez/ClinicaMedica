package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import modelo.ModeloTabla;
import vista.VentanaAdministrador;
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
				.prepareCall("{call obtenerTurnoDePaciente(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,
				 ResultSet.CONCUR_READ_ONLY);

				obtenerTurnoDePaciente.setString(1, ventanaConsultaTurno.getDniPaciente());

				ResultSet tabla = obtenerTurnoDePaciente.executeQuery();

				AbstractTableModel mTN=new ModeloTabla(tabla);
				
				ventanaNotificacion.getTabla().setModel(mTN);
				ventanaNotificacion.getTabla().validate();


			} catch (Exception exeptionBBDD) {

				JOptionPane.showMessageDialog(null, exeptionBBDD.getMessage(), "BBDD", 2, null);

				ventanaConsultaTurno.getAreaDeDatos().setText("");

			}
		} else {
			
			cerrarVentanaConsultaTurno();
			abrirVentanaAdministrador();
			
		}

	}
	
	public void abrirVentanaAdministrador()
	{
		VentanaAdministrador vA = new VentanaAdministrador();
		vA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vA.setVisible(true);
	}
	
	public void cerrarVentanaConsultaTurno()
	{
		ventanaConsultaTurno.dispose();
	}

}
