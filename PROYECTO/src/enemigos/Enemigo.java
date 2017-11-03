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
	//Estado que multiplica la vida y el ataque
	protected EstadoMultiplicador estado;
	
	//Visitor que usa la clase
	protected Visitor visitor;
	protected int puntos; //puntos que devuelve al ser destruido
	
	public Enemigo() {
		visitor = new VisitorEnemigo(this);
		bloqueado=false;
	}
	
	//La fuerza de ataque es la fuerza de impacto por el estado de ataque, redondeado a un entero.
	public int getFuerzaImpacto()
	{
		return (int) Math.floor(fuerza_impacto*estado.multiplicador());
	}

	
	public void avanzar(){
<<<<<<< HEAD
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
=======
		//Pide la celda para avanzar hacia la izquierda
		Celda celdaNueva = celda.celdaIzquierda();
		//Si la celda es nula quiere decir que llego al borde izquierdo del mapa.
		if(celdaNueva != null) 	{
			//Guarda la posicion acutal
			int xAnterior = celda.getX();
			int yAnterior = celda.getY();
			
			//Si ya se puede mover y no hay nada en la celda adyacente se mueve
			if(contVelocidad <= 0 && celdaNueva.objetoMovil() == null){	
				celda = celdaNueva;
				celda.moverEnemigo(xAnterior, yAnterior);
				contVelocidad = velocidad;
			}
			else {
				//descuenta de contador
				contVelocidad -= 100*celda.getMultiVelocidad();
>>>>>>> b463d95563a49a116de57a0d094830dd644f7b52
			}
			else 
				destruir();
		}
	}
	
	public void destruir() 	{
		//Los puntos de vida se ponen en cero para poder ser removida de la lista de control
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

}