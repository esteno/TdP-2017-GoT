package defensa;

import premio.PremioCampoProtector;

public class CampoProtector extends Defensa {
	
	private Defensa personaje;
	private PremioCampoProtector control;
	
	public CampoProtector(PremioCampoProtector ctrl, Defensa d) {
		puntosVida = 1000;
		control = ctrl;
		personaje = d;
		grafico = fabricaGrafica.construirGraficoCampoProtector();
	}
	
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