package logica;

import defensa.*;

public class FabricaDeDefensa 
{
	//Instancia de la fabrica para el singleton
	private static FabricaDeDefensa instancia = null;
	
	//Ultimo producto creado
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
	
	public void construirBomba() {

		defensaCreada=new Bomba();	
	}
	
	public void construirMina() {

		defensaCreada=new Mina();
	}
	
	public Defensa getDefensa() {
		return defensaCreada;
	}
	
	public void reset() {
		defensaCreada = null;
	}
	
}
