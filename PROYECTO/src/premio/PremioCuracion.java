package premio;

import logica.Juego;

public class PremioCuracion 
{
	private static int c=0;
	public PremioCuracion(Juego juego) {
		juego.curar();
	}

	public void aumentarCuracion() {
		c++;
	}

	public void restarCuracion() {
		c--;
	}

	public boolean hayCuracion() {
		return c>0;
	}

}
