package premio;

import java.awt.Color;


import javax.swing.border.MatteBorder;


import celdas.CeldaCompuesta;
import defensa.*;
import logica.Juego;
import logica.Temporal;
import logica.Timer;

public class PremioCampoProtector implements Temporal	{
	
	private Juego juego;
	private Defensa personaje;
	private CampoProtector campo;
	
	public PremioCampoProtector(Defensa d, Juego j) {

		juego=j;
		campo = new CampoProtector(this, d);
		CeldaCompuesta celda = d.getCelda();
		personaje=d;
		if (d!=null) {
			int x=celda.getX();
			int y=celda.getY();
			juego.eliminarDefensa(x,y);
			campo.setCelda(celda);
			personaje.getGrafico().getLabel().setBorder(new MatteBorder(2, 2, 2, 2, Color.BLUE));
			juego.reemplazarDefensa(campo, x, y);

			new Timer(this, 5000);
		}
	}
	
	public void accionarPorTiempo() {
		destruir();
	}
	
	public void destruir() {
		CeldaCompuesta celda = campo.getCelda();
		personaje.getGrafico().getLabel().setBorder(null);
		celda.destruirDefensa();
		juego.reemplazarDefensa(personaje, celda.getX(), celda.getY());

	}

}
