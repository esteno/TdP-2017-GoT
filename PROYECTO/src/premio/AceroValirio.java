package premio;

import colisiones.Visitor;

public class AceroValirio extends ObjetoPrecioso 
{

	public AceroValirio()
	{}
	
	
	@Override
	public void aceptar(Visitor v)
    {
		// TODO Auto-generated method stub
        v.visitarAceroValirio(this);
	}

}
