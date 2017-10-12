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
	public void visitarDefensa(Defensa d)
    { 
		// TODO Auto-generated method stub
	}
	
	@Override
    public void visitarEnemigo(Enemigo e)
    {
    	// TODO Auto-generated method stub
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
    } 
	
}
