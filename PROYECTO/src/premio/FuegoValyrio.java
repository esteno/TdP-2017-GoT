package premio;

import java.util.List;

import colisiones.Visitor;
import defensa.Defensa;

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


	@Override
	public void accionar(List<Defensa> list) {
		// TODO Auto-generated method stub
		
	}


}
