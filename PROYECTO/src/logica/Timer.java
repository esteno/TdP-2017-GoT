package logica;

import objetos.GameObject;

public class Timer implements Runnable{

	GameObject gObject; 
	
	public Timer(GameObject objeto){
		gObject=objeto;
	}

	public void run() {
		try {
			Thread.sleep(3000);
			gObject.accionarPorTiempo();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	}
	
}
