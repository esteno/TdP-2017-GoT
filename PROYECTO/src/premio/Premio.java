package premio;

import colisiones.VisitorPremio;
import objetos.GameObject;

public abstract class Premio extends GameObject implements Runnable 
{
	
    protected VisitorPremio miVisitor;

	public Premio() {
		// TODO Auto-generated constructor stub
	}

	
	public void run() {}
	


	@Override
	public void atacar() 
	{
		// TODO Auto-generated method stub
	}
	
}
