package defensa;

public abstract class DefensaRango extends Defensa

{
	public void atacar() {
		celda.generarDisparo();
	}

}
