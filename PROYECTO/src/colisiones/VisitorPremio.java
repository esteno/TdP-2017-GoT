package colisiones;

import disparos.Disparo;
import enemigos.Enemigo;
import objetos.GameObject;
import obstaculo.ArbolCaido;
import obstaculo.CaminanteCaido;
import obstaculo.Roca;
import premio.AceroValirio;
import premio.Barricada;
import premio.CampoProteccion;
import premio.Mina;
import premio.Premio;

public class VisitorPremio extends Visitor 
{

	protected Premio miPremio;
	
	@Override
	public void visitarDefensor(GameObject d) 
	{
		// TODO Auto-generated method stub
		System.out.println("Un premio ha visitado un defensor. No hay accion.");

	}

	@Override
	public void visitarEnemigo(Enemigo e) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void visitarDisparo(Disparo d) {
		// TODO Auto-generated method stub

	}

	// En este visitor debo afectar a enemigo

	@Override
	public void visitarMina(Mina m) 
	{
		// TODO Auto-generated method stub
	    m.destruir();	
	}

	@Override
	public void visitarCampoProteccion(CampoProteccion c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarBarricada(Barricada b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarAceroValirio(AceroValirio a) 
	{
		// TODO Auto-generated method stub
	}

}
