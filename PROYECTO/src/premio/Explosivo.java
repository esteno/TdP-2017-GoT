package premio;

import java.util.ArrayList;
import java.util.List;

import colisiones.VisitorDefensa;
import defensa.Defensa;
import objetos.ObjetoMovil;

public abstract class Explosivo extends Defensa
{

	// Explosivo es Objeto Precioso
	
	public void recibirAtaque() {
		
		destruir();
	
	}
	
	public void destruir() {
		
		List<ObjetoMovil> l=new ArrayList<ObjetoMovil>();
		l=celda.adyacentes();
		VisitorDefensa v=new VisitorDefensa(this);
		for (ObjetoMovil o:l)
			o.aceptar(v);	
		celda.destruirObjetoMovil();
	}


}
