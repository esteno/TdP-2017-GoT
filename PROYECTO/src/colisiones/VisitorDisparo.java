package colisiones;

import defensa.Defensa;
import objetos.*;
import disparos.*;
import enemigos.Enemigo;
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
	public void visitarDefensor(GameObject d)
    { 
		// TODO Auto-generated method stub
		System.out.println("Un disparo ha visitado una defensa. No hay accion.");
    }
	 
	@Override
    public void visitarEnemigo(Enemigo e)
    {
    	// TODO Auto-generated method stub
		System.out.println("quiere destruir mi desparo");
	    miDisparo.destruir();  //al visitar un enemigo el disparo de destruye poniendo el grafico en null
		System.out.println("quiere destruir mi enemigo");

	    e.destruir(); //por ahora destruye el enemigo
    }
	
	@Override
    public void visitarDisparo(Disparo d)
    {
    	// TODO Auto-generated method stub
		System.out.println("Un disparo ha visitado un disparo. No hay accion.");
    }
	
	@Override
    public void visitarRoca(Roca r)
	{
    	// TODO Auto-generated method stub
		// No pasa nada.
		System.out.println("Un disparo ha visitado una roca. No hay accion.");
	} 

	public void visitarArbolCaido(ArbolCaido a)
 	{
		System.out.println("Una defensa ha visitado un arbol caido. No hay accion.");
     	// TODO Auto-generated method stub
 	}
	
	public void visitarCaminanteCaido(CaminanteCaido c)
	{
		System.out.println("Una defensa ha visitado un caminante caido. No hay accion.");
	    // TODO Auto-generated method stub
	}
}
