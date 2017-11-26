package objetos;

import java.awt.Container;
import java.awt.Label;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class GameObjectGrafico {
	
	protected JLabel label;
	protected ImageIcon imagen;
	protected boolean bloqueado;
	
	public GameObjectGrafico(String path) {
		bloqueado=false;
	    try {
			imagen = new ImageIcon(new URL("file:"+path));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void setLabel(JLabel l) {
		label = l;
	}
	public JLabel getLabel(){
		return label;
	}
	
	public ImageIcon getImagen() {
		return imagen;
	}
	
	public synchronized boolean Lock(Boolean b){
		if(b!=true) bloqueado=false;
		return bloqueado;
	}
	public void setBloqueado(boolean b){
		bloqueado=b;
	}
	public boolean moverGrafico(int velocidad){
		int x=label.getBounds().x;
		x=x+velocidad;
		boolean toret=true;
		if((x%50)<Math.abs(velocidad)){
			if(velocidad>0)x=x+(x%50);
			else x=x-(x%50);
			toret=false;
			bloqueado=false;
		}
		label.setBounds(x, label.getBounds().y, label.getBounds().width, label.getBounds().height);
		return toret;
	}
	
	public void destruir() {
		Container padre = label.getParent();
		if(padre!=null){
			padre.remove(label);
			padre.validate();
			padre.repaint();	
		}
	}
}
