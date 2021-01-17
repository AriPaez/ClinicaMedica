package vista;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalTime ;
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
	
	private ControlAsignacionTurno  cAT;
	private JTextField dniPaciente;
	private JButton asignarTurno ;
	private JButton cancelarTurno;
	private JComboBox especialidad;
	private JComboBox profesional;
	private JRadioButton turno1;
	private JRadioButton turno2;
	private JRadioButton turno3;
	private JRadioButton turno4;
	private JRadioButton turno5;
	private JRadioButton turno6;
	private JRadioButton turno7;
	private JRadioButton turno8;
	private JRadioButton turno9;
	private JRadioButton turno10;
	private LocalTime  turno1HoraInicio;
	private LocalTime  turno1HoraFin;
	private LocalTime  turno2HoraInicio;
	private LocalTime  turno2HoraFin;
	private LocalTime  turno3HoraInicio;
	private LocalTime  turno3HoraFin;
	private LocalTime  turno4HoraInicio;
	private LocalTime  turno4HoraFin;
	private LocalTime  turno5HoraInicio;
	private LocalTime  turno5HoraFin;
	private LocalTime  turno6HoraInicio;
	private LocalTime  turno6HoraFin;
	private LocalTime  turno7HoraInicio;
	private LocalTime  turno7HoraFin;
	private LocalTime  turno8HoraInicio;
	private LocalTime  turno8HoraFin;
	private LocalTime  turno9HoraInicio;
	private LocalTime  turno9HoraFin;
	private LocalTime  turno10HoraInicio;
	private LocalTime  turno10HoraFin;
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
		profesional.setEditable(false);
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
		
		turno1 = new JRadioButton("8:00 hs a 8:15 hs");
		turnos.add(turno1);
		turno1HoraInicio = LocalTime .of( 8, 0);
		turno1HoraFin = LocalTime .of( 8, 15);
		turno1.setBounds(112, 229, 140, 23);
		laminaPrincipal.add(turno1);
		
		turno2 = new JRadioButton("8:20 hs a 8:35 hs");
		turnos.add(turno2);
		turno2HoraInicio = LocalTime .of( 8, 20);
		turno2HoraFin = LocalTime .of(8, 35);
		turno2.setBounds(110, 263, 140, 23);
		laminaPrincipal.add(turno2);

		turno3 = new JRadioButton("8:40 hs a 8:45 hs");
		turnos.add(turno3);
		turno3HoraInicio = LocalTime .of( 8, 40);
		turno3HoraFin = LocalTime .of( 8, 45);
		turno3.setBounds(110, 302, 140, 23);
		laminaPrincipal.add(turno3);
		
		turno4 = new JRadioButton("9:00 hs a 9:15 hs");
		turnos.add(turno4);
		turno4HoraInicio = LocalTime .of( 9, 0);
		turno4HoraFin = LocalTime .of(9, 15);
		turno4.setBounds(110, 344, 140, 23);
		laminaPrincipal.add(turno4);
		
		turno5 = new JRadioButton("9:20 hs a 9:35 hs");
		turnos.add(turno5);
		turno5HoraInicio = LocalTime .of( 9, 20);
		turno5HoraFin = LocalTime .of(9, 35);
		turno5.setBounds(110, 391, 140, 23);
		laminaPrincipal.add(turno5);
		
		turno6 = new JRadioButton("9:40 hs a 9:55 hs");
		turnos.add(turno6);
		turno6HoraInicio = LocalTime .of( 9, 40);
		turno6HoraFin = LocalTime .of( 9, 55);
		turno6.setBounds(270, 229, 140, 23);
		laminaPrincipal.add(turno6);
		
		turno7 = new JRadioButton("10:00 hs a 10:15 hs");
		turnos.add(turno7);
		turno7HoraInicio = LocalTime .of( 10, 0);
		turno7HoraFin = LocalTime .of(10, 15);
		turno7.setBounds(269, 263, 140, 23);
		laminaPrincipal.add(turno7);
		
		turno8 = new JRadioButton("10:20 hs a 10:35 hs");
		turnos.add(turno8);
		turno8HoraInicio = LocalTime .of( 10, 20);
		turno8HoraFin = LocalTime .of(10, 35);
		turno8.setBounds(270, 302, 140, 23);
		laminaPrincipal.add(turno8);
		
		turno9 = new JRadioButton("10:40 hs a 10:55 hs");
		turnos.add(turno9);
		turno9HoraInicio = LocalTime .of( 10, 40);
		turno9HoraFin = LocalTime .of(10, 55);
		turno9.setBounds(269, 344, 140, 23);
		laminaPrincipal.add(turno9);

		turno10 = new JRadioButton("11:00 hs a 11:15 hs");
		turnos.add(turno10);
		turno10HoraInicio = LocalTime .of( 11, 0);
		turno10HoraFin = LocalTime .of( 11, 15);
		//t10.setEnabled(false);
		turno10.setBounds(269, 391, 140, 23);
		laminaPrincipal.add(turno10);
		 
		cAT=new ControlAsignacionTurno(this);
		
		//Al presionar los botons se produve
		//evento para asignar o  cancelar el turno.
		asignarTurno.addActionListener(cAT);
		cancelarTurno.addActionListener(cAT);
		
		
		//Al abrirse la VentanaAsignacionTurno se ejecuta windowOpened
		addWindowListener(cAT);
		 
		//Carga los doctores que pertenen a una especialidad
		//en concreta.
		especialidad.addItemListener(cAT);
		
		//Carga los profesionales dependiendo eleccion de especialida.
		profesional.addItemListener(cAT);
		
		//Detecta evento de cambio de fecha en JCalendar.
		dateChooser.addPropertyChangeListener(cAT);
		
		//Detecta evento de eleccion de horario del radioButton
		this.eventoRadioButton(turno1);
		this.eventoRadioButton(turno2);
		this.eventoRadioButton(turno3);
		this.eventoRadioButton(turno4);
		this.eventoRadioButton(turno5);
		this.eventoRadioButton(turno6);
		this.eventoRadioButton(turno7);
		this.eventoRadioButton(turno8);
		this.eventoRadioButton(turno9);
		this.eventoRadioButton(turno10);
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

	public void setTurno1(boolean t1) {
		this.turno1.setEnabled(t1);
	}

	public void setTurno2(boolean t2) {
		this.turno2.setEnabled(t2);
	}

	public void setTurno3(boolean t3) {
		this.turno3.setEnabled(t3);
	}

	public void setTurno4(boolean t4) {
		this.turno4.setEnabled(t4);
	}

	public void setTurno5(boolean t5) {
		this.turno5.setEnabled(t5);
	}

	public void setTurno6(boolean t6) {
		this.turno6.setEnabled(t6);
	}

	public void setTurno7(boolean t7) {
		this.turno7.setEnabled(t7);
	}

	public void setTurno8(boolean t8) {
		this.turno8.setEnabled(t8);
	}

	public void setTurno9(boolean t9) {
		this.turno9.setEnabled(t9);
	}

	public void setTurno10(boolean t10) {
		this.turno10.setEnabled(t10);
	}

	 
	
	public Date getDateChooser() {
		
		 
		return   dateChooser.getDate() ;
		  
	}
	
	public JRadioButton getT1() {
		return turno1;
	}

	public JRadioButton getT10() {
		return turno10;
	}

	public Time getTurno1HoraInicio() {
		return Time.valueOf(turno1HoraInicio);
	}

	public Time getTurno1HoraFin() {
		return Time.valueOf( turno1HoraFin);
	}

	public Time getTurno2HoraInicio() {
		return Time.valueOf(turno2HoraInicio);
	}

	public Time getTurno2HoraFin() {
		return Time.valueOf(turno2HoraFin);
	}

	public Time getTurno3HoraInicio() {
		return Time.valueOf(turno3HoraInicio);
	}

	public Time getTurno3HoraFin() {
		return Time.valueOf(turno3HoraFin);
	}

	public Time getTurno4HoraInicio() {
		return Time.valueOf(turno4HoraInicio);
	}

	public Time getTurno4HoraFin() {
		return Time.valueOf(turno4HoraFin);
	}

	public Time getTurno5HoraInicio() {
		return Time.valueOf(turno5HoraInicio);
	}

	public Time getTurno5HoraFin() {
		return Time.valueOf(turno5HoraFin);
	}

	public Time getTurno6HoraInicio() {
		return Time.valueOf(turno6HoraInicio);
	}

	public Time getTurno6HoraFin() {
		return Time.valueOf(turno6HoraFin);
	}

	public Time getTurno7HoraInicio() {
		return Time.valueOf(turno7HoraInicio);
	}

	public Time getTurno7HoraFin() {
		return Time.valueOf(turno7HoraFin);
	}

	public Time getT8HoraInicio() {
		return Time.valueOf(turno8HoraInicio);
	}

	public Time getTurno8HoraFin() {
		return Time.valueOf(turno8HoraFin);
	}

	public Time getTurno9HoraInicio() {
		return Time.valueOf(turno9HoraInicio);
	}

	public Time getTurno9HoraFin() {
		return Time.valueOf(turno9HoraFin);
	}

	public Time getTurno10HoraInicio() {
		return Time.valueOf(turno10HoraInicio);
	}

	public Time getT10HoraFin() {
		return Time.valueOf(turno10HoraFin);
	}
	
	public String getDniPaciente() {
		return dniPaciente.getText();
	}

	public void setDniPaciente(String seteo) {
		this.dniPaciente.setText(seteo);
	}

	public JRadioButton getT2() {
		return turno2;
	}

	public JRadioButton getT3() {
		return turno3;
	}

	public JRadioButton getT4() {
		return turno4;
	}

	public JRadioButton getT5() {
		return turno5;
	}

	public JRadioButton getT6() {
		return turno6;
	}

	public JRadioButton getT7() {
		return turno7;
	}

	public JRadioButton getT8() {
		return turno8;
	}

	public JRadioButton getT9() {
		return turno9;
	}
	
	
	public void eventoRadioButton(JRadioButton radioButton)
	{
		radioButton.addActionListener(cAT);
	}
	
	
}
