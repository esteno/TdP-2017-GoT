package ObjetoDeMapa;

import objetos.GameObjectGrafico;

public abstract class ObjetoDeMapa {
	
	protected GameObjectGrafico grafico;
	protected double multiplicadorVelocidad;
	
	// Objetos que colocamos en el mapa
	public double getMultiVelocidad() {
		return multiplicadorVelocidad;
	}
	
	public GameObjectGrafico getGrafico() {
		return grafico;
	}
	
	

}
