package defensa;

/**
 * Clase que modela el comportamiento de una defensa de rango.
 * @author Comision 15
 *
 */
public abstract class DefensaRango extends Defensa {
	
	
	public void atacar() {
		//Cuando la defensa de rango ataca crea un disparo en su posicion actual
		if(proximoAtaque == 0) {
			celda.generarDisparo();
			proximoAtaque = velocidadAtaque;
		}
		else {
			proximoAtaque--;
		}
	}

}
