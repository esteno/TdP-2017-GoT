package premio;

import colisiones.Visitor;

public class FuegoValyrio extends ObjetoPrecioso 
{

	public FuegoValyrio()
	{}
	
	
	@Override
	public void aceptar(Visitor v)
    {
		// TODO Auto-generated method stub
        v.visitarFuegoValyrio(this);
	}


}
