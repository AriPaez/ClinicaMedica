package vista;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.ControlPlanillaPaciente;

public class PlanillaPaciente extends JFrame {


	private JTextField dniPaciente;
	private JTextField talla;
	private JTextField peso;
	private JTextField medicamento;
	private JButton cargar;
	private JButton cancelar;
	private JComboBox asistencia;
	private JTextArea motivoConsulta;
	private JTextArea instruccionesAlPaciente;
	private JTextArea instruccionesAlFtico ;
	private JTextArea diagnostico;
	
	public PlanillaPaciente() 
	{
		//Caracteristica ventana.
		setSize(465, 711);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel laminaSuperior = new JPanel();
		laminaSuperior.setBounds(43, 0, 384, 35);

		laminaSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel titituloPlanilla = new JLabel("PLANILLA PACIENTE");
		titituloPlanilla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		laminaSuperior.add(titituloPlanilla);
		getContentPane().add(laminaSuperior);

		
		JLabel msjeDNIPaciente = new JLabel("DNI Paciente");
		msjeDNIPaciente.setBounds(22, 46, 95, 20);
		msjeDNIPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(msjeDNIPaciente);
		
		dniPaciente = new JTextField();
		dniPaciente.setBounds(159, 46, 95, 20);
		getContentPane().add(dniPaciente);
		dniPaciente.setColumns(10);

		JLabel msjeAsistencia = new JLabel("Asistencia");
		msjeAsistencia.setBounds(22, 78, 85, 20);
		msjeAsistencia.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(msjeAsistencia);

		asistencia = new JComboBox();
		asistencia.setEditable(false);
		asistencia.setBounds(159, 77, 96, 22);
		asistencia.addItem("Sí");
		asistencia.addItem("No");
		getContentPane().add(asistencia);

		JLabel msjeCargaEstudio = new JLabel("CARGA DE ESTUDIO");
		msjeCargaEstudio.setBounds(140, 111, 198, 35);
		msjeCargaEstudio.setFont(new Font("Arial", Font.BOLD, 15));
		getContentPane().add(msjeCargaEstudio);
		
		JLabel msjeTalla = new JLabel("Talla (cm)");
		msjeTalla.setBounds(22, 156, 109, 22);
		msjeTalla.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(msjeTalla);
		
		talla = new JTextField();
		talla.setBounds(159, 157, 86, 20);
		getContentPane().add(talla);
		talla.setText(" ");
		talla.setColumns(10);
		
		JLabel msjePeso = new JLabel("Peso(KG)");
		msjePeso.setBounds(22, 192, 95, 20);
		msjePeso.setFont(new Font("Arial", Font.PLAIN, 11));
		getContentPane().add(msjePeso);
		
		peso = new JTextField();
		peso.setBounds(159, 192, 86, 20);
		getContentPane().add(peso);
		peso.setText(" ");
		peso.setColumns(10);
		
		JLabel msjeMotivoConsulta = new JLabel("Motivo Consulta");
		msjeMotivoConsulta.setBounds(22, 235, 130, 22);
		msjeMotivoConsulta.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(msjeMotivoConsulta);
		
		motivoConsulta = new JTextArea();
		motivoConsulta.setBounds(159, 223, 250, 42);
		motivoConsulta.setLineWrap(true);
		getContentPane().add(motivoConsulta);
		
		JLabel msjeCargaReceta = new JLabel("CARGA DE RECETA");
		msjeCargaReceta.setBounds(140, 341, 203, 42);
		msjeCargaReceta.setFont(new Font("Arial", Font.BOLD, 15));
		getContentPane().add(msjeCargaReceta);
		
		JSeparator separadorEstudio = new JSeparator();
		separadorEstudio.setBounds(22, 109, 416, 10);
		getContentPane().add(separadorEstudio);
		
		JSeparator separadorReceta = new JSeparator();
		separadorReceta.setBounds(22, 332, 411, 10);
		getContentPane().add(separadorReceta);
		
		JLabel msjeMedicamento = new JLabel("Medicamento");
		msjeMedicamento.setBounds(22, 394, 90, 20);
		msjeMedicamento.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(msjeMedicamento);
		
		medicamento = new JTextField();
		medicamento.setBounds(159, 394, 250, 20);
		getContentPane().add(medicamento);
		medicamento.setColumns(10);
		
		JLabel msjeInstruccionesAlPaciente = new JLabel("Instrucciones al paciente");
		msjeInstruccionesAlPaciente.setBounds(8, 467, 144, 20);
		msjeInstruccionesAlPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(msjeInstruccionesAlPaciente);
		
		instruccionesAlPaciente = new JTextArea();
		instruccionesAlPaciente.setBounds(159, 442, 250, 70);
		instruccionesAlPaciente.setLineWrap(true);
		getContentPane().add(instruccionesAlPaciente);
		
		JLabel msjeInstruccionesAlFtico = new JLabel("Instrucciones al ftico.");
		msjeInstruccionesAlFtico.setBounds(18, 563, 161, 29);
		msjeInstruccionesAlFtico.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(msjeInstruccionesAlFtico);
		
		instruccionesAlFtico = new JTextArea();
		instruccionesAlFtico.setBounds(159, 537, 250, 77);
		instruccionesAlFtico.setLineWrap(true);
		getContentPane().add(instruccionesAlFtico);
		
		cargar = new JButton("Cargar");
		cargar.setBounds(80, 625, 95, 39);
		getContentPane().add(cargar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setBounds(288, 625, 90, 39);
		getContentPane().add(cancelar);
		
		JLabel msjeDiagnostico = new JLabel("Diagn\u00F3stico");
		msjeDiagnostico.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeDiagnostico.setBounds(22, 281, 95, 20);
		getContentPane().add(msjeDiagnostico);
		
		diagnostico = new JTextArea();
		diagnostico.setLineWrap(true);
		diagnostico.setBounds(159, 279, 250, 42);
		getContentPane().add(diagnostico);
		
		
		ControlPlanillaPaciente cPP=new ControlPlanillaPaciente(this);

		cargar.addActionListener(cPP);
		cancelar.addActionListener(cPP);
		
	}
	
	
	public JButton getCancelar() 
	{
		return cancelar;
	}

	public String getDniPaciente() 
	{
		return dniPaciente.getText();
	}

	public float getTalla() 
	{
		return  Float.parseFloat(talla.getText());
	}

	public float  getPeso() 
	{
		return Float.parseFloat(peso.getText());
	}

	public String getMedicamento() 
	{
		return medicamento.getText();
	}

	public JButton getCargar()
	{
		return cargar;
	}
	
	public boolean getAsistencia()
	{
		if(asistencia.getSelectedItem().equals("Sí"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getMotivoConsulta() {
		return motivoConsulta.getText();
	}

	public String getInstruccionesAlPaciente() {
		return instruccionesAlPaciente.getText();
	}


	public String getInstruccionesAlFtico() {
		return instruccionesAlFtico.getText();
	}

	public String getDiagnostico() {
		return diagnostico.getText();
	}
	

}
