package disparos;
import objetos.*;
import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorDisparo;
import enemigos.*;

public class Disparo extends ObjetoMovil 
{

	protected VisitorDisparo visitor;
	
	
	public void aceptar(Visitor v)
	{
		v.visitarDisparo(this);
	}

	@Override
	public void avanzar()
	{
		//if(alcance > 0 || celda == null) 
		while (alcance>0 || celda==null)
		{
			int xAnterior = celda.getX();
			int yAnterior = celda.getY();
			Celda celdaNueva = celda.celdaDerecha();
			ObjetoMovil objetoMovil = celdaNueva.objetoMovil();
			if(objetoMovil!=null)
			{	
				objetoMovil.aceptar(visitor);
			} 
			else 
			{
				celda = celdaNueva;
				alcance--;
			}
		 }		
	}



}
