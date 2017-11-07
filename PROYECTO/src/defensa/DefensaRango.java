package defensa;

/**
 * Clase que modela el comportamiento de una defensa de rango.
 * @author Comision 15
 *
 */
public abstract class DefensaRango extends Personaje {
	
	
	public void atacar() {
		//Cuando la defensa de rango ataca crea un disparo en su posicion actual
		if(proximoAtaque == 0) {
			celda.generarDisparo();
			proximoAtaque = velocidadAtaque;
		}
		//Si no decrementa el contador de proximo ataque.
		else {
			proximoAtaque--;
		}
	}

}
