package premio;


import logica.FabricaDeDefensa;
import logica.Timer;

public class PremioMina{

	Timer t;
	private FabricaDeDefensa f;
	private static int c=0;
	
	public PremioMina() {	
		
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
