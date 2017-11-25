package disparos;
import objetos.*;
import celdas.Celda;
import colisiones.Visitor;

public abstract class Disparo extends ObjetoMovil {
	
	protected int alcance;
	protected Visitor visitor;
	
	public Disparo(String path,double danio) {
		velocidad= 10;
		alcance = 30;
		fuerzaImpacto = (int) Math.floor(danio);
		grafico = fabricaGrafica.construirGraficoDisparo(path);
	}

	public abstract void avanzar();
	
	public void destruir() {
		//Para poder ser removido 
		alcance=0;
		grafico.destruir();
	}

	public int getAlcance() {
		return alcance;
	}
}