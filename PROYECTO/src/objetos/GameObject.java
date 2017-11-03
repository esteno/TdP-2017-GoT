package objetos;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import colisiones.*;
import celdas.Celda;
import logica.FabricaObjetoGrafico;

public abstract class GameObject
{

	//atributos
	protected GameObjectGrafico grafico;
	protected Celda celda;
	protected int puntos_vida; // de vida de cada objeto
	protected boolean isRunning = true;
	protected FabricaObjetoGrafico fabricaGrafica = FabricaObjetoGrafico.getInstancia();
	protected int fuerza_impacto; // cuanta vida consume al atacar
	protected int alcance;
	
	//metodos
	public GameObjectGrafico getGrafico()
	{
		return grafico;
	}
	
	public void setCelda(Celda celdaNueva)
	{
		celda = celdaNueva;
	}
	
	
	public void destruir()
	{
		grafico=null;
	}
	
	
	public abstract void aceptar(Visitor v);
	
	
	
	public Celda getCelda()
	{ 
		return celda;
	}
	
	
	public int getFuerzaImpacto()
	{
		return fuerza_impacto;
	}

	
	public int getPuntosVida()
	{
		return puntos_vida;
	}
	
	
	public int getAlcance()
	{
		return alcance;
	}
	
	public void recibirAtaque(int i)
	{
		puntos_vida=-i;
		if(puntos_vida < 0) {
			destruir();
		}
	}
	
	public abstract void atacar();

	public void accionarPorTiempo() {

		this.destruir();
	}
}


