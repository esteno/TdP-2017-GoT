package enemigos;

import objetos.ObjetoMovil;

public abstract class Enemigo extends ObjetoMovil implements Runnable {

	public Enemigo(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(velocidad);
				if(celda.getX() != 0) {
					int xAnterior = celda.getX();
					int yAnterior = celda.getY();
					celda = celda.celdaIzquierda();
					System.out.println("pos x "+celda.getX()+" y "+celda.getY()+" xA "+xAnterior+" yA "+yAnterior);
					celda.moverEnemigoGrafica(celda.getX(),celda.getY(),xAnterior,yAnterior);
					
				}
				else {
					isRunning = false;
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		destruir();
	}
	
	public void destruir() {
		System.out.println("destruir");
	}

}
