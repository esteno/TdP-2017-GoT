package logica;


public class Timer implements Runnable{

	Temporal temporal; 
	private int sleep;
	
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
