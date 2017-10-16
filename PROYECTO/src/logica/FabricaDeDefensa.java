package logica;

import defensa.*;

public class FabricaDeDefensa 
{
	
	private static FabricaDeDefensa instancia = null;
	private Defensa defensaCreada = null;
	
	private FabricaDeDefensa() 
	{
		
	}
	
	public static FabricaDeDefensa getInstancia() {
		if(instancia == null) 
			instancia = new FabricaDeDefensa();
		return instancia;
	}
	
	public void construirJorgito() {
		defensaCreada = new Jorgito();
	}
	
	public Defensa getDefensa() {
		return defensaCreada;
	}
	
	public void reset() {
		defensaCreada = null;
	}
}
