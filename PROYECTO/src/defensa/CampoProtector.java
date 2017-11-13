package defensa;

import premio.PremioCampoProtector;

public class CampoProtector extends Defensa {
	
	private Personaje personaje;
	private PremioCampoProtector control;
	
	public CampoProtector(PremioCampoProtector ctrl, Personaje p) {
		puntosVida = 1000;
		control = ctrl;
		personaje = p;
		grafico = fabricaGrafica.construirGraficoCampoProtector();
	}
	
	public Personaje getPersonaje() {
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
