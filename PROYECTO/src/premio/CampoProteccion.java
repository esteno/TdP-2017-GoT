package premio;

import colisiones.Visitor;
import defensa.Defensa;

public class CampoProteccion extends MagiaTemporal 
{
	
	

	public CampoProteccion() 
	{
		// TODO Auto-generated constructor stub
	}
	public void aceptar(Visitor v)
	{
		//v.visitarCampoProteccion(this);
	}
	@Override
	public void accionar(Defensa d) {
		// TODO Auto-generated method stub
		
	}

}
