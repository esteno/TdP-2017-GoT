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
	private int cantOleadas = 3;
	private int aInsertar;
	
	public ControlDeOleadas(Juego juego, int a) {
		this.juego = juego;
		alto = a;
		listaInsercion = new ArrayList<Enemigo>();
		listaEnemigos = new ArrayList<Enemigo>();
		listaDescarte = new ArrayList<Enemigo>();
		
	}
	
	public void setOleada(List<Enemigo> lista) {
		listaInsercion = lista;
		aInsertar = 0;
	}
	
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(100);
				
				if(aInsertar < listaInsercion.size()) {
					System.out.println("aInsertar "+aInsertar);
					Enemigo enemigo = listaInsercion.get(aInsertar);
					int rand = (int) Math.floor(Math.random() * (alto - 1));
					Boolean agregue = juego.agregarObjetoMovil(enemigo, juego.getAncho(), rand);
					if(agregue) {
						listaEnemigos.add(enemigo);
						
						aInsertar++;
					}
					System.out.println("agregue "+agregue);
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
				if(listaEnemigos.size() == 0 && cantOleadas != 0) {
					System.out.println("nueva oleada");
					Thread.sleep(2000);
					aInsertar = 0;
					cantOleadas--;
				}
				if(cantOleadas == 0) {
					juego.sigNivel();
				}
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
