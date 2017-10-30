package logica;

import java.util.ArrayList;
import java.util.List;

import enemigos.Enemigo;
import objetos.ObjetoMovil;

public class ControlDeOleadas implements Runnable {
	
	private Juego juego;
	private int alto;
	private List<Enemigo> listaInsercion;
	private List<Enemigo> listaEnemigos;
	private List<Enemigo> listaDescarte;
	private boolean isRunning = true;
	
	public ControlDeOleadas(Juego juego, int a) {
		this.juego = juego;
		alto = a;
		listaInsercion = new ArrayList<Enemigo>();
		listaEnemigos = new ArrayList<Enemigo>();
		listaDescarte = new ArrayList<Enemigo>();
		
	}
	
	public void setOleada(List<Enemigo> lista) {
		listaInsercion = lista;
	}
	
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(100);
				
				if(!listaInsercion.isEmpty()) {
					Enemigo enemigo = listaInsercion.get(0);
					int rand = (int) Math.floor(Math.random() * (alto - 1));
					juego.agregarObjetoMovil(enemigo, juego.getAncho(), rand);
					listaEnemigos.add(enemigo);
					listaInsercion.remove(0);
				}
				
				for(Enemigo descarte : listaDescarte) {
					listaEnemigos.remove(descarte);
					juego.sumarPuntaje(descarte.getPuntos());
				}
				listaDescarte.clear();
				for(Enemigo enemigo : listaEnemigos) {
					if(enemigo.getPuntosVida() <= 0) {
						listaDescarte.add(enemigo);
					}
					else {
						enemigo.atacar();
						enemigo.avanzar();
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
