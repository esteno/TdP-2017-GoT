package ObjetoDeMapa;

import logica.FabricaObjetoGrafico;

public class ObjetoComun extends ObjetoDeMapa {
	
	public ObjetoComun() {
		multiplicadorVelocidad = 3;
		grafico = FabricaObjetoGrafico.getInstancia().construirGraficoObjetoComun();
	}

}
