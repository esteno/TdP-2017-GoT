package logica;


import java.util.ArrayList;
import java.util.List;

import enemigos.*;

public class FabricaDeOleadas implements Runnable{
	
	private Juego juego;
	private int alto;
	private List<Enemigo> listaEnemigos;
	private boolean isRunning = true;
	
	public FabricaDeOleadas(Juego juego, int alto) {
		this.juego = juego;
		this.alto = alto;
		listaEnemigos = new ArrayList<Enemigo>();
	}

	
	public void generarEnemigo() {
		Enemigo enemigo = new EnemigoRojo();
		int rand = (int) Math.floor(Math.random() * (alto - 1));
		listaEnemigos.add(enemigo);
		juego.agregarEnemigo(enemigo, rand);
		System.out.println("generador "+rand);
		
	}
	
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(1000);
			for(Enemigo e: listaEnemigos) {
				e.avanzar();
			}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	

}
