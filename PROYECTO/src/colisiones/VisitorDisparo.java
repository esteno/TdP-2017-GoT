package colisiones;

import defensa.Defensa;
import enemigos.Enemigo;
import objetos.*;
import disparos.*;
import obstaculo.*;

public class VisitorDisparo extends Visitor
{
	
	//constructor
	public VisitorDisparo(GameObject g)
	{
		super(g); 
	}
	
	//metodos
	
	@Override
	public boolean visitarDefensa(Defensa d)
    { 
		// TODO Auto-generated method stub
		return false;
    }
	 
	@Override
    public boolean visitarEnemigo(Enemigo e)
    {
    	// TODO Auto-generated method stub
	    this.objeto.destruir();    //al visitar un enemigo el disparo de destruye poniendo el grafico en null
	    Disparo disparo = (Disparo) objeto;
	    //e.aceptar(this);
	    e.getCelda().getMapa().eliminarEnemigo(e.getCelda().getX(), e.getCelda().getY());
	    //disparo.getDefensa().getJuego().getPuntaje().sumarPuntos(e.getPuntaje());
	    return true;
    }
	
	@Override
    public boolean visitarDisparo(Disparo d)
    {
    	// TODO Auto-generated method stub
		return false;
    }
	
	@Override
    public boolean visitarAgua(Agua a)
	{
    	// TODO Auto-generated method stub
		return false;
    }
	
	@Override
    public boolean visitarRoca(Roca r)
	{
    	// TODO Auto-generated method stub
		return false;
	} 

}
