package vista;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controlador.ControlAsignacionTurno;

public class VentanaAsignacionTurno extends JFrame 
{
	private JTextField dniPaciente;
	private JButton asignarTurno ;
	private JButton cancelarTurno;
	private JComboBox especialidad;
	private JComboBox profesional;
	private JRadioButton t1;
	private JRadioButton t2;
	private JRadioButton t3;
	private JRadioButton t4;
	private JRadioButton t5;
	private JRadioButton t6;
	private JRadioButton t7;
	private JRadioButton t8;
	private JRadioButton t9;
	private JRadioButton t10;
	private JDateChooser dateChooser;
	
	public VentanaAsignacionTurno()
	{
		setTitle("ASIGNACIÓN DE TURNOS");
		getContentPane().setLayout(null);
		setSize(434, 550);
		setLocationRelativeTo(null);
		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 418, 509);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		JLabel asignacionTurno = new JLabel("ASIGNACION DE TURNO");
		asignacionTurno.setFont(new Font("Arial", Font.BOLD, 30));
		asignacionTurno.setBounds(36, 11, 355, 36);
		laminaPrincipal.add(asignacionTurno);
		
		JLabel msjeDNIPaciente = new JLabel("DNI Paciente");
		msjeDNIPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeDNIPaciente.setBounds(36, 62, 83, 20);
		laminaPrincipal.add(msjeDNIPaciente);
		
		JLabel msjeEspecialidad = new JLabel("Especialidad");
		msjeEspecialidad.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeEspecialidad.setBounds(36, 93, 83, 20);
		laminaPrincipal.add(msjeEspecialidad);
		
		dniPaciente = new JTextField();
		dniPaciente.setBounds(178, 62, 232, 20);
		laminaPrincipal.add(dniPaciente);
		dniPaciente.setColumns(10);
		
		especialidad = new JComboBox();
		especialidad.setEditable(false);
		especialidad.setBounds(178, 92, 232, 22);
		laminaPrincipal.add(especialidad);
		
		JLabel msjeFecha = new JLabel("Fecha");
		msjeFecha.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeFecha.setBounds(36, 185, 46, 14);
		laminaPrincipal.add(msjeFecha);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(178, 179, 232, 20);
		laminaPrincipal.add(dateChooser);
		
		JLabel msjeProfesional = new JLabel("Profesional");
		msjeProfesional.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msjeProfesional.setBounds(36, 134, 93, 20);
		laminaPrincipal.add(msjeProfesional);
		
		profesional = new JComboBox();
		profesional.setEditable(true);
		profesional.setBounds(178, 134, 232, 22);
		laminaPrincipal.add(profesional);
		
		JLabel msjeHorarios = new JLabel("Horario");
		msjeHorarios.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeHorarios.setBounds(36, 229, 46, 14);
		laminaPrincipal.add(msjeHorarios);
		
		 
		
		asignarTurno = new JButton("Asignar");
		asignarTurno.setBounds(53, 475, 121, 23);
		laminaPrincipal.add(asignarTurno);
		
		cancelarTurno = new JButton("Cancelar");
		cancelarTurno.setBounds(302, 475, 108, 23);
		laminaPrincipal.add(cancelarTurno);
		
		ButtonGroup turnos=new ButtonGroup();
		
		t1 = new JRadioButton("8:00 hs a 8:15 hs");
		turnos.add(t1);
		t1.setBounds(112, 229, 140, 23);
		laminaPrincipal.add(t1);
		
		t2 = new JRadioButton("8:20 hs a 8:35 hs");
		turnos.add(t2);
		t2.setBounds(110, 263, 140, 23);
		laminaPrincipal.add(t2);

		t3 = new JRadioButton("8:40 hs a 8:45 hs");
		turnos.add(t3);
		t3.setBounds(110, 302, 140, 23);
		laminaPrincipal.add(t3);
		
		t4 = new JRadioButton("9:00 hs a 9:15 hs");
		turnos.add(t4);
		t4.setBounds(110, 344, 140, 23);
		laminaPrincipal.add(t4);
		
		t5 = new JRadioButton("9:20 hs a 9:35 hs");
		turnos.add(t5);
		t5.setBounds(110, 391, 140, 23);
		laminaPrincipal.add(t5);
		
		t6 = new JRadioButton("9:40 hs a 9:55 hs");
		turnos.add(t6);
		t6.setBounds(270, 229, 140, 23);
		laminaPrincipal.add(t6);
		
		t7 = new JRadioButton("10:00 hs a 10:15 hs");
		turnos.add(t7);
		t7.setBounds(269, 263, 140, 23);
		laminaPrincipal.add(t7);
		
		t8 = new JRadioButton("10:20 hs a 10:35 hs");
		turnos.add(t8);
		t8.setBounds(270, 302, 140, 23);
		laminaPrincipal.add(t8);
		
		t9 = new JRadioButton("10:40 hs a 10:55 hs");
		turnos.add(t9);
		t9.setBounds(269, 344, 140, 23);
		laminaPrincipal.add(t9);

		t10 = new JRadioButton("11:00 hs a 11:15 hs");
		turnos.add(t10);
		//t10.setEnabled(false);
		t10.setBounds(269, 391, 140, 23);
		laminaPrincipal.add(t10);
		 
		ControlAsignacionTurno  cAT=new ControlAsignacionTurno(this);
		
		//Al presionar los botons se produve
		//evento para asignar o  cancelar el turno.
		asignarTurno.addActionListener(cAT);
		cancelarTurno.addActionListener(cAT);
		
		
		//Al abrirse la VentanaAsignacionTurno se ejecuta windowOpened
		addWindowListener(cAT);
		 
		//Carga los doctores que pertenen a una especialidad
		//en concreta.
		especialidad.addItemListener(cAT);
		
		
		//Detecta evento de cambio de fecha en JCalendar.
		dateChooser.addPropertyChangeListener(cAT);
		
		
	}
	
	public JButton getAsignarTurno() {
		return asignarTurno;
	}

	public JButton getCancelarTurno() {
		return cancelarTurno;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad.addItem(especialidad);
	}
	
	public void setProfesional(String unProfesional) {
		this.profesional.addItem(unProfesional);
	}

	public JComboBox getEspecialidad() {
		return   especialidad;
	}

	public JComboBox getProfesional() {
		return profesional;
	}

	public void setT1(boolean t1) {
		this.t10.setEnabled(t1);
	}

	public void setT2(boolean t2) {
		this.t10.setEnabled(t2);
	}

	public void setT3(boolean t3) {
		this.t10.setEnabled(t3);
	}

	public void setT4(boolean t4) {
		this.t10.setEnabled(t4);
	}

	public void setT5(boolean t5) {
		this.t10.setEnabled(t5);
	}

	public void setT6(boolean t6) {
		this.t10.setEnabled(t6);
	}

	public void setT7(boolean t7) {
		this.t10.setEnabled(t7);
	}

	public void setT8(boolean t8) {
		this.t10.setEnabled(t8);
	}

	public void setT9(boolean t9) {
		this.t10.setEnabled(t9);
	}

	public void setT10(boolean t10) {
		this.t10.setEnabled(t10);
	}

	public Date getDateChooser() {
		return dateChooser.getDate();
	}
	
	
}
