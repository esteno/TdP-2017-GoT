package enemigos;

import objetos.ObjetoMovil;

public abstract class Enemigo extends ObjetoMovil implements Runnable {

	public Enemigo(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	
	public void run() {}

}
