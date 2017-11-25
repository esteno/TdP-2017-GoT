package premio;

import logica.Juego;
import logica.Temporal;
import logica.Timer;
import estadoMultiplicador.*;

public class PremioDanioDoble implements Temporal {
	
	Juego juego;
	
	public PremioDanioDoble(Juego j) {
		juego = j;
		System.out.println("PremioDanioDoble");
		juego.modificarDefensa(new EstadoDefensaDanioDoble());
		new Timer(this, 10000);	
	}
	
	@Override
	public void accionarPorTiempo() {
		juego.modificarDefensa(new EstadoDefensaDefecto());
	}
	
}
