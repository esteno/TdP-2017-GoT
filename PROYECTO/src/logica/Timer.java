package logica;


public class Timer implements Runnable{

	Temporal temporal; 
	private int sleep;
	
	
	// Se crea un timer y cuando este termina, llama a un metodo implementado por todas las clases que usan la interfaz temporal
	public Timer(Temporal temp, int tiempo){
		temporal = temp;
		sleep = tiempo;
		new Thread(this).start();
	}

	public void run() {
		try {
			Thread.sleep(sleep);
			temporal.accionarPorTiempo();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}