package defensa;

public abstract class DefensaRango extends Defensa

{
	public void atacar() {
		if(proximoAtaque == 0) {
			System.out.println("DEFENSARANGO proximoAtaque == 0");
			celda.generarDisparo();
			proximoAtaque = velocidadAtaque;
		}
		else {
			proximoAtaque--;
		}
	}

}
