package colisiones;
import enemigos.*;
import defensa.Defensa;

public abstract class Visitor 
{	 
	//metodos
	public abstract void visitarDefensa(Defensa d);
	
	public abstract void visitarEnemigo(Enemigo e);
	
}