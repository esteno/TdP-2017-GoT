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
	public void visitarDefensa(Defensa d)
    { 
		// TODO Auto-generated method stub
		d.aceptar(this);
	}
	
	@Override
    public void visitarEnemigo(Enemigo e)
    {
    	// TODO Auto-generated method stub
		System.out.println("Un enemigo ha visitado un enemigo");
    }
	
	@Override
    public void visitarDisparo(Disparo d)
    { 
    	// TODO Auto-generated method stub
    	d.aceptar(this);
    	
    }
	
	@Override
    public void visitarAgua(Agua a)
	{
    	// TODO Auto-generated method stub
    	//morir ahogado?
    }
	
	@Override
    public void visitarRoca(Roca r)
	{
    	// TODO Auto-generated method stub
		//
    } 
	
}
