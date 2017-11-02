package logica;

import java.util.ArrayList;
import java.util.List;

import defensa.Defensa;
import premio.*;




public class ControlDePremio 
{
	
	private Juego juego;
	
	//private List<MagiaTemporal> listaMagiaTemporal;
	
	private List<ObjetoPrecioso> listaObjetoPrecioso;
	
	private List<Premio> listaDescarte;
 	
	private MagiaTemporal premioTemporal;
	
	public ControlDePremio(Juego j)
	{
		juego = j;
		//listaMagiaTemporal = new ArrayList<MagiaTemporal>();
		listaObjetoPrecioso = new ArrayList<ObjetoPrecioso>();
		listaDescarte = new ArrayList<Premio>();
	}

	
	public void agregarObjetoPrecioso(ObjetoPrecioso obj)
	{
		listaObjetoPrecioso.add(obj);
	}
	
	public void accionarMagiaTemporal(List<Defensa> l)
	{
		premioTemporal.accionar(l);
	}
	
	public void sumarPlus()
	{
		juego.sumarPuntaje(p);
	}
}
