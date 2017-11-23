package defensa;

import celdas.Celda;
import enemigos.Enemigo;
import objetos.ObjetoMovil;

/**
 * Clase que modela el comportamiento de una defensa cuerpo a cuerpo.
 * @author Comision 15
 */
public abstract class DefensaCuerpo extends Personaje {
	
	public void atacar() {
		// Pide la siguiente Celda, y a esa celda le solicita el objeto movil si es que tiene.
		Celda celdaDerecha = this.celda.celdaDerecha();
		Enemigo enemigo = celdaDerecha.getEnemigo();
		
		// si hay objeto movil, lo visita.
		if(enemigo != null)
		{
			enemigo.aceptar(visitor);
		}
	}
}