package premio;

import defensa.Defensa;

public abstract class MagiaTemporal extends Premio 
{
	protected Timer timer; 

	public MagiaTemporal() 
	{
		// TODO Auto-generated constructor stub
	}
	public abstract void accionar(Defensa d); 

}
