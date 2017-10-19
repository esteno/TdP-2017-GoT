package disparos;
import objetos.*;
import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorDisparo;

public class Disparo extends ObjetoMovil 
{

	protected VisitorDisparo visitor;
	
	public Disparo() {
		alcance = 30;
		grafico = fabricaGrafica.construirGraficoDisparo();
	}
	
	
	public void aceptar(Visitor v)
	{
		v.visitarDisparo(this);
	}

	@Override
	public void avanzar()
	{
		Celda celdaNueva = celda.celdaDerecha();
		
		if(alcance > 0 || celdaNueva != null) 
		{
			
			/*
			ObjetoMovil objetoMovil = celdaNueva.objetoMovil();
			if(objetoMovil!=null)
			{	
				objetoMovil.aceptar(visitor);
			} 
			else 
			{
			*/
				int xAnterior = celda.getX();
				int yAnterior = celda.getY();
				celda = celdaNueva;
				celda.moverEnemigo(xAnterior, yAnterior);
				
				alcance--;
			}
		/*	 }
	
		else {
			destruir();
		}*/
	}
	
	public void destruir() {
		
	}


	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}



}
