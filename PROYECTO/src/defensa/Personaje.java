package defensa;


public abstract class Personaje extends Defensa {
	
	protected int puntosVidaInicio;
    protected int fuerzaImpactoInicio;
    
    // Setea la vida actual a la vida maxima
	public void curacion(){
		puntosVida = puntosVidaInicio;
	}
}