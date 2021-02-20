package vista;

import java.awt.Font;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import controlador.ControlVentanaRegistrarPaciente;

public class VentanaRegistrarPaciente extends JFrame {
	
	private JTextField ingresoDNI;
	private JTextField ingresoPrimerNombre;
	private JTextField ingresoCelular;
	private JTextField ingresoEmail;
	private JTextField ingresoSegundoNombre;
	private JDateChooser ingresoFechaNacimiento;
	private JButton guardar;
	private JButton cancelar;
	private JTextField ingresoApellido;
	
	public VentanaRegistrarPaciente() {

		//Caracteristica ventana.
		setSize(380, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Registro de Paciente");
		
		getContentPane().setLayout(null);

		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 364, 461);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);

		JLabel msjeTituloPrincipal = new JLabel("SISTEMA M\u00C9DICO");
		msjeTituloPrincipal.setFont(new Font("Arial", Font.PLAIN, 30));
		msjeTituloPrincipal.setBounds(49, 11, 305, 49);
		laminaPrincipal.add(msjeTituloPrincipal);

		JLabel msjeDNI = new JLabel("Ingrese DNI");
		msjeDNI.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeDNI.setBounds(38, 77, 77, 21);
		laminaPrincipal.add(msjeDNI);

		ingresoDNI = new JTextField();
		ingresoDNI.setBounds(168, 77, 174, 20);
		laminaPrincipal.add(ingresoDNI);
		ingresoDNI.setColumns(10);

		JLabel msjeFechaNacimiento = new JLabel("Fecha de Nacimiento");
		msjeFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeFechaNacimiento.setBounds(38, 117, 121, 21);
		laminaPrincipal.add(msjeFechaNacimiento);

		ingresoFechaNacimiento = new JDateChooser();
		ingresoFechaNacimiento.setBounds(168, 118, 174, 20);
		laminaPrincipal.add(ingresoFechaNacimiento);
		
		JLabel msjePrimerNombre = new JLabel("Primer Nombre");
		msjePrimerNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		msjePrimerNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		msjePrimerNombre.setBounds(10, 161, 113, 14);
		laminaPrincipal.add(msjePrimerNombre);
		
		ingresoPrimerNombre = new JTextField();
		ingresoPrimerNombre.setBounds(168, 158, 174, 20);
		laminaPrincipal.add(ingresoPrimerNombre);
		ingresoPrimerNombre.setColumns(10);
		
		JLabel msjeCelular = new JLabel("Celular");
		msjeCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeCelular.setBounds(38, 294, 46, 14);
		laminaPrincipal.add(msjeCelular);
		
		ingresoCelular = new JTextField();
		ingresoCelular.setBounds(168, 291, 174, 20);
		laminaPrincipal.add(ingresoCelular);
		ingresoCelular.setColumns(10);
		
		JLabel msjeEmail = new JLabel("E-mail");
		msjeEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeEmail.setBounds(38, 333, 46, 14);
		laminaPrincipal.add(msjeEmail);
		
		ingresoEmail = new JTextField();
		ingresoEmail.setBounds(168, 330, 174, 20);
		laminaPrincipal.add(ingresoEmail);
		ingresoEmail.setColumns(10);
		
		guardar = new JButton(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\clinicaMedica\\ClinicaMedica\\src\\icon\\registrarPaciente\\guardar.png"));
		guardar.setBounds(90, 389, 50, 50);
		laminaPrincipal.add(guardar);
		
		cancelar = new JButton(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaMedico\\salir.png")); 
		cancelar.setBounds(231, 389, 50, 50);
		laminaPrincipal.add(cancelar);
		
		JLabel msjeSegundoNombre = new JLabel("Segundo Nombre");
		msjeSegundoNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeSegundoNombre.setBounds(38, 207, 102, 14);
		laminaPrincipal.add(msjeSegundoNombre);
		
		ingresoSegundoNombre = new JTextField();
		ingresoSegundoNombre.setColumns(10);
		ingresoSegundoNombre.setBounds(168, 204, 174, 20);
		laminaPrincipal.add(ingresoSegundoNombre);
		
		JLabel msjeApellido = new JLabel("Apellido");
		msjeApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		msjeApellido.setBounds(38, 250, 46, 14);
		laminaPrincipal.add(msjeApellido);
		
		ingresoApellido = new JTextField();
		ingresoApellido.setBounds(168, 247, 174, 20);
		laminaPrincipal.add(ingresoApellido);
		ingresoApellido.setColumns(10);
		
		JLabel msjeGuardar = new JLabel("GUARDAR");
		msjeGuardar.setFont(new Font("Arial", Font.BOLD, 12));
		msjeGuardar.setBounds(90, 436, 69, 14);
		laminaPrincipal.add(msjeGuardar);
		
		JLabel msjeCancelar = new JLabel("     SALIR");
		msjeCancelar.setFont(new Font("Arial", Font.BOLD, 12));
		msjeCancelar.setBounds(226, 436, 85, 14);
		laminaPrincipal.add(msjeCancelar);
		
		ControlVentanaRegistrarPaciente cVR=new ControlVentanaRegistrarPaciente(this);
		
		guardar.addActionListener(cVR);
		cancelar.addActionListener(cVR);
		
	}

	public String getIngresoDNI() {
		return ingresoDNI.getText();
	}

	public void setIngresoDNI(JTextField ingresoDNI) {
		this.ingresoDNI = ingresoDNI;
	}

	public String getIngresoPrimerNombre() {
		return ingresoPrimerNombre.getText();
	}

	public void setIngresoPrimerNombre(JTextField ingresoPrimerNombre) {
		this.ingresoPrimerNombre = ingresoPrimerNombre;
	}

	public String getIngresoCelular() {
		return ingresoCelular.getText();
	}

	public void setIngresoCelular(JTextField ingresoCelular) {
		this.ingresoCelular = ingresoCelular;
	}

	public String getIngresoEmail() {
		return ingresoEmail.getText();
	}

	public void setIngresoEmail(JTextField ingresoEmail) {
		this.ingresoEmail = ingresoEmail;
	}

	public String getIngresoSegundoNombre() {
		return ingresoSegundoNombre.getText();
	}

	public void setIngresoSegundoNombre(JTextField ingresoSegundoNombre) {
		this.ingresoSegundoNombre = ingresoSegundoNombre;
	}

	public Date getIngresoFechaNacimiento() {
		return ingresoFechaNacimiento.getDate();
	}

	public String getIngresoApellido() {
		return ingresoApellido.getText();
	}
	
	public JButton getGuardar() {
		return guardar;
	}

	public void setGuardar(JButton guardar) {
		this.guardar = guardar;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}
}
