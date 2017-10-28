package colisiones;

import defensa.Defensa;
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
	public void visitarDefensor(Defensa d)
    { 
		// TODO Auto-generated method stub
		d.recibirAtaque(miEnemigo.getFuerzaImpacto()); //de miEnemigo;
	}
	
	@Override
    public void visitarEnemigo(Enemigo e)
    {
    	// TODO Auto-generated method stub
		System.out.println("Un enemigo ha visitado un enemigo. No hay accion.");
    }
	
	@Override
    public void visitarDisparo(Disparo d)
    { 
    	// TODO Auto-generated method stub
    	d.destruir();   // Destruye a disparo.
    	miEnemigo.destruir();
    }
	
	@Override
    public void visitarAgua(Agua a)
	{
    	// TODO Auto-generated method stub
		// VER EL IMPACTO QUE TENDRA AGUA EN ENEMIGO
    	miEnemigo.recibirAtaque(a.getFuerzaImpacto());
    }
	
	@Override
    public void visitarRoca(Roca r)
	{
    	// TODO Auto-generated method stub
		if(r.getPuntosVida()<=0)
		{
			r.destruir();
		}
		else
		{
			// Enemigo golpea a Roca hasta destruirla, es decir le quita a Roca puntos de vida.
	     	r.recibirAtaque(miEnemigo.getFuerzaImpacto());
		}	
	} 
	
}
