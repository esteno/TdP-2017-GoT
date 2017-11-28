package logica;

import java.util.Random;

import defensa.Defensa;

public class Premios {
	
	private Juego juego;
	
	public Premios(Juego j) {
		juego = j;
	}
	
	public void crearPremio(int x, int y) {
		int chance = new Random().nextInt(99);
		switch(chance) { 
			case 0: 
				juego.agregarPremioBomba(x, y);
				break;
			case 1:
				juego.agregarPremioBarricada(x, y);
				break;
			case 2:
				juego.agregarPremioOro(x, y);
				break;
			case 3:
				juego.agregarPremioCuracion(x, y);
				break;
			case 4:
				juego.agregarPremioDanioDoble(x, y);
				break;
			case 5:
				juego.agregarPremioCampoProtector(x, y);
		}
	}
}
