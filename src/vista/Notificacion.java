package vista;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Notificacion extends JButton {
	
	private int numero;
	private Image imagenNotificacion;
	 
	 
	/*Crea un nuevo Notificacion con el valor ya aplicado y mostrando la insignia. *
	 * @param valor: el valor que se mostrará inicialmente en la insignia.
	 */
	public Notificacion(int valor) 
	{
		setNumero(valor);
		
	}

	//Constructor por defecto que  inicializa  un nuevo JSBadgeButton con el valor establecido en cero.
	public Notificacion() {
		
		//Con el this se inicializa la variable numero pasando al constructor Notificacion (que recibe un entero).
		this(0);
		setBorder(null);
		setBackground(Color.WHITE);
		imagenNotificacion = getImage();
	}
	
	  
	//Carga una imagen de un director del disco. Respectivamente retorna la imagen cargada.	
	private Image getImage() 
	{
		BufferedImage img = null;
		
		try 
		{
			img=ImageIO.read(new File("C:\\Users\\ArielPaez\\Desktop\\clinicaMedica\\ClinicaMedica\\src\\icon\\ventanaAdministrador\\notificaciones.png"));
		} 
		catch (IOException e) {}
		
		return img;
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		if (getNumero() >= 0) 
		{
			//La imagen se dibuja en el JButton con su esquina superior izquierda en (x, y) 
			//en el espacio de coordenadas de este contexto gráfico.
			g.drawImage(imagenNotificacion,0, 0, null);
			
			g.setColor(Color.RED);
			
			if (getNumero()>0 && getNumero()< 10)
			{
				g.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));
				 
				g.drawString(Integer.toString(getNumero()), this.getWidth() - 25, 24);
			}
			else if (getNumero() >= 10 && getNumero() < 100) 
			{
				g.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
				 
				g.drawString(Integer.toString(getNumero()), this.getWidth() - 29, 23);
			}
			else if (getNumero() >= 100) 
			{
				g.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
			 
				//Se como valor máximo el valor 99.
				g.drawString("99", this.getWidth() - 29, 23);
			}
		}
		/*else if (getNumero()==-1) 
		{
			g.drawImage(imagenNotificacion, this.getWidth() - 34, 0, null);
		}*/
	}
	
	/*Cambia el número de la insignia por un nuevo valor. 
	  Si el nuevo valor es cero, no se mostrará la insignia.
	  @param valor: el nuevo valor que se mostrará en la insignia.
	 */
	public void setNumero(int valor)
	{
		numero = valor;
		repaint();
	}
	
	
	 //Devuelve el valor actual que muestra la insignia (incluido el cero).
	  
	 //@return el valor actual de la insignia
	 
	public int getNumero() {
		return numero;
	}
	
	//Aumenta el valor de la insignia de uno en uno 
	
	public void incremento() {
		setNumero(getNumero() + 1);
		repaint();
	}
	
	//Disminuye el valor de la insignia en uno, si el valor actualmente es mayor que cero.
	
	public void decremento() {
		
		if (getNumero() > 0) 
		{
			setNumero(getNumero() - 1);
			repaint();
		}
	}
}
