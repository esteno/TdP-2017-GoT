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
	public abstract void visitarDefensor(GameObject d);
	
	public abstract void visitarEnemigo(Enemigo e);
	
	public abstract void visitarDisparo(Disparo d);
	
	public abstract void visitarMina(Mina m);
	
	public abstract void visitarCampoProteccion(CampoProteccion c);
	
	public abstract void visitarBarricada(Barricada b);
	
	public abstract void visitarAceroValirio(AceroValirio a);
}
