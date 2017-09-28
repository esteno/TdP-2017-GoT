package enemigos;

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
			celda = celda.celdaIzquierda();
			System.out.println("pos x "+celda.getX()+" y "+celda.getY()+" xA "+xAnterior+" yA "+yAnterior);
			celda.moverEnemigoGrafica(celda.getX(),celda.getY(),xAnterior,yAnterior);
			
		}
		else {
			destruir();
		}
	}
	
	public void destruir() {
		System.out.println("destruir");
	}

}
