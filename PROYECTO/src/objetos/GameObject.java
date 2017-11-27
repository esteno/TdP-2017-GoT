package objetos;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import colisiones.*;
import celdas.*;
import logica.FabricaObjetoGrafico;

public abstract class GameObject{
	//atributos
	protected GameObjectGrafico grafico;
	protected CeldaCompuesta celdas;
	protected int puntosVida; // de vida de cada objeto
	protected boolean isRunning = true;
	protected FabricaObjetoGrafico fabricaGrafica = FabricaObjetoGrafico.getInstancia();
	protected int fuerzaImpacto; // cuanta vida consume al atacar
	
	//Alto y ancho del objeto (en celdas)
	protected int alto = 1;
	protected int ancho = 1;
	
	//Valor que da el tiempo entre ataque y ataque
    protected int velocidadAtaque;
    
    //Contador que se va decrementando, cuando llega a 0 la gameObject ataca.
    protected int proximoAtaque = 0;
	
	//metodos
	public GameObjectGrafico getGrafico(){
		return grafico;
	}
	
	public void setCelda(CeldaCompuesta celdasNuevas){
		celdas = celdasNuevas;
	}
	
	public abstract void aceptar(Visitor v);
	
	public abstract void atacar();
	
	public CeldaCompuesta getCelda(){ 
		return celdas;
	}
	
	public void recibirAtaque(int i){
		puntosVida -= i;
		if(puntosVida < 0) 
			destruir();
	}
	
	public abstract void destruir();
	
	public int getFuerzaImpacto(){
		return fuerzaImpacto;
	}
	
	public int getPuntosVida(){
		return puntosVida;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public int getAncho() {
		return ancho;
	}

}