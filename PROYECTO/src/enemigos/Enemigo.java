package enemigos;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorEnemigo;
import logica.FabricaDeOleadas;
import objetos.ObjetoMovil;

public abstract class Enemigo extends ObjetoMovil {
	
	private FabricaDeOleadas fabrica;
	protected VisitorEnemigo visitor;

	
	public void setFabrica(FabricaDeOleadas f) 
	{
		fabrica = f;
		
	}
	
	public void avanzar() {
		if(celda.getX() != 0) {
			int xAnterior = celda.getX();
			int yAnterior = celda.getY();
			Celda celdaNueva = celda.celdaIzquierda();
			if(!celdaNueva.hayEnemigo()) {
				
				celda = celdaNueva;
				celda.moverEnemigo(xAnterior, yAnterior);
			} 
			
		}
	}
	
	public void destruir() {
		fabrica.destruirEnemigo(this);
		celda.destruirEnemigo();
		
	}
	
	public int getPuntaje() {
		return puntaje;
	}

	
	public void aceptar(Visitor v)
	{
		v.visitarEnemigo(this);
	}
}
