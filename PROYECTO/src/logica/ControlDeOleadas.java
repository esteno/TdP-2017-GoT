package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import enemigos.CampoProtectorEnemigo;
import enemigos.Enemigo;
import objetos.ObjetoMovil;

public class ControlDeOleadas implements Runnable {
	
	private Juego juego;
	//Alto de una columna del juego
	private int alto;
	//Lista de enemigos nuevos
	private List<Enemigo> listaInsercion;
	//Lista de enemigos actuales
	private List<Enemigo> listaEnemigos;
	private List<Enemigo> listaInmediata;
	
	//Lista de enemigos a eliminar
	private List<Enemigo> listaDescarte;
	//Variable de control del hilo
	private boolean isRunning = true;
	//Numero de oleadas restantes
	private int cantOleadas = 3;
	//Variable de control de insercion.
	private int aInsertar;
	
	public ControlDeOleadas(Juego juego, int a) {
		this.juego = juego;
		alto = a;
		listaInsercion = new ArrayList<Enemigo>();
		listaEnemigos = new ArrayList<Enemigo>();
		listaDescarte = new ArrayList<Enemigo>();
		listaInmediata = new ArrayList<Enemigo>();
	}
	
	//Oleada Nueva
	public void setOleada(List<Enemigo> lista) {
		listaInsercion = lista;
		aInsertar = 0;
	}
	
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(100);
				
				//Se inserta de a uno por vez si es posible por cada sleep
				if(aInsertar < listaInsercion.size()) {
					Enemigo enemigo = listaInsercion.get(aInsertar);
					//Posicion de la columna donde se va a insertar
					int rand = (int) Math.floor(Math.random() * (alto - 1));
					//Devuelve si el enemigo fue agregado
					Random aleatorio= new Random();
					int r= aleatorio.nextInt(100);
					boolean agregue = juego.agregarEnemigo(enemigo, juego.getAncho(), rand);
					if(agregue) {
						listaEnemigos.add(enemigo);
						aInsertar++;
						if (r<=100) {
							Enemigo p= new CampoProtectorEnemigo (enemigo, juego);
							juego.reemplazarEnemigo(p, juego.getAncho(), rand);
						}
					}
				}
				
				for (Enemigo en: listaInmediata)
					listaEnemigos.add(en);
				listaInmediata.clear();
				
				//Enemigos a borrar
				for(Enemigo descarte : listaDescarte) {
					listaEnemigos.remove(descarte);
					juego.sumarPuntaje(descarte.getPuntos());
					juego.sumarOro(descarte.getOro());
					juego.crearPremio(descarte.getCelda().getX(),descarte.getCelda().getY());
				}
				listaDescarte.clear();
				
				//Enemigos a mover
				for(Enemigo enemigo : listaEnemigos) {
					if(enemigo.getPuntosVida() <= 0) 
						listaDescarte.add(enemigo);
					else {
						enemigo.atacar();
						enemigo.avanzar();
					}
				}
				
				//Si no hay mas enemigos y aun hay oleadas, se crea una nueva
				if(listaEnemigos.size() == 0 && cantOleadas != 0) {
					Thread.sleep(4000);
					juego.sigOleada();
				}
				//Si no hay mas oleadas se cambia de nivel
				if(cantOleadas == 0) {
					juego.sigNivel();
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void eliminarEnemigo(Enemigo c) {
		
		listaDescarte.add(c);
	}
	
	public void insertarEnemigo(Enemigo c) {
		
		listaInmediata.add(c);
	}
}