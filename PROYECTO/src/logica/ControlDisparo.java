package logica;

import java.util.ArrayList;
import java.util.List;

import disparos.Disparo;


public class ControlDisparo implements Runnable {
	
	private Juego juego;
	private List<Disparo> listaInsercion;
	private List<Disparo> listaDisparos;
	private List<Disparo> listaDescarte;
	private boolean isRunning = true;
	
	public ControlDisparo(Juego juego) {
		this.juego = juego;
		listaInsercion = new ArrayList<Disparo>();
		listaDisparos = new ArrayList<Disparo>();
		listaDescarte = new ArrayList<Disparo>();
		
	}
	
	public void agregarDisparo(int x, int y) {
		Disparo disparoNuevo = new Disparo();
		listaInsercion.add(disparoNuevo);
		juego.agregarObjetoMovil(disparoNuevo, x, y);
	}
	
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(1000);
				
				for(Disparo descarte : listaDescarte) {
					listaDisparos.remove(descarte);
				}
				listaDescarte.clear();
				for(Disparo insertar: listaInsercion) {
					listaDisparos.add(insertar);
				}
				listaInsercion.clear();
				for(Disparo disparo : listaDisparos) 
				{
					if(disparo.getAlcance() <= 0) 
						listaDescarte.add(disparo);
					else
						disparo.avanzar();
				}
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
