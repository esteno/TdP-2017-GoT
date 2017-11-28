package ObjetoDeMapa;

import logica.FabricaObjetoGrafico;

public class ObjetoComun extends ObjetoDeMapa {
	
	// Terreno basico del mapa
	public ObjetoComun() {
		multiplicadorVelocidad = 3;
		grafico = FabricaObjetoGrafico.getInstancia().construirGraficoObjetoComun();
	}

}
