package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vista.PlanillaPaciente;
import vista.VentanaMedico;
import vista.VentanaTurnoDisponibles;

public class ControlVentanaMedico implements ActionListener {

	private VentanaMedico ventanaMedico;

	public ControlVentanaMedico(VentanaMedico v) {
		ventanaMedico = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object botonElegido = e.getSource();

		if (botonElegido == ventanaMedico.getPlanillaPacientes())
		{
			// Se cierra la ventanaMedico
			ventanaMedico.dispose();
			// y se abre PlanillaPaciente
			PlanillaPaciente vP = new PlanillaPaciente();
			vP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vP.setVisible(true);
		}
		else
		{
			// Se cierra la ventanaMedico
			ventanaMedico.dispose();
			// y se abre PlanillaPaciente
			VentanaTurnoDisponibles tP = new VentanaTurnoDisponibles();
			tP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tP.setVisible(true);

		}

	}

}
