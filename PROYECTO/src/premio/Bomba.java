package premio;

import java.util.List;

import colisiones.Visitor;
import defensa.Defensa;

public class Bomba extends ObjetoPrecioso {

	public Bomba() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aceptar(Visitor v) 
	{
		// TODO Auto-generated method stub
		v.visitarBomba(this);
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}


}
