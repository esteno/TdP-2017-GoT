package colisiones;

import defensa.Defensa;
import enemigos.Enemigo;
import objetos.*;
import disparos.*;
import obstaculo.*;

public class VisitorDisparo extends Visitor
{
	protected Disparo miDisparo;
	//constructor
	public VisitorDisparo(Disparo g)
	{
		miDisparo=g;
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
	    this.miDisparo.destruir();    //al visitar un enemigo el disparo de destruye poniendo el grafico en null
	    Disparo disparo = (Disparo) miDisparo;
	    e.aceptar(this);
	    e.getCelda().getMapa().eliminarEnemigo(e.getCelda().getX(), e.getCelda().getY());
	    //disparo.getDefensa().getJuego().getPuntaje().sumarPuntos(e.getPuntaje());
    }
	
	@Override
    public void visitarDisparo(Disparo d)
    {
    	// TODO Auto-generated method stub
    }
	
	@Override
    public void visitarAgua(Agua a)
	{
    	// TODO Auto-generated method stub
    }
	
	@Override
    public void visitarRoca(Roca r)
	{
    	// TODO Auto-generated method stub
	} 

}
