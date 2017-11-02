package premio;

import colisiones.Visitor;

public class Barricada extends ObjetoPrecioso {

	public Barricada() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aceptar(Visitor v) 
	{
		// TODO Auto-generated method stub
		v.visitarBarricada(this);
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

}
