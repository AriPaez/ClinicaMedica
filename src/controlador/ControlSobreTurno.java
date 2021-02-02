package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.VentanaAdministrador;
import vista.VentanaAsignacionSobreTurno;

public class ControlSobreTurno implements ActionListener, PropertyChangeListener {

	private VentanaAsignacionSobreTurno ventanaAsignacionSobreTurno;
	private ConexionBBDD conexionBBDD;
	private Time horaInicio;
	private Time horaFin;
	private String dniMedico;
	private boolean controlAsignacionTurno;

	public ControlSobreTurno(VentanaAsignacionSobreTurno vAST) {
		ventanaAsignacionSobreTurno = vAST;
		conexionBBDD = new ConexionBBDD();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object botonElegido = e.getSource();

		if (botonElegido == ventanaAsignacionSobreTurno.getAsignarTurno()) {

			// Se verifica existencia de dniPaciente en el sismtema.
			try {

				CallableStatement sobreTurno = conexionBBDD.getConexionBBDD().prepareCall("{call sobreTurno(?,?,?,?)}");

				sobreTurno.setString(1,ventanaAsignacionSobreTurno.getDniPaciente());
				sobreTurno.setDate(2,new Date(ventanaAsignacionSobreTurno.getDateChooser().getTime()));
				sobreTurno.setTime(3,this.horaInicio);
				sobreTurno.setTime(4,this.horaFin);
								
				sobreTurno.execute();
 
				JOptionPane.showMessageDialog(null, 
				"SobreTurno asignado correctamente para el paciente con dni: "+ventanaAsignacionSobreTurno.getDniPaciente()
				+"\n para el día "+new Date(ventanaAsignacionSobreTurno.getDateChooser().getTime())+ " y horario: "+this.horaInicio+" a "+this.horaFin,
				"BBDD", 1, null);
				
				ventanaAsignacionSobreTurno.dispose();
				VentanaAdministrador vA = new VentanaAdministrador();
				vA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				vA.setVisible(true);

			} catch (Exception exeptionBBDD) {
				
				JOptionPane.showMessageDialog(null,exeptionBBDD.getMessage() , "BBDD", 2, null);
				ventanaAsignacionSobreTurno.setDniPaciente("");
				
			}
		} else if (botonElegido == ventanaAsignacionSobreTurno.getCancelarTurno()) {

			ventanaAsignacionSobreTurno.dispose();

			VentanaAdministrador vA = new VentanaAdministrador();
			vA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vA.setVisible(true);
		} else {
			
			// Aca al presionar se un radioButton se almacena en las variables horaInicio
			// horaFin el horario selecionado.
			// Se realiza aca ya que JRadioButton tambien tiene un evento
			// contraldo mediante el metodo actionPerformed

			if (ventanaAsignacionSobreTurno.getT1().isSelected()) {
				this.horaInicio = ventanaAsignacionSobreTurno.getTurno1HoraInicio();
				this.horaFin = ventanaAsignacionSobreTurno.getTurno1HoraFin();
			}
			if (ventanaAsignacionSobreTurno.getT2().isSelected()) {
				this.horaInicio = ventanaAsignacionSobreTurno.getTurno2HoraInicio();
				this.horaFin = ventanaAsignacionSobreTurno.getTurno2HoraFin();
			}
			if (ventanaAsignacionSobreTurno.getT3().isSelected()) {
				this.horaInicio = ventanaAsignacionSobreTurno.getTurno3HoraInicio();
				this.horaFin = ventanaAsignacionSobreTurno.getTurno3HoraFin();
			}
			if (ventanaAsignacionSobreTurno.getT4().isSelected()) {
				this.horaInicio = ventanaAsignacionSobreTurno.getTurno4HoraInicio();
				this.horaFin = ventanaAsignacionSobreTurno.getTurno4HoraFin();
			}
			if (ventanaAsignacionSobreTurno.getT5().isSelected()) {
				this.horaInicio = ventanaAsignacionSobreTurno.getTurno5HoraInicio();
				this.horaFin = ventanaAsignacionSobreTurno.getTurno5HoraFin();
			}
			if (ventanaAsignacionSobreTurno.getT6().isSelected()) {
				this.horaInicio = ventanaAsignacionSobreTurno.getTurno6HoraInicio();
				this.horaFin = ventanaAsignacionSobreTurno.getTurno6HoraFin();
			}
			if (ventanaAsignacionSobreTurno.getT7().isSelected()) {
				this.horaInicio = ventanaAsignacionSobreTurno.getTurno7HoraInicio();
				this.horaFin = ventanaAsignacionSobreTurno.getTurno7HoraFin();
			}
			if (ventanaAsignacionSobreTurno.getT8().isSelected()) {
				this.horaInicio = ventanaAsignacionSobreTurno.getT8HoraInicio();
				this.horaFin = ventanaAsignacionSobreTurno.getTurno8HoraFin();
			}
			if (ventanaAsignacionSobreTurno.getT9().isSelected()) {
				this.horaInicio = ventanaAsignacionSobreTurno.getTurno9HoraInicio();
				this.horaFin = ventanaAsignacionSobreTurno.getTurno9HoraFin();
			}
			if (ventanaAsignacionSobreTurno.getT10().isSelected()) {
				this.horaInicio = ventanaAsignacionSobreTurno.getTurno10HoraInicio();
				this.horaFin = ventanaAsignacionSobreTurno.getT10HoraFin();
			}
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (ventanaAsignacionSobreTurno.getDateChooser() != null) {
			controlarHorarioDeTurnoOcupado();
		}

	}

	public void controlarHorarioDeTurnoOcupado() {
		// La variable controlAsignacionTurno se activa para saber que ya se ha ejcutado
		// la fecha de turno;
		controlAsignacionTurno = true;

		// Activacion por defecto de radioButton en caso de cambiarse la fecha de turno.

		ventanaAsignacionSobreTurno.setTurno1(true);
		ventanaAsignacionSobreTurno.setTurno2(true);
		ventanaAsignacionSobreTurno.setTurno3(true);
		ventanaAsignacionSobreTurno.setTurno4(true);
		ventanaAsignacionSobreTurno.setTurno5(true);
		ventanaAsignacionSobreTurno.setTurno6(true);
		ventanaAsignacionSobreTurno.setTurno7(true);
		ventanaAsignacionSobreTurno.setTurno8(true);
		ventanaAsignacionSobreTurno.setTurno9(true);
		ventanaAsignacionSobreTurno.setTurno10(true);

		try {

			ResultSet tabla = null;
			// Se obtiene el dniMedico del paciente
			// Se utiliza la variable boolena verificacionDniMedico para que
			// se consulte una sola vez el dniMedico en la BBDD. Se realiza
			// de esta forma para mayor rendimiento.

			PreparedStatement obtencionDniMedico = conexionBBDD.getConexionBBDD()
					.prepareStatement("SELECT dniMedico" + " FROM Turno " + "WHERE dniPaciente=?");

			obtencionDniMedico.setString(1, ventanaAsignacionSobreTurno.getDniPaciente());

			tabla = obtencionDniMedico.executeQuery();

			while (tabla.next()) {
				this.dniMedico = tabla.getString(1);
			}

			tabla.close();

			// Desactivacion de radioButton en caso de ya exista en la BBDD
			CallableStatement horarioInicioTurnosReservados = conexionBBDD.getConexionBBDD()
					.prepareCall("{call horarioInicioTurnosReservados(?,?)}");

			horarioInicioTurnosReservados.setString(1, this.dniMedico);
			horarioInicioTurnosReservados.setDate(2, new Date(ventanaAsignacionSobreTurno.getDateChooser().getTime()));

			tabla = horarioInicioTurnosReservados.executeQuery();

			while (tabla.next()) {

				if (ventanaAsignacionSobreTurno.getTurno1HoraInicio().equals(tabla.getTime(1))) {
					ventanaAsignacionSobreTurno.setTurno1(false);
				}
				if (ventanaAsignacionSobreTurno.getTurno2HoraInicio().equals(tabla.getTime(1))) {
					ventanaAsignacionSobreTurno.setTurno2(false);
				}
				if (ventanaAsignacionSobreTurno.getTurno3HoraInicio().equals(tabla.getTime(1))) {
					ventanaAsignacionSobreTurno.setTurno3(false);
				}
				if (ventanaAsignacionSobreTurno.getTurno4HoraInicio().equals(tabla.getTime(1))) {
					ventanaAsignacionSobreTurno.setTurno4(false);
				}
				if (ventanaAsignacionSobreTurno.getTurno5HoraInicio().equals(tabla.getTime(1))) {
					ventanaAsignacionSobreTurno.setTurno5(false);
				}
				if (ventanaAsignacionSobreTurno.getTurno6HoraInicio().equals(tabla.getTime(1))) {
					ventanaAsignacionSobreTurno.setTurno6(false);
				}
				if (ventanaAsignacionSobreTurno.getTurno7HoraInicio().equals(tabla.getTime(1))) {
					ventanaAsignacionSobreTurno.setTurno7(false);
				}
				if (ventanaAsignacionSobreTurno.getT8HoraInicio().equals(tabla.getTime(1))) {
					ventanaAsignacionSobreTurno.setTurno8(false);
				}
				if (ventanaAsignacionSobreTurno.getTurno9HoraInicio().equals(tabla.getTime(1))) {
					ventanaAsignacionSobreTurno.setTurno9(false);
				}
				if (ventanaAsignacionSobreTurno.getTurno10HoraInicio().equals(tabla.getTime(1))) {
					ventanaAsignacionSobreTurno.setTurno10(false);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
