package obstaculo;

import colisiones.Visitor;

public class ArbolCaido extends Obstaculo {

	@Override
	public void aceptar(Visitor v) 
	{
		// TODO Auto-generated method stub
        v.visitarArbolCaido(this); 
	}

}
