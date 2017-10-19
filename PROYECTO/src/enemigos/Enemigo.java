package enemigos;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorEnemigo;
import logica.FabricaDeOleadas;
import objetos.GameObject;
import objetos.ObjetoMovil;

public abstract class Enemigo extends ObjetoMovil
{
	
	//atributos
	private FabricaDeOleadas fabrica;
	protected VisitorEnemigo visitor;
	protected int puntos; //puntos que devuelve al ser destruido

	public void avanzar()
    {
		if(celda.getX() != 0) 
		{
			int xAnterior = celda.getX();
			int yAnterior = celda.getY();
			Celda celdaNueva = celda.celdaIzquierda();
			if(!celdaNueva.hayEnemigo())
			{	
				celda = celdaNueva;
				celda.moverEnemigo(xAnterior, yAnterior);
			} 	
		}
		
		/*if(celda.getX() != 0) 
		{
			int xAnterior = celda.getX();
			int yAnterior = celda.getY();
			Celda celdaNueva = celda.celdaIzquierda();
			
			ObjetoMovil objetoMovil = celdaNueva.objetoMovil();
			if(objetoMovil!=null)
			{	
				objetoMovil.aceptar(visitor);
			}	
	             //	if(!celdaNueva.hayEnemigo())
			else
			{	
				celda = celdaNueva;
				celda.moverEnemigo(xAnterior, yAnterior);
			} 	
		}*/

	}
	
	public void destruir() 
	{
		celda.destruirEnemigo();	
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	
	public void aceptar(Visitor v)
	{
		v.visitarEnemigo(this);
	}

}