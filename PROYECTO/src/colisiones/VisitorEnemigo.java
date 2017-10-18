package colisiones;

import defensa.Defensa;
import enemigos.ObjetoMovil;
import objetos.*;
import disparos.*;
import obstaculo.*;

public class VisitorEnemigo extends Visitor
{
	protected ObjetoMovil miEnemigo;
	//constructor
	public VisitorEnemigo(ObjetoMovil g)
	{
		miEnemigo=g;
	}
	
	
	//metodos
	@Override
	public void visitar(Defensa d)
    { 
		// TODO Auto-generated method stub
		d.recibirAtaque(miEnemigo.getFuerzaImpacto()); //de miEnemigo;
	}
	
	@Override
    public void visitar(Enemigo e)
    {
    	// TODO Auto-generated method stub
		System.out.println("Un enemigo ha visitado un enemigo. No hay acción.");
    }
	
	@Override
    public void visitar(Disparo d)
    { 
    	// TODO Auto-generated method stub
    	d.destruir();
    	miEnemigo.destruir();
    }
	
	@Override
    public void visitar(Agua a)
	{
    	// TODO Auto-generated method stub
    	//morir ahogado o avanzar lento
    }
	
	@Override
    public void visitar(Roca r)
	{
    	// TODO Auto-generated method stub
		r.recibirAtaque(miEnemigo.getFuerzaImpacto());
    } 
	
}
