package logica;


import java.util.ArrayList;
import java.util.List;

import enemigos.*;

public class FabricaDeOleadas implements Runnable{
	
	private Juego juego;
	private int alto;
	private List<Enemigo> listaEnemigos;
	private List<Enemigo> listaDescarte;
	private boolean isRunning = true;
	private boolean segundaOperacion = false;
	
	public FabricaDeOleadas(Juego juego, int alto) {
		this.juego = juego;
		this.alto = alto;
		listaEnemigos = new ArrayList<Enemigo>();
		listaDescarte = new ArrayList<Enemigo>();
	}

	
	public void generarEnemigo() {
		Enemigo enemigo = new EnemigoRojo();
		enemigo.setFabrica(this);
		int rand = (int) Math.floor(Math.random() * (alto - 1));
		listaEnemigos.add(enemigo);
		System.out.println("FABRICA juego.agregarEnemigo "+enemigo+" "+rand);
		juego.agregarEnemigo(enemigo, rand);
		
	}
	
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(1000);
				for(Enemigo aBorrar: listaDescarte) {
					juego.sumarPuntaje(aBorrar.getPuntaje());
					aBorrar.destruir();
					listaEnemigos.remove(aBorrar);
					
				}
				listaDescarte.clear();
				for(Enemigo e: listaEnemigos) {
					e.avanzar();
				}
				
				//System.out.println("LE "+listaEnemigos.size()+" LD "+listaDescarte.size());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void destruirEnemigo(Enemigo e) {
		listaDescarte.add(e);
	}
	

}
