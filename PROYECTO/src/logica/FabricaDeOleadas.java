package logica;


import java.util.ArrayList;
import java.util.List;

import enemigos.*;
import objetos.ObjetoMovil;

public class FabricaDeOleadas{
	
	
	public FabricaDeOleadas() {
	}

	
	public List<Enemigo> generarPrimeraOleada() {
		
		List<Enemigo> toReturn = new ArrayList<Enemigo>();
		for(int i = 0; i < 5 ; i++)
			toReturn.add(new EnemigoRojo());
		return toReturn;
	}
	

}
