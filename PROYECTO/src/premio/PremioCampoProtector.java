package premio;

import javax.swing.JLabel;

import celdas.Celda;
import defensa.*;
import logica.Juego;
import logica.Temporal;
import logica.Timer;

public class PremioCampoProtector implements Temporal	{
	
	private Juego juego;
	private Defensa personaje;
	private CampoProtector campo;
	private JLabel l;
	
	public PremioCampoProtector(Defensa d, Juego j, JLabel label) {
		juego=j;
		campo = new CampoProtector(this, d);
		Celda celda = d.getCelda();
		System.out.println(d!=null);
		System.out.println(celda!=null);
		personaje=d;
		l=label;
		if (d!=null) {
			int x=celda.getX();
			int y=celda.getY();
			juego.eliminarDefensa(x,y);
			campo.setCelda(celda);
			juego.agregarDefensa(campo, celda.getX(), celda.getY());
			System.out.println("cambie la defensa por el campo");
			new Timer(this, 5000);
		}
	}
	
	public void accionarPorTiempo() {
		destruir();
	}
	
	public void destruir() {
		Celda celda = campo.getCelda();
		System.out.println("cambie el campo por la defensa");
		juego.eliminarDefensa(celda.getX(), celda.getY());
		juego.agregarDefensa(personaje, celda.getX(), celda.getY());
		juego.eliminarLabelPremio(l);
	}

}
