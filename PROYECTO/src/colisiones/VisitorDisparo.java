package colisiones;

import defensa.Defensa;
import objetos.*;
import disparos.*;
import enemigos.Enemigo;
import obstaculo.*;
import premio.AceroValirio;
import premio.Barricada;
import premio.Bomba;
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
	public void visitarBomba(Bomba b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarCampoProteccion(CampoProteccion c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBarricada(Barricada b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarAceroValirio(AceroValirio a) {
		// TODO Auto-generated method stub
		
	}
}
