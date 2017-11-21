package colisiones;

import enemigos.Enemigo;
import objetos.*;
import defensa.Defensa;
import disparos.*;
import obstaculo.*;


public class VisitorEnemigo extends Visitor
{
	protected Enemigo miEnemigo;
	
	
	//constructor
	public VisitorEnemigo(Enemigo g)
	{
		miEnemigo=g;
	}
	
	
	//metodos
	@Override
	public void visitarDefensa(Defensa d)
    { 
		d.recibirAtaque(miEnemigo.getFuerzaImpacto()); //de miEnemigo;
		System.out.println("Yo enemigo recibi una defensa.");
	}
	
	@Override
    public void visitarEnemigo(Enemigo e)
    {
    	System.out.println("Un enemigo ha visitado un enemigo. No hay accion.");
    }




	
}
