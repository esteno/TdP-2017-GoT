package ObjetoDeMapa;

import logica.FabricaObjetoGrafico;

public class ObjetoNieveProfunda extends ObjetoDeMapa {
	
	//Terreno que simula ser nieve
	public ObjetoNieveProfunda() {
		grafico = FabricaObjetoGrafico.getInstancia().construirGraficoNieveProfunda();
		multiplicadorVelocidad = 2;
	}

}
