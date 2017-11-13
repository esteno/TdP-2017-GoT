package disparos;
import objetos.*;
import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorDisparo;

public class Disparo extends ObjetoMovil 
{
	protected int alcance;
	
	public Disparo(double danio) 
	{
		velocidad=8;
		alcance = 30;
		fuerzaImpacto = (int) Math.floor(danio);
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
		Celda celdaNueva = celda.celdaDerecha();
		//Si todavia tiene alcance y no llego al 
		if(alcance > 0 || celdaNueva != null) 
		{	
			//Si hay otro objeto movil en esa celda
			ObjetoMovil objetoMovil = celdaNueva.objetoMovil();
			if(objetoMovil!=null)
			{	
				//Le pasa el visitor, si es enemigo lo ataca, si es otro disparo no hace nada.
				objetoMovil.aceptar(new VisitorDisparo(this));
			} 
			else 
			{
				//Guarda la posicion actual
				int xAnterior = celda.getX();
				int yAnterior = celda.getY();
				
				//Cambia de celda
				celda = celdaNueva;

				//Se mueve
				celda.moverEnemigo(this,xAnterior, yAnterior);

				//Decrementa el alcance
				alcance--;
			}
		}
		else
		{
			destruir();
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
	
	public int getAlcance() {
		return alcance;
	}



}

