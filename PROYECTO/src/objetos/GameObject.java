package objetos;

import java.awt.image.BufferedImage;

import celdas.Celda;
import logica.Juego;

public abstract class GameObject implements Runnable 
{
  
	protected GameObjectGrafico grafico;
	protected Celda celda;
	protected Juego juego;
	
	public GameObject(String path) {
		grafico = new GameObjectGrafico(path);
	}
	
	public BufferedImage getGrafico() {
		return grafico.getImagen();
	}
	
	public void setCelda(Celda celdaNueva) {
		celda = celdaNueva;
	}
}
