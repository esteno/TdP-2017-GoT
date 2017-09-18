package objetos;

import java.awt.image.BufferedImage;

public abstract class GameObject implements Runnable 
{
  
	private GameObjectGrafico grafico;
	
	public GameObject(String path) {
		grafico = new GameObjectGrafico(path);
	}
	
	public BufferedImage getGrafico() {
		return grafico.getImagen();
	}
}
