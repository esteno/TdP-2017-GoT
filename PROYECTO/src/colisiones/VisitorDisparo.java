package colisiones;

import defensa.Defensa;
import enemigos.ObjetoMovil;
import objetos.*;
import disparos.*;
import obstaculo.*;

public class VisitorDisparo extends Visitor
{
	//atributos
	protected Disparo miDisparo;
	
	//constructor
	public VisitorDisparo(Disparo g)
	{
		miDisparo=g;
	}
	
	//metodos
	@Override
	public void visitar(Defensa d)
    { 
		// TODO Auto-generated method stub
		System.out.println("Un disparo ha visitado una defensa. No hay acción.");
    }
	 
	@Override
    public void visitar(Enemigo e)
    {
    	// TODO Auto-generated method stub
	    miDisparo.destruir();  //al visitar un enemigo el disparo de destruye poniendo el grafico en null
	    e.destruir(); //por ahora destruye el enemigo
    }
	
	@Override
    public void visitar(Disparo d)
    {
    	// TODO Auto-generated method stub
		System.out.println("Un disparo ha visitado un disparo. No hay acción.");
    }
	
	@Override
    public void visitar(Agua a)
	{
    	// TODO Auto-generated method stub
		// No pasa nada.
		System.out.println("Un disparo ha visitado el agua. No hay acción.");
    }
	
	@Override
    public void visitar(Roca r)
	{
    	// TODO Auto-generated method stub
		// No pasa nada.
		System.out.println("Un disparo ha visitado una roca. No hay acción.");
	} 

}
