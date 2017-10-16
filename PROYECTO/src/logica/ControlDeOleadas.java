package logica;

import java.util.ArrayList;
import java.util.List;

import enemigos.Enemigo;

public class ControlDeOleadas implements Runnable {
	
	private Juego juego;
	private FabricaDeOleadas fabrica;
	private int alto;
	private List<Enemigo> listaEnemigos;
	private List<Enemigo> listaDescarte;
	private boolean isRunning = true;
	
	public ControlDeOleadas(Juego juego, FabricaDeOleadas fabrica, int a) {
		juego = juego;
		fabrica = fabrica;
		alto = a;
		listaEnemigos = new ArrayList<Enemigo>();
		listaDescarte = new ArrayList<Enemigo>();
		
	}
	
	public void generarEnemigo() {
		Enemigo enemigo = fabrica.generarEnemigo();
		int rand = (int) Math.floor(Math.random() * (alto - 1));
		juego.agregarEnemigo(enemigo, rand);
	}
	
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(1000);
				
				for(Enemigo descarte : listaDescarte) {
					listaEnemigos.remove(descarte);
					juego.sumarPuntaje(descarte.getPuntaje());
					descarte.destruir();
				}
				listaDescarte.clear();
				for(Enemigo enemigo : listaEnemigos) {
					enemigo.avanzar();
					if(enemigo.getPuntosVida() <= 0) {
						listaDescarte.add(enemigo);
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
