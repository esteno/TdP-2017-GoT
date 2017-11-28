package ObjetoDeMapa;

import logica.FabricaObjetoGrafico;

public class ObjetoLago extends ObjetoDeMapa {
	
	// Terreno que simula ser un lago
	public ObjetoLago() {
		grafico = FabricaObjetoGrafico.getInstancia().construirGraficoLago();
		multiplicadorVelocidad = 1;
	}

}
