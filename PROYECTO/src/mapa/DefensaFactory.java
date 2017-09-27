package mapa;

import defensa.*;

public class DefensaFactory 
{
	
	public DefensaFactory() 
	{}
	
	public Defensa construirDefensa() {
		return new Jorgito();
	}

}
