package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import modelo.ModeloTabla;
import vista.VentanaAdministrador;
import vista.VentanaNotificacion;

public class ControlVentanaNotificacion extends WindowAdapter implements ActionListener {

	private VentanaNotificacion ventanaNotificacion;
	private ConexionBBDD conexionBBDD;
	
	public ControlVentanaNotificacion(VentanaNotificacion vN) {
		ventanaNotificacion = vN;
		conexionBBDD = new ConexionBBDD();
	}

	public void windowOpened(WindowEvent e) {
		
		try 
		{
			
			CallableStatement mostrarPacientesAusentes = conexionBBDD.getConexionBBDD()
			.prepareCall("{call mostrarPacientesAusentes()}", ResultSet.TYPE_SCROLL_INSENSITIVE,
		     ResultSet.CONCUR_READ_ONLY);

			ResultSet tabla = mostrarPacientesAusentes.executeQuery();
			
			 
			
			AbstractTableModel mTN=new ModeloTabla(tabla);
			
			ventanaNotificacion.getTabla().setModel(mTN);
			ventanaNotificacion.getTabla().validate();
			 

		} catch (SQLException e1) {

			JOptionPane.showMessageDialog(null, e1.getMessage(), "BBDD", 2, null);
			this.cerrarVentanaNotificacion();
			this.abrirVentanaAdministrador();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		this.cerrarVentanaNotificacion();
		this.abrirVentanaAdministrador();
		
	}
	
	public void cerrarVentanaNotificacion()
	{
		ventanaNotificacion.dispose();
	}
	
	public void abrirVentanaAdministrador()
	{
		VentanaAdministrador vA=new VentanaAdministrador();
		vA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vA.setVisible(true);
	}

}
