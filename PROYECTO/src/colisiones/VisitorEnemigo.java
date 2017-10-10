package colisiones;

import defensa.Defensa;
import enemigos.Enemigo;
import objetos.*;
import disparos.*;
import obstaculo.*;

public class VisitorEnemigo extends Visitor
{
	
	//constructor
	public VisitorEnemigo(GameObject g)
	{
		super(g);
	}
	
	//metodos
	
	@Override
	public boolean visitarDefensa(Defensa d)
    { 
		// TODO Auto-generated method stub
		//atacar(d);
		return true;
	}
	
	@Override
    public boolean visitarEnemigo(Enemigo e)
    {
    	// TODO Auto-generated method stub
    	return false; 
    }
	
	@Override
    public boolean visitarDisparo(Disparo d)
    { 
    	// TODO Auto-generated method stub
    	this.objecto.aceptar(d);
    	return true; 
    }
	
	@Override
    public boolean visitarAgua(Agua a)
	{
    	// TODO Auto-generated method stub
    	//morir ahogado?
    	return true; 
    }
	
	@Override
    public boolean visitarRoca(Roca r)
	{
    	// TODO Auto-generated method stub
    	return true;
    } 
	
}
