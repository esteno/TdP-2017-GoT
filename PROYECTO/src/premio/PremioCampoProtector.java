package premio;

import celdas.Celda;
import defensa.*;
import logica.Juego;
import logica.Temporal;
import logica.Timer;

public class PremioCampoProtector implements Temporal	{
	
	private Juego juego;
	private Defensa personaje;
	private CampoProtector campo;
	private static int c=0;
	
	public PremioCampoProtector(Personaje personaje) {
		campo = new CampoProtector(this, personaje);
		Celda celda = personaje.getCelda();
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

	public void aumentarCampo() {
		 
		c++;
	}

	public void restarCampo() {

		c--;
	}

	public boolean hayCampos() {
		
		return c>0;
	}

}
