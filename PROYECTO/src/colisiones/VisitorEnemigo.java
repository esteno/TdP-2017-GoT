package colisiones;

import defensa.Defensa;
import enemigos.Enemigo;
import objetos.*;
import disparos.*;
import obstaculo.*;
import defensa.Bomba;
import premio.CampoProteccion;
import defensa.Mina;


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


	public void visitarBomba(Bomba b) 
	{
		// TODO Auto-generated method stub
		
		miEnemigo.recibirAtaque(b.getFuerzaImpacto());
	    b.destruir();	
	}


	public void visitarFuegoValyrio(FuegoValyrio f) 
	{
		// TODO Auto-generated method stub
		// enemigo al colisionar con fuego valyrio, muere inmediatamente.
		
	    miEnemigo.recibirAtaque(miEnemigo.getFuerzaImpacto()); 	
	    f.destruir();
	    miEnemigo.destruir();
	}

	
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
