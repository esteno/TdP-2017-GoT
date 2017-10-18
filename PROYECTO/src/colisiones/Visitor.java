package colisiones;
import objetos.*;
import defensa.*;
import enemigos.*;
import disparos.*;
import obstaculo.*;

public abstract class Visitor 
{	 
	//metodos
	public abstract void visitar(Defensa d);
	
	public abstract void visitar(Enemigo e);
	
	public abstract void visitar(Disparo d);
	
	public abstract void visitar(Agua a);
	
	public abstract void visitar(Roca r);

}
