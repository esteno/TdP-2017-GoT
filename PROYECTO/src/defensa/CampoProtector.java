package defensa;

import premio.PremioCampoProtector;

public class CampoProtector extends Defensa {
	
	//Defensa que se encuentra protegida por el escudo
	private Defensa personaje;
	private PremioCampoProtector control;
	
	// Crea un escudo con una vida de terminada, un control y un personaje determinado al cual proteger
	public CampoProtector(PremioCampoProtector ctrl, Defensa d) {
		puntosVida = 20;
		control = ctrl;
		personaje = d;
	}
	
	// Retorna el personaje que protege
	public Defensa getPersonaje() {
		return personaje;
	}
	
	@Override
	public void atacar() {
		personaje.atacar();
	}
	
	public void destruir() {
		control.destruir();
	}
}