package defensa;

import java.util.ArrayList;
import java.util.List;

import celdas.Celda;
import colisiones.VisitorBomba;
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
	
	public Bomba(int a, int b,Mapa p){
		x=a;
		y=b;
		celda= new Celda(p,x,y);
		timer  = new Timer(this, 3000);
	}
	
	public void accionarPorTiempo() {
		List<ObjetoMovil> l=new ArrayList<ObjetoMovil>();
		List<Defensa> d=new ArrayList<Defensa>();
		l=celda.adyEnemigos();
		VisitorBomba v = new VisitorBomba(this);
		for (ObjetoMovil o:l)
			o.aceptar(v);	
		d= celda.adyDefensa();
		for (Defensa def:d)
			def.aceptar(v);
	}

	public int getFuerzaImpacto(){
		return fuerzaImpacto;
	}
}
