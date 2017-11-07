package premio;

import java.util.List;

import colisiones.Visitor;
import defensa.Defensa;

public class CampoProteccion extends Defensa
{
	
	// Campo proteccion mata al proximo enemigo que lo toca y deja 1000 puntos plus
	private int plus;

	public CampoProteccion() 
	{
		// TODO Auto-generated constructor stub
		plus = 1000;
		precio = 0;
	}
	
	
	public void aceptar(Visitor v)
	{
		v.visitarCampoProteccion(this);
	}


	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
	

}
