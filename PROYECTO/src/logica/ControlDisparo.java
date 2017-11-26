package logica;

import java.util.ArrayList;
import java.util.List;

import disparos.*;


public class ControlDisparo implements Runnable {
	
	private Juego juego;
	//Lista de disparos nuevos
	private List<Disparo> listaInsercion;
	//Lista de disparos actuales
	private List<Disparo> listaDisparos;
	//Lista de disparos a borrar
	private List<Disparo> listaDescarte;
	private boolean isRunning = true;
	
	public ControlDisparo(Juego juego) {
		this.juego = juego;
		listaInsercion = new ArrayList<Disparo>();
		listaDisparos = new ArrayList<Disparo>();
		listaDescarte = new ArrayList<Disparo>();
	}
	
	public void agregarDisparo(Disparo disparo) {
		listaInsercion.add(disparo);
	}
	
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(100);
				//Borra todos los disparos a descartar
				for(Disparo descarte : listaDescarte) {
					listaDisparos.remove(descarte);
				}
				listaDescarte.clear();
				//Inserta todos los disparos nuevos
				for(Disparo insertar: listaInsercion) {
					listaDisparos.add(insertar);
				}
				listaInsercion.clear();
				//Acciona todos los disparos actuales
				for(Disparo disparo : listaDisparos) {
					//Si el alcance es 0 se elimina 
					if(disparo.getAlcance() <= 0) 
						listaDescarte.add(disparo);
					else {
						disparo.avanzar();
						disparo.atacar();
					}
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
