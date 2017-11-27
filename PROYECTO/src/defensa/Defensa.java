package defensa;

import objetos.GameObject;
import nivel.*;
import celdas.Celda;
import colisiones.*;
import estadoMultiplicador.EstadoDefensaDefecto;
import estadoMultiplicador.EstadoMultiplicador;

public abstract class Defensa extends GameObject 
{
     //protected Nivel nivel;
     protected VisitorDefensa visitor = new VisitorDefensa(this);
     
     //Valor que da el tiempo entre ataque y ataque
     protected int velocidadAtaque;
     
     //Contador que se va decrementando, cuando llega a 0 la defensa ataca.
     protected int proximoAtaque;

     //precio de costo
     protected int precio;
     
     protected EstadoMultiplicador estado = new EstadoDefensaDefecto();
     
     
     public void aceptar(Visitor v){
    	 v.visitarDefensa(this);
    }
  
     public void setVida(int i) {
    	 puntosVida=i;
     }
     
     public abstract void atacar();
     
     public void cambiarEstado(EstadoMultiplicador nuevoEstado) {
    	 System.out.println("cambio de estado anterior "+estado.multiplicadorAtaque());
    	 estado = nuevoEstado;
    	 System.out.println("cambio de estado nuevo "+estado.multiplicadorAtaque()+"\n-----");
     }
     
 	public int getPrecio(){
 		return precio;
 	}
 	
	public void recibirAtaque(int i){
		puntosVida -= i;
		if(puntosVida < 0) 
			destruir();
	}
	
	public void destruir() {
		grafico.destruir();
		celdas.destruirDefensa();
	}
	
	public void curacion() {
	}
}
