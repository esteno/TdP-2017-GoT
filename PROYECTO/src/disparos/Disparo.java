package disparos;
import objetos.*;
import colisiones.Visitor;
import colisiones.VisitorDisparo;
import enemigos.*;

public class Disparo extends ObjetoMovil implements Runnable
{
	protected VisitorDisparo visitor;
	
	public Disparo() 
	{ }

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub	
	}
	 
	public void aceptar(Visitor v)
	{
		v.visitarDisparo(this);
	}

	
	public void accionar(GameObject o)
    {
		o.aceptar(visitor);
    }

}
