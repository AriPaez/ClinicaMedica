package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Login extends JFrame
{
	
	private JLabel tituloVentana;

	public Login()
	{
		//Caracterticas de la ventana.
		setTitle("Login");
		setSize(500,450);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Disposicion de la ventana.
		setLayout(new BorderLayout());
		
		tituloVentana=new JLabel("SISTEMA MEDICO",JLabel.CENTER);
		
		add(tituloVentana,BorderLayout.NORTH);
		
	}
	
	
}
