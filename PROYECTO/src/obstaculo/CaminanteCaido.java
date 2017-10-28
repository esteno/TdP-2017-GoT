package obstaculo;

import colisiones.Visitor;

public class CaminanteCaido extends Obstaculo 
{

	@Override
	public void aceptar(Visitor v) 
	{
		// TODO Auto-generated method stub
        v.visitarCaminanteCaido(this);
	}

}
