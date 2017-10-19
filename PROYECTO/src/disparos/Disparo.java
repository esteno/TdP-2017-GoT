package disparos;
import objetos.*;
import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorDisparo;
import enemigos.*;

public abstract class Disparo extends ObjetoMovil 
{

	
	protected VisitorDisparo visitor;
	
	
	public void aceptar(Visitor v)
	{
		v.visitarDisparo(this);
	}

	@Override
	public void avanzar() {
		if(alcance > 0 || celda == null) {
			int xAnterior = celda.getX();
			int yAnterior = celda.getY();
			Celda celdaNueva = celda.celdaDerecha();
			Enemigo enemigo = celdaNueva.hayEnemigo();
			if(!celdaNueva.hayEnemigo())
			{	
				celda = celdaNueva;
				celda.moverEnemigo(xAnterior, yAnterior);
			} 
			else {
				
			}
		}
		
	}


}
