package estadoMultiplicador;

public abstract class EstadoMultiplicador 
{
	protected double multiplicadorAtaque;
	protected double multiplicadorVida;
	
	// Modifica el daño que hace el que lo use
	public double multiplicadorAtaque() {
		return multiplicadorAtaque;
	}
	
	// Modifica la vida que tiene el que lo usa
	public double multiplicadorVida() {
		return multiplicadorVida;
	}
}