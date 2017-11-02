package premio;

import java.util.List;

import colisiones.Visitor;
import defensa.Defensa;

public abstract class ObjetoPrecioso extends Premio
{

	public ObjetoPrecioso() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public abstract void accionar(List<Defensa> list);
	
}
