package premio;

import logica.Juego;
import logica.Temporal;
import logica.Timer;
import estadoMultiplicador.*;

public class Buff implements Temporal {

	private EstadoDefensaDanioDoble danio;
	private EstadoDefensaDefecto defecto;
	private Juego juego;
	
	public Buff(Juego j) {
		
		juego=j;
		danio=new EstadoDefensaDanioDoble();
		j.modificarDefensa(danio);
		new Timer(this, 10000);	
	}
	
	@Override
	public void accionarPorTiempo() {

		defecto=new EstadoDefensaDefecto();
		juego.modificarDefensa(defecto);
	}
	
}
