package logica;

import enemigos.*;

public class FabricaDeOleadas{
	
	private Juego juego;
	private int alto;
	
	public FabricaDeOleadas(Juego juego, int alto) {
		this.juego = juego;
		this.alto = alto;
	}

	
	public void generarEnemigo() {
		Enemigo enemigo = new EnemigoRojo();
		int rand = (int) Math.floor(Math.random() * (alto - 1));
		juego.agregarEnemigo(enemigo, rand);
		System.out.println("generador "+rand);
	}
	

}
