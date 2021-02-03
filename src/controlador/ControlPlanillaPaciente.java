package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.Login;
import vista.PlanillaPaciente;
import vista.VentanaMedico;

public class ControlPlanillaPaciente implements ActionListener {
	private PlanillaPaciente panillaPaciente;
	private ConexionBBDD conexionBBDD;
	private VentanaMedico vM;

	public ControlPlanillaPaciente(PlanillaPaciente p) {
		panillaPaciente = p;
		conexionBBDD = new ConexionBBDD();
		vM = new VentanaMedico();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object botonElegido = e.getSource();

		if (botonElegido == panillaPaciente.getCargar()) {
			// Aca se carga en la BBDD.

			try {

				// Se registra asistencia de paciente al turno.
				CallableStatement registrarAsistenciaATurno = conexionBBDD.getConexionBBDD()
				.prepareCall("{call registrarAsistenciaATurno(?,?)}");

				registrarAsistenciaATurno.setString(1, panillaPaciente.getDniPaciente());
				registrarAsistenciaATurno.setBoolean(2, panillaPaciente.getAsistencia());

				registrarAsistenciaATurno.execute();

				// Si asiste al turno el paciente, ==> se registra su planilla medica en la BBDD.
				if(panillaPaciente.getAsistencia())
				{
					CallableStatement registrarPlanillaPaciente = conexionBBDD.getConexionBBDD()
					.prepareCall("{call registrarPlanillaPaciente(?,?,?,?,?,?,?,?,?)}");
					registrarPlanillaPaciente.setString(1, panillaPaciente.getDniPaciente());
					registrarPlanillaPaciente.setString(2, Login.getDniUsuario().getText());
					registrarPlanillaPaciente.setFloat(3, panillaPaciente.getTalla());
					registrarPlanillaPaciente.setFloat(4, panillaPaciente.getPeso());
					registrarPlanillaPaciente.setString(5, panillaPaciente.getMotivoConsulta());
					registrarPlanillaPaciente.setString(6, panillaPaciente.getDiagnostico());
					registrarPlanillaPaciente.setString(7, panillaPaciente.getMedicamento());
					registrarPlanillaPaciente.setString(8, panillaPaciente.getInstruccionesAlPaciente());
					registrarPlanillaPaciente.setString(9, panillaPaciente.getInstruccionesAlFtico());
					 
					registrarPlanillaPaciente.execute();
					 
					JOptionPane.showMessageDialog(null,
					"Planilla de paciente registrado correctamente","BBDD", 1, null);
					
					cerrarVentanaPlanillaPaciente();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,
					"Inasistencia de paciente registrado correctamente","BBDD", 1, null);
				}
				
				 
			} catch (SQLException e1) {

				JOptionPane.showMessageDialog(null, e1.getMessage(), "BBDD", 2, null);

			}

		} else {
			
			// Aca se cierra la ventana PlanillaPaciente.
			cerrarVentanaPlanillaPaciente();

		}

	}
	
	public void cerrarVentanaPlanillaPaciente()
	{
		panillaPaciente.dispose();

		// Se invoca nuevamente a la ventana VentanaMedico
		vM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vM.setVisible(true);

	}

}
