package logica;

import gui.Gui;

public class LogicaGrafica {
	
	private Gui gui;
	
	public LogicaGrafica(Gui gui) {
		this.gui = gui;
	}
	
	public void moverIzquierdaEnemigo(int x, int y, int xAnterior, int yAnterior) {
		gui.moverEnemigoGrafico(xAnterior, yAnterior, x, y);
	}

}
