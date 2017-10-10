package colisiones;
import objetos.*;
import defensa.*;
import enemigos.*;
import disparos.*;
import obstaculo.*;

public abstract class Visitor 
{
	//atributos
	protected GameObject objeto;
	
	//constructor
	public Visitor(GameObject g)
	{
		objeto=g;
	}
	//metodos
	public abstract boolean visitarDefensa(Defensa d);
	
	public abstract boolean visitarEnemigo(Enemigo e);
	
	public abstract boolean visitarDisparo(Disparo d);
	
	public abstract boolean visitarAgua(Agua a);
	
	public abstract boolean visitarRoca(Roca r);

}
