package enemigos;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorEnemigo;
import estadoEnemigo.EstadoMultiplicador;
import objetos.GameObject;
import objetos.ObjetoMovil;

public abstract class Enemigo extends ObjetoMovil
{
	
	//atributos
	protected EstadoMultiplicador estado;
	protected Visitor visitor;
	protected int puntos; //puntos que devuelve al ser destruido
	
	protected String path; //path del gif
	
	
	public Enemigo() {
		visitor = new VisitorEnemigo(this);
		bloqueado=false;
	}
	
	public int getFuerzaImpacto()
	{
		return (int) Math.floor(fuerza_impacto*estado.multiplicador());
	}

	public void avanzar(){
		if(!Lock(true)){
		Celda celdaNueva = celda.celdaIzquierda();
			if(celdaNueva != null) 	{
				int xAnterior = celda.getX();
				int yAnterior = celda.getY();
				
				if(contVelocidad <= 0 && celdaNueva.objetoMovil() == null){	
					celda = celdaNueva;
					bloqueado=true;
					celda.moverEnemigo(this,xAnterior, yAnterior);
					contVelocidad = velocidad;
				}
				else {
					contVelocidad -= 100*celda.getMultiVelocidad();
				}
			}
			else 
				destruir();
		}
	}
	
	public void destruir() 	{
		System.out.println("Soy un enemigo con vida"+puntos_vida);
		puntos_vida=0;
		grafico.destruir();
		//celda.destruirObjetoMovil();	
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void aceptar(Visitor v){
		v.visitarEnemigo(this);
	}
	
	public void atacar() {
		Celda celdaIzq = celda.celdaIzquierda();
		GameObject defensa = celdaIzq.getEstatico();
		if(defensa != null) {
			visitor.visitarDefensor(defensa);
		}
	}

	public void setEstado(EstadoMultiplicador estado) {
		this.estado = estado;
		
	}
	
	public String getPath(){
		return path;
	}

}