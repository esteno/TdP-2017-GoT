package premio;

import logica.FabricaDeDefensa;

public class PremioMina{

	private FabricaDeDefensa f;
	private static int c=0;
	
	public PremioMina(FabricaDeDefensa fab){
		
		f=fab;		
	}

	public void aumentarMinas(){
		
		c++;
	}
	
	public boolean hayMinas() {
		
		return c>0;
	}
	
	public void agregarMina() {
		
		if (c>0)
			f.construirMina();
	}
	
}
