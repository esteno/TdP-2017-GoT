package enemigos;

import celdas.Celda;
import logica.FabricaDeOleadas;
import objetos.ObjetoMovil;

public abstract class Enemigo extends ObjetoMovil {
	
	private FabricaDeOleadas fabrica;

	public Enemigo(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	
	public void setFabrica(FabricaDeOleadas f) {
		fabrica = f;
	}
	
	public void avanzar() {
		if(celda.getX() != 0) {
			int xAnterior = celda.getX();
			int yAnterior = celda.getY();
			Celda celdaNueva = celda.celdaIzquierda();
			if(!celdaNueva.hayEnemigo()) {
				
				celda = celdaNueva;
				celda.moverEnemigo(celda.getX(), celda.getY(), xAnterior, yAnterior);
			} 
			
		}
		else {
			destruir();
		}
	}
	
	public void destruir() {
		fabrica.destruirEnemigo(this);
		celda.destruirEnemigo();
		
	}
	
	public int getPuntaje() {
		return puntaje;
	}

}
