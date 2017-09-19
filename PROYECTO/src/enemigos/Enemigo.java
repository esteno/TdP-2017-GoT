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
				Thread.sleep(2000);
				if(celda.getY() != 0) {
					celda = celda.celdaArriba();
					celda.moverMovilArriba(this);
					
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
