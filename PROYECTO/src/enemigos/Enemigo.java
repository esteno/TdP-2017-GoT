package enemigos;

import java.util.List;

import celdas.Celda;
import colisiones.Visitor;
import colisiones.VisitorEnemigo;
import estadoMultiplicador.EstadoMultiplicador;
import objetos.GameObject;
import objetos.ObjetoMovil;

public abstract class Enemigo extends ObjetoMovil{
	
	//atributos
	//Estado que multiplica la vida y el ataque
	protected EstadoMultiplicador estado;
	
	//Visitor que usa la clase
	protected Visitor visitor = new VisitorEnemigo(this);
	protected int puntos; //puntos que devuelve al ser destruido
	protected int oro;
	protected boolean atacando = false;

	//La fuerza de ataque es la fuerza de impacto por el estado de ataque, redondeado a un entero.
	public int getFuerzaImpacto(){
		return (int) Math.floor(fuerzaImpacto*estado.multiplicadorAtaque());
	}
	
	public void destruir() 	{
		//Los puntos de vida se ponen en cero para poder ser removida de la lista de control
		puntosVida=0;
		grafico.destruir();
		celdas.destruirEnemigo();	
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void aceptar(Visitor v){
		v.visitarEnemigo(this);
	}
	
	@Override
	public void avanzar() {
		if(!atacando) {
			if(!grafico.Lock(true)){
				if(contVelocidad >= 0) {
					//Si la celda es nula quiere decir que llego al borde izquierdo del mapa.
					List<Celda> celdasNuevas = celdas.celdaIzquierda();
					if(!celdasNuevas.isEmpty()) {	
						Boolean puedeMover = true; 
						for(Celda celda : celdasNuevas) {
							if(celda.getEstatico() != null)
								puedeMover = false;
							if(celda.getEnemigo() != null)
								puedeMover = false;
						}
						if(puedeMover) 	{
							celdas.moverGrafico(this);
							contVelocidad = (int) Math.floor(velocidad*celdas.getMultiVelocidad());
							grafico.setBloqueado(true);
							List<Celda> celdasActuales = celdas.getCeldas();
							for(int i = 0; i< celdasActuales.size(); i++) {
								Celda celdaActual = celdasActuales.get(i);
								Celda celdaNueva = celdasNuevas.get(i);
								celdas.moverEnemigo(celdaNueva.getX(), celdaNueva.getY(), celdaActual.getX(), celdaActual.getY());
							}
							celdas.setPos(celdasNuevas.get(0).getX(), celdasNuevas.get(0).getY());
							celdas.limpiar();
							//Si ya se puede mover y no hay nada en la celda adyacente se mueve
							for(Celda celdaNueva: celdasNuevas) {
									celdas.agregarCeldas(celdaNueva);
							}
							if(celdas.getX() == 0)
								destruir();
						}	
					}
				}
				contVelocidad += celdas.getMultiVelocidad();
			}
		}
	}
	
	public void setEstado(EstadoMultiplicador estado) {
		this.estado = estado;
	}

	public int getOro() {
		return oro;
	}
}