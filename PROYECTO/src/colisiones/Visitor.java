package colisiones;
import objetos.*;
import enemigos.*;
import defensa.Defensa;
import disparos.*;
import obstaculo.*;

public abstract class Visitor 
{	 
	//metodos
	public abstract void visitarDefensa(Defensa d);
	
	public abstract void visitarEnemigo(Enemigo e);
	
}