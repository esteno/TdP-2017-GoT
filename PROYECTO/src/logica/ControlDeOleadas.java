package logica;

import java.util.ArrayList;
import java.util.List;

import enemigos.Enemigo;
import objetos.ObjetoMovil;

public class ControlDeOleadas implements Runnable {
	
	private Juego juego;
	private FabricaDeOleadas fabrica;
	private int alto;
	private List<Enemigo> listaInsercion;
	private List<Enemigo> listaEnemigos;
	private List<Enemigo> listaDescarte;
	private boolean isRunning = true;
	
	private int contador = 0;
	private int primeraOleada = 1000;
	
	public ControlDeOleadas(Juego juego, FabricaDeOleadas fabrica, int a) {
		this.juego = juego;
		this.fabrica = fabrica;
		alto = a;
		listaInsercion = new ArrayList<Enemigo>();
		listaEnemigos = new ArrayList<Enemigo>();
		listaDescarte = new ArrayList<Enemigo>();
		
	}
	
	public void generarEnemigo() {
			}
	
	public void run() {
		while(isRunning) {
			try {
				contador += 100;
				Thread.sleep(contador);
				if(contador == primeraOleada ) {
					listaInsercion = fabrica.generarPrimeraOleada();
				}
				if(!listaInsercion.isEmpty()) {
					Enemigo enemigo = listaInsercion.get(0);
					int rand = (int) Math.floor(Math.random() * (alto - 1));
					juego.agregarEnemigo(enemigo, juego.getAncho(), rand);
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
