package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private ControlAsignacionTurno cAT;
	
	public VentanaAsignacionTurno()
	{
		setTitle("Turno");
		getContentPane().setLayout(null);
		setSize(434, 550);
		setLocationRelativeTo(null);
		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 434, 509);
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
		dniPaciente.setBounds(178, 62, 86, 20);
		laminaPrincipal.add(dniPaciente);
		dniPaciente.setColumns(10);
		
		especialidad = new JComboBox();
		especialidad.setEditable(true);
		especialidad.setBounds(178, 92, 86, 22);
		laminaPrincipal.add(especialidad);
		
		JLabel msjeFecha = new JLabel("Fecha");
		msjeFecha.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeFecha.setBounds(36, 185, 46, 14);
		laminaPrincipal.add(msjeFecha);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(178, 179, 86, 20);
		laminaPrincipal.add(dateChooser);
		
		JLabel msjeProfesional = new JLabel("Profesional");
		msjeProfesional.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msjeProfesional.setBounds(36, 134, 93, 20);
		laminaPrincipal.add(msjeProfesional);
		
		profesional = new JComboBox();
		profesional.setEditable(true);
		profesional.setBounds(178, 134, 86, 22);
		laminaPrincipal.add(profesional);
		
		JLabel msjeHorarios = new JLabel("Horario");
		msjeHorarios.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeHorarios.setBounds(36, 229, 46, 14);
		laminaPrincipal.add(msjeHorarios);
		
		JRadioButton t1 = new JRadioButton("8:00 hs a 8:15 hs");
		t1.setBounds(173, 225, 109, 23);
		laminaPrincipal.add(t1);
		
		JRadioButton t2 = new JRadioButton("8:00 hs a 8:15 hs");
		t2.setBounds(301, 225, 109, 23);
		laminaPrincipal.add(t2);
		
		JRadioButton t3 = new JRadioButton("8:00 hs a 8:15 hs");
		t3.setBounds(173, 251, 109, 23);
		laminaPrincipal.add(t3);
		
		JRadioButton t4 = new JRadioButton("8:00 hs a 8:15 hs");
		t4.setBounds(301, 251, 109, 23);
		laminaPrincipal.add(t4);
		
		JRadioButton t5 = new JRadioButton("8:00 hs a 8:15 hs");
		t5.setBounds(173, 278, 109, 23);
		laminaPrincipal.add(t5);
		
		JRadioButton t6 = new JRadioButton("8:00 hs a 8:15 hs");
		t6.setBounds(301, 277, 109, 23);
		laminaPrincipal.add(t6);
		
		JRadioButton t7 = new JRadioButton("8:00 hs a 8:15 hs");
		t7.setBounds(173, 304, 109, 23);
		laminaPrincipal.add(t7);
		
		JRadioButton t8 = new JRadioButton("8:00 hs a 8:15 hs");
		t8.setBounds(301, 303, 109, 23);
		laminaPrincipal.add(t8);
		
		JRadioButton t9 = new JRadioButton("8:00 hs a 8:15 hs");
		t9.setBounds(173, 330, 109, 23);
		laminaPrincipal.add(t9);
		
		JRadioButton t10 = new JRadioButton("8:00 hs a 8:15 hs");
		t10.setBounds(301, 329, 109, 23);
		laminaPrincipal.add(t10);
		
		JRadioButton t11 = new JRadioButton("8:00 hs a 8:15 hs");
		t11.setBounds(173, 356, 109, 23);
		laminaPrincipal.add(t11);
		
		JRadioButton t12 = new JRadioButton("8:00 hs a 8:15 hs");
		t12.setBounds(301, 356, 109, 23);
		laminaPrincipal.add(t12);
		
		JRadioButton t13 = new JRadioButton("8:00 hs a 8:15 hs");
		t13.setBounds(173, 382, 109, 23);
		laminaPrincipal.add(t13);
		
		JRadioButton t14 = new JRadioButton("8:00 hs a 8:15 hs");
		t14 .setBounds(301, 382, 109, 23);
		laminaPrincipal.add(t14 );
		
		JRadioButton t15 = new JRadioButton("8:00 hs a 8:15 hs");
		t15.setBounds(173, 408, 109, 23);
		laminaPrincipal.add(t15);
		
		JRadioButton t16 = new JRadioButton("8:00 hs a 8:15 hs");
		t6.setBounds(301, 408, 109, 23);
		laminaPrincipal.add(t6);
		
		JRadioButton t17 = new JRadioButton("8:00 hs a 8:15 hs");
		t16.setBounds(173, 436, 109, 23);
		laminaPrincipal.add(t16);
		
		asignarTurno = new JButton("Asignar");
		asignarTurno.setBounds(53, 475, 121, 23);
		laminaPrincipal.add(asignarTurno);
		
		cancelarTurno = new JButton("Cancelar");
		cancelarTurno.setBounds(302, 475, 108, 23);
		laminaPrincipal.add(cancelarTurno);
		
		
		cAT=new ControlAsignacionTurno(this);
		
		asignarTurno.addActionListener(cAT);
		cancelarTurno.addActionListener(cAT);
		 
		especialidad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 
				cAT.cargarProfesional();
			}
			
		});
		
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

	public JComboBox getEspecialidad() {
		return especialidad;
	}
	
	

}
