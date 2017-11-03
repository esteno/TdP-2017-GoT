package objetos;

import java.awt.Container;
import java.awt.Label;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class GameObjectGrafico 
{
	protected JLabel label;
	protected ImageIcon imagen;
	
	
	public GameObjectGrafico(String path) 
	{
	    try {
			imagen = new ImageIcon(new URL("file:"+path));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}// ImageIO.read(new File(path));
	}
	
	public void setLabel(JLabel l) {
		label = l;
	}
	public JLabel getLabel(){
		return label;
	}
	
	
	public ImageIcon getImagen() 
	{
		return imagen;
	}
	
	public void destruir() {
		Container padre = label.getParent();
		padre.remove(label);
		padre.validate();
		padre.repaint();
	}
	
	

}
