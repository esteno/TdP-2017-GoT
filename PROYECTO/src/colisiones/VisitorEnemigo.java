package colisiones;

import defensa.Defensa;
import enemigos.Enemigo;
import objetos.*;
import disparos.*;
import obstaculo.*;
import premio.Bomba;
import premio.CampoProteccion;
import premio.Mina;


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
    	d.destruir();  // Destruye a disparo.
    }


	@Override
	public void visitarBomba(Bomba m) 
	{
		// TODO Auto-generated method stub
		
		miEnemigo.recibirAtaque(m.getFuerzaImpacto());
	    m.destruir();	
	}


	

	@Override
	public void visitarFuegoValyrio(FuegoValyrio f) 
	{
		// TODO Auto-generated method stub
		// enemigo al colisionar con fuego valyrio, muere inmediatamente.
		
	    miEnemigo.recibirAtaque(miEnemigo.getFuerzaImpacto()); 	
	    f.destruir();
	    miEnemigo.destruir();
	}


	@Override
	public void visitarMina(Mina m) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visitarCampoProteccion(CampoProteccion c) 
	{
		// TODO Auto-generated method stub
		c.destruir();
		miEnemigo.destruir();
	}




	
}
