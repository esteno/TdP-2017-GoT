package logica;

import java.util.ArrayList;
import java.util.List;

import defensa.Defensa;

public class ControlDeDefensa implements Runnable {
	
	private Juego juego;
	private List<Defensa> listaDefensa;
	private List<Defensa> listaDescarte;
	private boolean isRunning = true;
	
	
	public ControlDeDefensa(Juego juego) {
		this.juego = juego;
		listaDefensa = new ArrayList<Defensa>();
		listaDescarte = new ArrayList<Defensa>();
		
	}
	
	public void agregarDefensa(Defensa defensa) {
		listaDefensa.add(defensa);
	}
	
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(1000);
				
				for(Defensa descarte : listaDescarte) {
					listaDefensa.remove(descarte);
				}
				listaDescarte.clear();
				for(Defensa defensa : listaDefensa) {
					defensa.atacar();
					if(defensa.getPuntosVida() <= 0) {
						listaDescarte.add(defensa);
					}
				}
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
