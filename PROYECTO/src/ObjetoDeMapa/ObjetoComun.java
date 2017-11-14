package ObjetoDeMapa;

import logica.FabricaObjetoGrafico;

public class ObjetoComun extends ObjetoDeMapa {
	
	public ObjetoComun() {
		multiplicadorVelocidad = 1.0;
		grafico = FabricaObjetoGrafico.getInstancia().construirGraficoObjetoComun();
	}

}
