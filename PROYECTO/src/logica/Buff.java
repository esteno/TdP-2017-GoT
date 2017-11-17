package logica;

import defensa.Defensa;

public class Buff implements Temporal {

	
	Timer timer;
	Defensa def;
	public Buff(Defensa d) {
		
		def=d;
		timer  = new Timer(this, 10000);	
	}
	
	@Override
	public void accionarPorTiempo() {

		def.setAtaque(def.getAtaque()*2);
	}
	
}
