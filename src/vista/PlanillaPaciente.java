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

public class PlanillaPaciente extends JFrame
{ 
	private JTextField ingresoDNIPaciente;
	private JTextField ingresoTalla;
	private JTextField ingresoPeso;
	private JTextField ingresoMedicamento;
	private JButton cargar;
	private JButton cancelar;
	
	public PlanillaPaciente() 
	{
		//Caracteristica ventana.
		setSize(465, 630);
		setLocationRelativeTo(null);
		setLayout(null);

		JPanel laminaSuperior = new JPanel();
		laminaSuperior.setBounds(0, 0, 384, 35);

		laminaSuperior.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel titituloPlanilla = new JLabel("PLANILLA PACIENTE");
		titituloPlanilla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		laminaSuperior.add(titituloPlanilla);
		add(laminaSuperior);

		
		JLabel msjeDNIPaciente = new JLabel("DNI Paciente");
		msjeDNIPaciente.setBounds(22, 46, 95, 20);
		msjeDNIPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		add(msjeDNIPaciente);
		
		ingresoDNIPaciente = new JTextField();
		ingresoDNIPaciente.setBounds(159, 46, 95, 20);
		add(ingresoDNIPaciente);
		ingresoDNIPaciente.setColumns(10);

		JLabel msjeAsistencia = new JLabel("Asistencia");
		msjeAsistencia.setBounds(22, 78, 85, 20);
		msjeAsistencia.setFont(new Font("Arial", Font.PLAIN, 12));
		add(msjeAsistencia);

		JComboBox asistencia = new JComboBox();
		asistencia.setBounds(159, 77, 96, 22);
		asistencia.addItem("Si");
		asistencia.addItem("No");
		add(asistencia);

		JLabel msjeCargaEstudio = new JLabel("CARGA DE ESTUDIO");
		msjeCargaEstudio.setBounds(104, 123, 198, 35);
		msjeCargaEstudio.setFont(new Font("Arial", Font.BOLD, 15));
		add(msjeCargaEstudio);
		
		JLabel msjeTalla = new JLabel("Talla (cm)");
		msjeTalla.setBounds(22, 156, 109, 22);
		msjeTalla.setFont(new Font("Arial", Font.PLAIN, 12));
		add(msjeTalla);
		
		ingresoTalla = new JTextField();
		ingresoTalla.setBounds(159, 157, 86, 20);
		add(ingresoTalla);
		ingresoTalla.setColumns(10);
		
		JLabel msjePeso = new JLabel("Peso(KG)");
		msjePeso.setBounds(22, 192, 95, 20);
		msjePeso.setFont(new Font("Arial", Font.PLAIN, 11));
		add(msjePeso);
		
		ingresoPeso = new JTextField();
		ingresoPeso.setBounds(159, 192, 86, 20);
		add(ingresoPeso);
		ingresoPeso.setColumns(10);
		
		JLabel msjeMotivoConsulta = new JLabel("Motivo Consulta");
		msjeMotivoConsulta.setBounds(22, 242, 130, 22);
		msjeMotivoConsulta.setFont(new Font("Arial", Font.PLAIN, 12));
		add(msjeMotivoConsulta);
		
		JTextArea ingresoMotivoConsulta = new JTextArea();
		ingresoMotivoConsulta.setBounds(159, 223, 250, 70);
		ingresoMotivoConsulta.setLineWrap(true);
		add(ingresoMotivoConsulta);
		
		JLabel msjeCargaReceta = new JLabel("CARGA DE RECETA");
		msjeCargaReceta.setBounds(104, 305, 203, 42);
		msjeCargaReceta.setFont(new Font("Arial", Font.BOLD, 15));
		add(msjeCargaReceta);
		
		JSeparator separadorEstudio = new JSeparator();
		separadorEstudio.setBounds(22, 109, 416, 10);
		add(separadorEstudio);
		
		JSeparator separadorReceta = new JSeparator();
		separadorReceta.setBounds(27, 300, 411, 10);
		add(separadorReceta);
		
		JLabel msjeMedicamento = new JLabel("Medicamento");
		msjeMedicamento.setBounds(27, 341, 90, 20);
		msjeMedicamento.setFont(new Font("Arial", Font.PLAIN, 12));
		add(msjeMedicamento);
		
		ingresoMedicamento = new JTextField();
		ingresoMedicamento.setBounds(159, 341, 250, 20);
		add(ingresoMedicamento);
		ingresoMedicamento.setColumns(10);
		
		JLabel msjeInstruccionesAlPaciente = new JLabel("Instrucciones al paciente");
		msjeInstruccionesAlPaciente.setBounds(22, 389, 144, 20);
		msjeInstruccionesAlPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		add(msjeInstruccionesAlPaciente);
		
		JTextArea ingresoInstruccionesAlPaciente = new JTextArea();
		ingresoInstruccionesAlPaciente.setBounds(159, 372, 250, 70);
		ingresoInstruccionesAlPaciente.setLineWrap(true);
		add(ingresoInstruccionesAlPaciente);
		
		JLabel msjeInstruccionesAlFtico = new JLabel("Instrucciones al ftico.");
		msjeInstruccionesAlFtico.setBounds(22, 480, 161, 29);
		msjeInstruccionesAlFtico.setFont(new Font("Arial", Font.PLAIN, 12));
		add(msjeInstruccionesAlFtico);
		
		JTextArea instruccionesAlFtico = new JTextArea();
		instruccionesAlFtico.setBounds(159, 453, 250, 77);
		instruccionesAlFtico.setLineWrap(true);
		add(instruccionesAlFtico);
		
		cargar = new JButton("Cargar");
		cargar.setBounds(104, 541, 95, 39);
		add(cargar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setBounds(312, 541, 90, 39);
		add(cancelar);
		
		
		ControlPlanillaPaciente cPP=new ControlPlanillaPaciente(this);

		cargar.addActionListener(cPP);
		cancelar.addActionListener(cPP);
		
	}
	
	
	public JButton getCancelar() 
	{
		return cancelar;
	}

	public String getIngresoDNIPaciente() 
	{
		return ingresoDNIPaciente.getText();
	}

	public String getIngresoTalla() 
	{
		return ingresoTalla.getText();
	}

	public String  getIngresoPeso() 
	{
		return ingresoPeso.getText();
	}

	public String getIngresoMedicamento() 
	{
		return ingresoMedicamento.getText();
	}

	public JButton getCargar()
	{
		return cargar;
	}
}
