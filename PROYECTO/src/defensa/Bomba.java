package defensa;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import celdas.Celda;
import colisiones.VisitorBomba;
import logica.Juego;
import logica.Temporal;
import logica.Timer;
import objetos.ObjetoMovil;
import mapa.Mapa;

public class Bomba implements Temporal{

	Timer timer;
	public int fuerzaImpacto=90;
	private int x;
	private int y;
	private Celda celda;
	private JLabel label;
	private Juego j;
	
	public Bomba(int a, int b,Mapa p, Juego juego, JLabel nuevo){
		x=a;
		y=b;
		celda= new Celda(p,x,y);
		label=nuevo;
		j=juego;
		timer  = new Timer(this, 3000);
	}
	
	public void accionarPorTiempo() {
		List<ObjetoMovil> l=new ArrayList<ObjetoMovil>();
		List<Defensa> d=new ArrayList<Defensa>();
		l= celda.adyEnemigos();
		VisitorBomba v = new VisitorBomba(this);
		for (ObjetoMovil o:l)
			o.aceptar(v);	
		d= celda.adyDefensa();
		for (Defensa def:d)
			def.aceptar(v);
		j.eliminarBomba(label);
	}

	public int getFuerzaImpacto(){
		return fuerzaImpacto;
	}
}
