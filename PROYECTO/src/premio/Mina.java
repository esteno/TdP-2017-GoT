package premio;

import colisiones.Visitor;

public class Mina extends ObjetoPrecioso {

	public Mina() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aceptar(Visitor v) 
	{
		// TODO Auto-generated method stub
		v.visitarMina(this);
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

}
