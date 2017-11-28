package premio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import colisiones.VisitorBomba;
import defensa.Defensa;
import logica.Juego;
import logica.Temporal;
import logica.Timer;
import objetos.ObjetoMovil;
import mapa.Mapa;

public class Bomba implements Temporal{

	private int x;
	private int y;
	private Mapa mapa;
	private JLabel label;
	private Juego j;
	
	public Bomba(int a, int b,Mapa mapa, Juego juego, JLabel nuevo){
		x=a;
		y=b;
		label=nuevo;
		this.mapa = mapa;
		j=juego;
		new Timer(this, 3000);
	}
	
	public void accionarPorTiempo() {
		List<ObjetoMovil> listaEnemigos = new ArrayList<ObjetoMovil>();
		List<Defensa> listaDefensa = new ArrayList<Defensa>();
		
		listaEnemigos = mapa.adyEnemigos(x, y);
		VisitorBomba visitor = new VisitorBomba(this);
		for (ObjetoMovil o:listaEnemigos)
			o.aceptar(visitor);	
		
		listaDefensa = mapa .adyDefensa(x, y);
		for (Defensa def: listaDefensa)
			def.aceptar(visitor);
		j.eliminarLabelPremio(label);
	}

}
