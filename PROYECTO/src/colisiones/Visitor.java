package colisiones;
import objetos.*;
import enemigos.*;
import disparos.*;
import obstaculo.*;

public abstract class Visitor 
{	 
	//metodos
	public abstract void visitarDefensa(GameObject d);
	
	
	public abstract void visitarEnemigo(Enemigo e);
	
  	
}
