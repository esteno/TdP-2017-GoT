package logica;

import java.util.ArrayList;
import java.util.List;


import premio.*;




public class ControlDePremio 
{
	
	private Juego juego;
	
	private List<MagiaTemporal> listaMagiaTemporal;
	
	private List<ObjetoPrecioso> listaObjetoPrecioso;
	
	private List<Premio> listaDescarte;
 	
	
	
	public ControlDePremio(Juego j)
	{
		juego = j;
		listaMagiaTemporal = new ArrayList<MagiaTemporal>();
		listaObjetoPrecioso = new ArrayList<ObjetoPrecioso>();
		listaDescarte = new ArrayList<Premio>();
	}

	
	public void agregarObjetoPrecioso(ObjetoPrecioso obj)
	{
		listaObjetoPrecioso.add(obj);
	}
}
