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
	public abstract void visitarDefensa(Defensa d);
	
	public abstract void visitarEnemigo(Enemigo e);
	
	public abstract void visitarDisparo(Disparo d);
	
	public abstract void visitarAgua(Agua a);
	
	public abstract void visitarRoca(Roca r);

}
