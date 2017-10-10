package objetos;

import java.awt.image.BufferedImage;
import colisiones.*;
import celdas.Celda;
import logica.FabricaObjetoGrafico;
import logica.Juego;

public abstract class GameObject
{
  
	protected GameObjectGrafico grafico;
	protected Celda celda;
	protected int puntaje;
	protected Boolean isRunning = true;
	protected FabricaObjetoGrafico fabricaGrafica = FabricaObjetoGrafico.getInstancia();
	protected int resistencia;
	
	
	public BufferedImage getGrafico() {
		return grafico.getImagen();
	}
	
	public void setCelda(Celda celdaNueva) {
		celda = celdaNueva;
	}
	
	public void destruir()
	{
		grafico=null;
	}
	
	//public abstract boolean aceptar(Visitor v);
	
	public int getResistencia()
	{ return resistencia; }
	
	public void decrementarResistencia()
	{  resistencia=resistencia--; }
	
	public Celda getCelda()
	{ return celda;}
}

