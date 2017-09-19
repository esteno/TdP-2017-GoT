package logica;

import enemigos.*;

public class FabricaDeOleadas implements Runnable {
	
	private Juego juego;
	private int ancho;
	private Boolean isRunning;
	
	public FabricaDeOleadas(Juego juego, int ancho) {
		this.juego = juego;
		this.ancho = ancho;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void generarEnemigo() {
		Enemigo enemigo = new EnemigoRojo();
		int rand = (int) Math.floor(Math.random() * (ancho - 1));
		juego.agregarEnemigo(enemigo, rand);
	}
	

}
