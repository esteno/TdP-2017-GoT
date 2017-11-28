package disparos;

import objetos.*;
import colisiones.Visitor;

public abstract class Disparo extends ObjetoMovil {
	
	protected int alcance;
	protected Visitor visitor;
	
	// Genera un disparo con una velocidad, alcance, daño y grafico determinados
	public Disparo(GameObjectGrafico graf,double danio) {
		velocidad= 10;
		alcance = 30;
		fuerzaImpacto = (int) Math.floor(danio);
		grafico = graf;
	}

	public abstract void avanzar();
	
	
	//Destruye el disparo
	public void destruir() {
		alcance=0;
		grafico.destruir();
	}

	// Retorna el alcance del proyectil
	public int getAlcance() {
		return alcance;
	}
}