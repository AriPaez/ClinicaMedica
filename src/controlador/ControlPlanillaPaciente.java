package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vista.PlanillaPaciente;
import vista.VentanaMedico;

public class ControlPlanillaPaciente implements ActionListener
{
	private PlanillaPaciente panillaPaciente;
	private ConexionBBDD conexionBBDD;
	private VentanaMedico vM;
	public ControlPlanillaPaciente(PlanillaPaciente p)
	{
		panillaPaciente=p;
		vM=new VentanaMedico();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object botonElegido = e.getSource();
		
		if(botonElegido==panillaPaciente.getCargar())
		{
			//Aca se carga en la BBDD.
			
			try
			{ 
				
				PreparedStatement dniPaciente=conexionBBDD.getConexionBBDD()
				.prepareStatement("SELECT dniPaciente,max(fecha) FROM Turno"
				 +"WHERE dniPaciente=? GROUP BY dniPaciente ");
				
				dniPaciente.setString(1,panillaPaciente.getIngresoDNIPaciente());
				
				ResultSet tabla=dniPaciente.executeQuery();
				
				 boolean dniPacienteEncontrado=false;
				
				 while(tabla.next() && !dniPacienteEncontrado)
				 {
					 dniPacienteEncontrado=true;
				 }
				
				 
				 if(dniPacienteEncontrado)
				 {
					 System.out.println("Existe paciente");
				 }
				 else
				 {
					 System.out.println("No existe");
				 }
				 
				 //Otra forma de Validar registros Java si existe o No
				 //ResultSet rs = ps.executeQuery();
				 //if(tabla.next())
				 // {
				 //System.out.println("exist"); 
				 //}
				 /*
				  if(rs.last()){
            		//Existe
        			}
        			else{
            		//No Existe
        			}
				  */
				 
			
			}
			catch (SQLException e1) 
			{
				 
				 JOptionPane.showMessageDialog(null,
				 "Paciente no encontrado","BBDD",1, null);
				 e1.printStackTrace();
			}
			
		}
		else
		{
			//Aca se cierra la ventana PlanillaPaciente.
			panillaPaciente.dispose();
			
			//Se invoca nuevamente a la ventana VentanaMedico
			vM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vM.setVisible(true);
			
		}
		 
		
	}
	
	
	

}
