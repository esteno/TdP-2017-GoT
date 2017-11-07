package obstaculo;

import java.util.List;

import colisiones.Visitor;
import defensa.Defensa;

public class FuegoValyrio extends Obstaculo
{

	public FuegoValyrio()
	{
		precio = 30;
	}
	
	public void aceptar(Visitor v)
	{
		v.visitarFuegoValyrio(this);
	}


}
