package ObjetoDeMapa;

import logica.FabricaObjetoGrafico;

public class ObjetoNieveProfunda extends ObjetoDeMapa {
	
	public ObjetoNieveProfunda() {
		grafico = FabricaObjetoGrafico.getInstancia().construirGraficoNieveProfunda();
		multiplicadorVelocidad = 2;
	}

}
