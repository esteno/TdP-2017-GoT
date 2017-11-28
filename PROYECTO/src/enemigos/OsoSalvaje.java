package enemigos;

public class OsoSalvaje extends EnemigoCuerpo {

	public OsoSalvaje(){
		grafico = fabricaGrafica.construirOsoSalvaje();
		fuerzaImpacto = 100;
	    velocidad = contVelocidad = -30;
	    puntos=100;
	    puntosVida=150;
	    oro=100;
	    velocidadAtaque = 20;
	    proximoAtaque = 0;
	}

}