package enemigos;

import celdas.Celda;
import objetos.ObjetoMovil;

public abstract class Enemigo extends ObjetoMovil {

	public Enemigo(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	
	public void avanzar() {
		if(celda.getX() != 0) {
			int xAnterior = celda.getX();
			int yAnterior = celda.getY();
			Celda celdaNueva = celda.celdaIzquierda();
			System.out.println(celdaNueva.hayEnemigo());
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
		System.out.println("destruir");
	}

}
