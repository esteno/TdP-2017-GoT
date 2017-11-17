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
	protected int puntosVida; // de vida de cada objeto
	protected boolean isRunning = true;
	protected FabricaObjetoGrafico fabricaGrafica = FabricaObjetoGrafico.getInstancia();
	protected int fuerzaImpacto; // cuanta vida consume al atacar
	
	//Valor que da el tiempo entre ataque y ataque
    protected int velocidadAtaque;
    
    //Contador que se va decrementando, cuando llega a 0 la gameObject ataca.
    protected int proximoAtaque = 0;

	
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
		return fuerzaImpacto;
	}
	
	public int getPuntosVida()
	{
		return puntosVida;
	}
	
	
	public void recibirAtaque(int i)
	{
		puntosVida=-i;
		if(puntosVida < 0) {
			destruir();
		}
	}
	
	public abstract void atacar();

	public void accionarPorTiempo() {

		this.destruir();
	}
}