package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class TurnoPaciente extends JFrame 
{
	public TurnoPaciente() {
		
		//Caracteristica ventana.
		setSize(460, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		  
		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 434, 350);
		laminaPrincipal.setLayout(null);
		getContentPane().add(laminaPrincipal);
		
		JLabel msjeSistemaMedico = new JLabel("SISTEMA MÉDICO");
		msjeSistemaMedico.setFont(new Font("Arial", Font.PLAIN, 30));
		msjeSistemaMedico.setBounds(85, 0, 257, 59);
		laminaPrincipal.add(msjeSistemaMedico);
		
		JTextArea turnosPacientes = new JTextArea();
		turnosPacientes.setLineWrap(true);
		turnosPacientes.setBounds(10, 79, 424, 271);
		laminaPrincipal.add(turnosPacientes);
		
		JLabel msjeTurnosDisponibles = new JLabel("TURNOS DISPONIBLES");
		msjeTurnosDisponibles.setFont(new Font("Arial", Font.PLAIN, 20));
		msjeTurnosDisponibles.setBounds(10, 48, 246, 33);
		laminaPrincipal.add(msjeTurnosDisponibles);
		
	}
}
