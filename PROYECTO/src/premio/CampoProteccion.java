package premio;

import colisiones.Visitor;

public class CampoProteccion extends MagiaTemporal 
{
	
	

	public CampoProteccion() 
	{
		// TODO Auto-generated constructor stub
	}
	public void aceptar(Visitor v)
	{
		v.visitarCampoProteccion(this);
	}

}
