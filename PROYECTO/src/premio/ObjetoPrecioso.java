package premio;

import java.util.List;

import colisiones.Visitor;
import defensa.Defensa;

public abstract class ObjetoPrecioso extends Premio
{
	
	protected int puntos_extra;

	public ObjetoPrecioso() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public int plus()
	{
		return puntos_extra;
	}
}
