package colisiones;

import defensa.Bomba;
import defensa.Defensa;
import defensa.Mina;
import objetos.*;
import disparos.*;
import enemigos.Enemigo;
import obstaculo.*;
import premio.CampoProteccion;


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
	public void visitarDefensa(GameObject d)
    { 
		// TODO Auto-generated method stub
		System.out.println("Un disparo ha visitado una defensa. No hay accion.");
    }
	 
	@Override
    public void visitarEnemigo(Enemigo e)
    {
    	// TODO Auto-generated method stub
		//System.out.println("quiere destruir mi desparo");
	    miDisparo.destruir();  //al visitar un enemigo el disparo de destruye poniendo el grafico en null
		//System.out.println("quiere destruir mi enemigo");

	    e.recibirAtaque(miDisparo.getFuerzaImpacto()); //por ahora destruye el enemigo
    }
	
	@Override
    public void visitarDisparo(Disparo d)
    {
    	// TODO Auto-generated method stub
		System.out.println("Un disparo ha visitado un disparo. No hay accion.");
    }

	public void visitarBomba(Bomba b) {
		
		System.out.println("Una bomba ha visitado un disparo. No hay accion.");
	}

	public void visitarMina(Mina m) {
		
		System.out.println("Una mina ha visitado un disparo. No hay accion.");
	}

	@Override
	public void visitarFuegoValyrio(FuegoValyrio f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarCampoProteccion(CampoProteccion c) 
	{
		// TODO Auto-generated method stub	
	}



}
	


