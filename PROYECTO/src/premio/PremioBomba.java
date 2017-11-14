package premio;

import logica.FabricaDeDefensa;

public class PremioBomba{
	
	private FabricaDeDefensa f;
	private static int c=0;
	
	public PremioBomba(FabricaDeDefensa fab){
		
		f=fab;
	}

	public void aumentarBombas(){
		
		c++;
	}
	
	public boolean hayBombas() {
		
		return c>0;
	}
	
	public void agregarBomba() {
		
		if (c>0)
			f.construirBomba();
		c--;
	}
	
}
