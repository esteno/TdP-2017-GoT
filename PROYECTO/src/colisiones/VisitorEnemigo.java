package colisiones;

import enemigos.Enemigo;
import objetos.*;
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
	public void visitarDefensa(GameObject d)
    { 
		d.recibirAtaque(miEnemigo.getFuerzaImpacto()); //de miEnemigo;
	}
	
	@Override
    public void visitarEnemigo(Enemigo e)
    {
    	System.out.println("Un enemigo ha visitado un enemigo. No hay accion.");
    }
	
	@Override
    public void visitarDisparo(Disparo d)
    { 
    	d.destruir();  // Destruye a disparo.
    }


	public void visitarFuegoValyrio(FuegoValyrio f) 
	{
		// enemigo al colisionar con fuego valyrio, muere inmediatamente.
		
	    miEnemigo.recibirAtaque(miEnemigo.getFuerzaImpacto()); 	
	    f.destruir();
	    miEnemigo.destruir();
	}


	@Override
	public void visitarExplosivo(GameObject ex) {

		ex.recibirAtaque(miEnemigo.getFuerzaImpacto());
	}




	
}
