package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class PlanillaPaciente extends JFrame
{
	
	 
	private JTextField ingresoDNIPaciente;
	private JTextField ingresoFechaConsulta;
	private JTextField ingresoPeso;
	private JTextField ingresoMedicamento;

	public PlanillaPaciente() 
	{
		//Caracteristica ventana.
		setSize(465, 630);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel laminaSuperior = new JPanel();
		laminaSuperior.setBounds(0, 0, 384, 35);

		laminaSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel titituloPlanilla = new JLabel("PLANILLA PACIENTE");
		titituloPlanilla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		laminaSuperior.add(titituloPlanilla);
		getContentPane().add(laminaSuperior);

		
		JLabel msjeDNIPaciente = new JLabel("DNI Paciente");
		msjeDNIPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeDNIPaciente.setBounds(22, 46, 95, 20);
		getContentPane().add(msjeDNIPaciente);
		
		ingresoDNIPaciente = new JTextField();
		ingresoDNIPaciente.setBounds(159, 46, 95, 20);
		getContentPane().add(ingresoDNIPaciente);
		ingresoDNIPaciente.setColumns(10);

		JLabel msjeAsistencia = new JLabel("Asistencia");
		msjeAsistencia.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeAsistencia.setBounds(22, 78, 85, 20);
		getContentPane().add(msjeAsistencia);

		JComboBox asistencia = new JComboBox();
		asistencia.setBounds(159, 77, 96, 22);
		asistencia.addItem("Si");
		asistencia.addItem("No");
		getContentPane().add(asistencia);

		JLabel msjeCargaEstudio = new JLabel("CARGA DE ESTUDIO");
		msjeCargaEstudio.setFont(new Font("Arial", Font.BOLD, 15));
		msjeCargaEstudio.setBounds(104, 123, 198, 35);
		getContentPane().add(msjeCargaEstudio);
		
		JLabel msjeConsulta = new JLabel("Fecha de Consulta");
		msjeConsulta.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeConsulta.setBounds(22, 156, 109, 22);
		getContentPane().add(msjeConsulta);
		
		ingresoFechaConsulta = new JTextField();
		ingresoFechaConsulta.setBounds(159, 157, 86, 20);
		getContentPane().add(ingresoFechaConsulta);
		ingresoFechaConsulta.setColumns(10);
		
		JLabel msjePeso = new JLabel("Peso(KG)");
		msjePeso.setFont(new Font("Arial", Font.PLAIN, 11));
		msjePeso.setBounds(22, 192, 95, 20);
		getContentPane().add(msjePeso);
		
		ingresoPeso = new JTextField();
		ingresoPeso.setBounds(159, 192, 86, 20);
		getContentPane().add(ingresoPeso);
		ingresoPeso.setColumns(10);
		
		JLabel msjeMotivoConsulta = new JLabel("Motivo Consulta");
		msjeMotivoConsulta.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeMotivoConsulta.setBounds(22, 242, 130, 22);
		getContentPane().add(msjeMotivoConsulta);
		
		JTextArea ingresoMotivoConsulta = new JTextArea();
		ingresoMotivoConsulta.setLineWrap(true);
		ingresoMotivoConsulta.setBounds(159, 223, 250, 70);
		getContentPane().add(ingresoMotivoConsulta);
		
		JLabel msjeCargaReceta = new JLabel("CARGA DE RECETA");
		msjeCargaReceta.setFont(new Font("Arial", Font.BOLD, 15));
		msjeCargaReceta.setBounds(104, 305, 203, 42);
		getContentPane().add(msjeCargaReceta);
		
		JSeparator separadorEstudio = new JSeparator();
		separadorEstudio.setBounds(22, 109, 416, 10);
		getContentPane().add(separadorEstudio);
		
		JSeparator separadorReceta = new JSeparator();
		separadorReceta.setBounds(27, 300, 411, 10);
		getContentPane().add(separadorReceta);
		
		JLabel msjeMedicamento = new JLabel("Medicamento");
		msjeMedicamento.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeMedicamento.setBounds(27, 341, 90, 20);
		getContentPane().add(msjeMedicamento);
		
		ingresoMedicamento = new JTextField();
		ingresoMedicamento.setBounds(159, 341, 250, 20);
		getContentPane().add(ingresoMedicamento);
		ingresoMedicamento.setColumns(10);
		
		JLabel msjeInstruccionesAlPaciente = new JLabel("Instrucciones al paciente");
		msjeInstruccionesAlPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeInstruccionesAlPaciente.setBounds(22, 389, 144, 20);
		getContentPane().add(msjeInstruccionesAlPaciente);
		
		JTextArea ingresoInstruccionesAlPaciente = new JTextArea();
		ingresoInstruccionesAlPaciente.setBounds(159, 372, 250, 70);
		ingresoInstruccionesAlPaciente.setLineWrap(true);
		getContentPane().add(ingresoInstruccionesAlPaciente);
		
		JLabel msjeInstruccionesAlFtico = new JLabel("Instrucciones al ftico.");
		msjeInstruccionesAlFtico.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeInstruccionesAlFtico.setBounds(22, 480, 161, 29);
		getContentPane().add(msjeInstruccionesAlFtico);
		
		JTextArea instruccionesAlFtico = new JTextArea();
		instruccionesAlFtico.setBounds(159, 453, 250, 77);
		instruccionesAlFtico.setLineWrap(true);
		getContentPane().add(instruccionesAlFtico);
		
		JButton cargar = new JButton("Cargar");
		cargar.setBounds(104, 541, 95, 39);
		getContentPane().add(cargar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(312, 541, 90, 39);
		getContentPane().add(cancelar);

	}
}
