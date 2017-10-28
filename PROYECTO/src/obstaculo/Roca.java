package obstaculo;

import colisiones.Visitor;

public class Roca extends Obstaculo 
{

	public Roca() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public void aceptar(Visitor v)
	{
		v.visitarRoca(this);
	}


}
