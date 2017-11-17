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
	
	//PERSONAJES

	
	public void construirYgritte()
	{
		defensaCreada = new Ygritte();
	}
	
	public void construirMountain()
	{
		defensaCreada = new Mountain();
	}
	
	public void construirDragon()
	{
		defensaCreada = new Dragon();
	}
	
	public void construirInmaculado()
	{
		defensaCreada = new Inmaculado();
	}
	
	public void construirGendry()
	{
		defensaCreada = new Gendry();
	}
	
	
	public void construirBronn()
	{
		defensaCreada = new Bronn();
	}
	
	public Defensa getDefensa() 
	{
		return defensaCreada;
	}
	
	public void reset() {
		defensaCreada = null;
	}

	public void construirBarricada() {
		// TODO Auto-generated method stub
		
	}

}
