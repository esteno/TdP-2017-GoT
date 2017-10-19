package colisiones;
import objetos.*;
import defensa.*;
import enemigos.*;
import disparos.*;
import obstaculo.*;

public abstract class Visitor 
{	 
	//metodos
	public abstract void visitarDefensor(Defensa d);
	
	public abstract void visitarEnemigo(Enemigo e);
	
	public abstract void visitarDisparo(Disparo d);
	
	public abstract void visitarAgua(Agua a);
	
	public abstract void visitarRoca(Roca r);

}
