package premio;

import celdas.Celda;
import celdas.CeldaCompuesta;
import defensa.*;
import logica.Juego;
import logica.Temporal;
import logica.Timer;

public class PremioCampoProtector implements Temporal	{
	
	private Juego juego;
	private Defensa personaje;
	private CampoProtector campo;
	
	public PremioCampoProtector(Defensa d) {
		campo = new CampoProtector(this, d);
		CeldaCompuesta celda = d.getCelda();
		campo.setCelda(celda);
		juego.eliminarDefensa(celda.getX(), celda.getY());
		juego.agregarDefensa(campo, celda.getX(), celda.getY());
		new Timer(this, 5000);
	}
	
	public void accionarPorTiempo() {
		destruir();
	}
	
	public void destruir() {
		Celda celda = campo.getCelda();
		juego.eliminarDefensa(celda.getX(), celda.getY());
		juego.agregarDefensa(personaje, celda.getX(), celda.getY());
	}

}
