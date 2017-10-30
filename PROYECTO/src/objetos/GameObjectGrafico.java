package objetos;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;


public class GameObjectGrafico 
{
	
	protected ImageIcon imagen;
	
	
	public GameObjectGrafico(String path) 
	{
	    try {
			imagen = new ImageIcon(new URL("file:"+path));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}// ImageIO.read(new File(path));
	}
	
	
	
	
	public ImageIcon getImagen() 
	{
		return imagen;
	}
	
	

}
