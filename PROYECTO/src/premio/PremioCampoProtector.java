package premio;

import javax.swing.JLabel;

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
			juego.eliminarDefensa(celda.getX(), celda.getY());
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
		System.out.println("voy a eliminar el escudito");
		juego.eliminarLabelPremio(l);

		System.out.println("elimine el escudito");
	}

}
