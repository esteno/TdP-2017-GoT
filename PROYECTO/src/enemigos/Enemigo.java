package enemigos;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorEnemigo;
import estadoMultiplicador.EstadoMultiplicador;
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
	protected int oro;
	
	protected boolean atacando=false;
	
	public Enemigo() {
		visitor = new VisitorEnemigo(this);
	}
	
	//La fuerza de ataque es la fuerza de impacto por el estado de ataque, redondeado a un entero.
	public int getFuerzaImpacto()
	{
		return (int) Math.floor(fuerzaImpacto*estado.multiplicadorAtaque());
	}

	
	public void avanzar(){

		if(!atacando)
			if(!grafico.Lock(true)){
			//Si la celda es nula quiere decir que llego al borde izquierdo del mapa.
			Celda celdaNueva = celda.celdaIzquierda();
				if(celdaNueva != null) 	{
					//Guarda la posicion acutal
					int xAnterior = celda.getX();
					int yAnterior = celda.getY();
					
					//Si ya se puede mover y no hay nada en la celda adyacente se mueve
					if(contVelocidad <= 0 && celdaNueva.objetoMovil() == null){	
						celda = celdaNueva;
						grafico.setBloqueado(true);
						celda.moverEnemigo(xAnterior, yAnterior);
						contVelocidad = (int) Math.floor(velocidad*celda.getMultiVelocidad());
					}
					else {
						//descuenta de contador
						contVelocidad -= 100*celda.getMultiVelocidad();
					}
				}
				else 
					destruir();
			}
	}
	
	public void destruir() 	{
		//Los puntos de vida se ponen en cero para poder ser removida de la lista de control
		puntosVida=0;
		grafico.destruir();
		celda.destruirObjetoMovil();	
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
			visitor.visitarDefensa(defensa);
			atacando=true;
			System.out.println("Atacaaaa");
		}
		else atacando=false;
	}

	public void setEstado(EstadoMultiplicador estado) {
		this.estado = estado;
		
	}
	
	
	public Visitor getVisitor()
	{
		return visitor;
	}

	public int getOro() {
		
		return oro;
	}

}