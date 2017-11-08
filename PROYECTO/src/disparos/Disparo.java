package disparos;
import objetos.*;
import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorDisparo;

public class Disparo extends ObjetoMovil 
{
	public Disparo() 
	{
		velocidad=8;
		alcance = 30;
		fuerza_impacto = 1000;
		grafico = fabricaGrafica.construirGraficoDisparo();
	}
	
	
	public void aceptar(Visitor v)
	{
		v.visitarDisparo(this);
	}

	
	@Override
	public void avanzar()
	{
		//Pide la celda a la que se va a mover
		Celda celdaDerecha = celda.celdaDerecha();
		
		//Pido el objeto movil de la celda que esta a la derecha
		ObjetoMovil objetoMovil = celdaDerecha.objetoMovil();
		
		//Si todavia tiene alcance y no llego al 
		if (  (alcance > 0 )   &&   (objetoMovil != null) )
			
			
			//if(objetoMovil!=null)
			//{	
				//Le pasa el visitor, si es enemigo lo ataca, si es otro disparo no hace nada.
		objetoMovil.aceptar(new VisitorDisparo(this));
			//} 
		else 
		{
				//Guarda la posicion actual
				int xAnterior = celda.getX();
				int yAnterior = celda.getY();
				
				//Cambia de celda
				celda = celdaDerecha;

				//Se mueve
				celda.moverEnemigo(this,xAnterior, yAnterior);

				//Decrementa el alcance
				alcance--;
		}
		
	}
	
	
	public void destruir() 
	{
		//Para poder ser removido 
		alcance=0;
		//celda.destruirObjetoMovil();
		grafico.destruir();
	}


	@Override
	public void atacar() 
	{
		// TODO Auto-generated method stub
	}



}
