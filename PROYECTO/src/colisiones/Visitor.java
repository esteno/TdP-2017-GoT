package colisiones;
import objetos.*;
import defensa.*;
import enemigos.*;
import disparos.*;
import obstaculo.*;
import premio.*;

public abstract class Visitor 
{	 
	//metodos
	public abstract void visitarDefensa(GameObject d);
	
	public abstract void visitarEnemigo(Enemigo e);
	
	public abstract void visitarDisparo(Disparo d);
	
	public abstract void visitarBomba(Bomba b);
	
	public abstract void visitarMina(Mina m);
	
	public abstract void visitarFuegoValyrio(FuegoValyrio f);
	
	public abstract void visitarCampoProteccion(CampoProteccion c);
  	
}
