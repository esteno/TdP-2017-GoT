package ObjetoDeMapa;

import logica.FabricaObjetoGrafico;

public class ObjetoLago extends ObjetoDeMapa {
	
	public ObjetoLago() {
		grafico = FabricaObjetoGrafico.getInstancia().construirGraficoLago();
		multiplicadorVelocidad = 0.5;
	}

}
