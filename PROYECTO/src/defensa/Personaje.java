package defensa;

import estadoMultiplicador.*;

public abstract class Personaje extends Defensa {
	
	protected int puntosVidaInicio = this.puntosVida;
    protected int fuerzaImpactoInicio = this.fuerzaImpacto;
    
    public void cambiarEstado(EstadoMultiplicador nuevoEstado) {
    	estado = nuevoEstado;
    }
	
	public void curacion(){
		puntosVida = puntosVidaInicio;
	}
}