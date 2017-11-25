package defensa;

import estadoMultiplicador.*;

public abstract class Personaje extends Defensa {
	
	protected int puntosVidaInicio;
    protected int fuerzaImpactoInicio;
    
    public void cambiarEstado(EstadoMultiplicador nuevoEstado) {
    	System.out.println("cambio de estado");
    	estado = nuevoEstado;
    }
	
	public void curacion(){
		System.out.println("puntos vida actuales "+puntosVida);
		puntosVida = puntosVidaInicio;
		System.out.println("curacion "+puntosVida);
	}
}