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
	
	public abstract void visitarRoca(Roca r);

	public abstract void visitarArbolCaido(ArbolCaido a);
	
	public abstract void visitarCaminanteCaido(CaminanteCaido c);
	
	public abstract void visitarBomba(Bomba b);
	
	public abstract void visitarCampoProteccion(CampoProteccion c);
	
	public abstract void visitarBarricada(Barricada b);
	
	public abstract void visitarAceroValirio(AceroValirio a);
}
