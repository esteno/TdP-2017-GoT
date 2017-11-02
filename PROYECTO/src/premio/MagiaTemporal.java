package premio;

import java.util.List;

import defensa.Defensa;

public abstract class MagiaTemporal extends Premio 
{
	protected Timer timer; 

	public MagiaTemporal() 
	{
		// TODO Auto-generated constructor stub
	}
	public abstract void accionar(List<Defensa> list);


}
