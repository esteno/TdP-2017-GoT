package enemigos;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorEnemigo;
import estadoEnemigo.EstadoEnemigo;
import objetos.GameObject;
import objetos.ObjetoMovil;

public abstract class Enemigo extends ObjetoMovil
{
	
	//atributos
	protected EstadoEnemigo estado;
	protected Visitor visitor;
	protected int puntos; //puntos que devuelve al ser destruido
	
	public Enemigo() {
		visitor = new VisitorEnemigo(this);
	}
	
	public int getFuerzaImpacto()
	{
		return (int) Math.floor(fuerza_impacto*estado.multiplicador());
	}

	public void avanzar()
    {
		Celda celdaNueva = celda.celdaIzquierda();
		if(celdaNueva != null) 
		{
			int xAnterior = celda.getX();
			int yAnterior = celda.getY();
			
			if(celdaNueva.objetoMovil() == null)
			{	
				celda = celdaNueva;
				celda.moverEnemigo(xAnterior, yAnterior);
			} 	
		}
		else {
			destruir();
		}

	}
	
	public void destruir() 
	{
		System.out.println("Soy un enemigo con vida"+puntos_vida);
		puntos_vida=0;
		celda.destruirEnemigo();	
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	
	public void aceptar(Visitor v)
	{
		v.visitarEnemigo(this);
	}
	
	public void atacar() {
		GameObject defensa = celda.getEstatico();
		if(defensa != null) {
			visitor.visitarDefensor(defensa);
		}
	}

	public void setEstado(EstadoEnemigo estado) {
		this.estado = estado;
		
	}

}