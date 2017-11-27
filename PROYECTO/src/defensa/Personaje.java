package defensa;

import estadoMultiplicador.*;

public abstract class Personaje extends Defensa {
	
	protected int puntosVidaInicio;
    protected int fuerzaImpactoInicio;
    
	public void curacion(){
		puntosVida = puntosVidaInicio;
	}
}