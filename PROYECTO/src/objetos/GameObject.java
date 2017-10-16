package objetos;

import java.awt.image.BufferedImage;
import colisiones.*;
import celdas.Celda;
import logica.FabricaObjetoGrafico;
import logica.Juego;

public abstract class GameObject
{

	//atributos
	protected GameObjectGrafico grafico;
	protected Celda celda;
	protected int puntos_vida; // de vida de casa objeto
	protected Boolean isRunning = true;
	protected FabricaObjetoGrafico fabricaGrafica = FabricaObjetoGrafico.getInstancia();
	protected int fuerza_impacto;
	protected int alcance;
	
	//metodos
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
	
	
	public abstract void aceptar(Visitor v);
	
	public abstract void accionar(GameObject o);
	
	
	public Celda getCelda()
	{ return celda;}
	
	public int getFuerzaImpacto()
	{
		return fuerza_impacto;
	}
	
}

