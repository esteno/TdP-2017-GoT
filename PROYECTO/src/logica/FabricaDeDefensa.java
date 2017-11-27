package logica;

import defensa.*;
import obstaculo.*;

public class FabricaDeDefensa {
	//Instancia de la fabrica para el singleton
	private static FabricaDeDefensa instancia = null;
	
	//Ultimo producto creado
	private Defensa defensaCreada = null;
	
	private FabricaDeDefensa() {
	}
	
	public static FabricaDeDefensa getInstancia() {
		if(instancia == null) 
			instancia = new FabricaDeDefensa();
		return instancia;
	}
	
	// ----------------PERSONAJES
	public void construirYgritte(){
		defensaCreada = new Ygritte();
	}
	
	public void construirMountain(){
		defensaCreada = new Mountain();
	}
	
	public void construirDragon(){
		defensaCreada = new Dragon();
	}
	
	public void construirInmaculado(){
		defensaCreada = new Inmaculado();
	}
	
	public void construirGendry(){
		defensaCreada = new Gendry();
	}
	
	public void construirBronn(){
		defensaCreada = new Bronn();
	}
	
	// ---------- OBSTACULOS
	public void construirBarricada() {
		defensaCreada = new Barricada();
	}

	public void construirMuro(){
		defensaCreada = new Muro();
	}
	
	public void construirTrinchera(){
		defensaCreada = new Trinchera();
	}
	
	public void construirRoca(){
		defensaCreada = new Roca();
	}
	
	
	
	public void construirFuegoValyrio() {
		// TODO Auto-generated method stub
		defensaCreada =  new FuegoValyrio();
	}
	
	// -------------
	public Defensa getDefensa() {
		return defensaCreada;
	}
	
	
	public void reset() {
		defensaCreada = null;
	}


}
