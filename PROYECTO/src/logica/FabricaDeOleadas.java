package logica;


import enemigos.*;

public class FabricaDeOleadas{
	
	
	public FabricaDeOleadas() {
	}

	
	public Enemigo generarEnemigo() {
		return new EnemigoRojo();
	}
	

}
