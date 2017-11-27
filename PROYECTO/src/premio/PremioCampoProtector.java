package premio;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

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
	private JLabel l;
	
	public PremioCampoProtector(Defensa d, Juego j, JLabel nuevo) {

		System.out.println("voy a colocar un campo protector");
		juego=j;
		campo = new CampoProtector(this, d);
		CeldaCompuesta celda = d.getCelda();
		personaje=d;
		l=nuevo;
		if (d!=null) {
			int x=celda.getX();
			int y=celda.getY();
			juego.eliminarDefensa(x,y);
			campo.setCelda(celda);
			personaje.getGrafico().getLabel().setBorder(new MatteBorder(2, 2, 2, 2, Color.BLUE));
			juego.reemplazarDefensa(campo, x, y);
			System.out.println("cambie la defensa por el campo");
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
		System.out.println("cambie el campo por la defensa");
		juego.reemplazarDefensa(personaje, celda.getX(), celda.getY());
		System.out.println("voy a eliminar el escudito");

	}

}
