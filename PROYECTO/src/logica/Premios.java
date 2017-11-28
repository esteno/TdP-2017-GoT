package logica;

import java.util.Random;

import defensa.Defensa;
import gui.ConsolaMensajes;

public class Premios {
	
	private Juego juego;
	
	public Premios(Juego j) {
		juego = j;
	}
	
	// Crea un premio en base a un numero aleatorio
	public void crearPremio(int x, int y) {
		int chance = new Random().nextInt(99);
		switch(chance) { 
			case 0: 
				juego.agregarPremioBomba(x, y);
				ConsolaMensajes.mostrarMensaje("Ha aparecido una bomba!");
				break;
			case 1:
				juego.agregarPremioBarricada(x, y);
				ConsolaMensajes.mostrarMensaje("Ha aparecido una barricada!");
				break;
			case 2:
				juego.agregarPremioOro(x, y);
				ConsolaMensajes.mostrarMensaje("Ha aparecido una pila de oro!");
				break;
			case 3:
				juego.agregarPremioCuracion(x, y);
				ConsolaMensajes.mostrarMensaje("Ha aparecido una curacion instantena!");
				break;
			case 4:
				juego.agregarPremioDanioDoble(x, y);
				ConsolaMensajes.mostrarMensaje("Ha aparecido un daño doble!");
				break;
			case 5:
				juego.agregarPremioCampoProtector(x, y);
				ConsolaMensajes.mostrarMensaje("Ha aparecido un Campo Protector!");
		}
	}
}
