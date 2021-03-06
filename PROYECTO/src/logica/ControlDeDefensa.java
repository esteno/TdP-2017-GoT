package logica;

import java.util.ArrayList;
import java.util.List;

import defensa.Defensa;
import estadoMultiplicador.EstadoMultiplicador;

//
public class ControlDeDefensa implements Runnable {
	
	private List<Defensa> listaInsercion;
	private List<Defensa> listaDefensa;
	private List<Defensa> listaDescarte;
	private boolean isRunning = true;
	
	public ControlDeDefensa(Juego juego) {
		//Lista donde se va a insertar defensa nueva
		listaInsercion = new ArrayList<Defensa>();
		//Lista donde se acciona la defensa
		listaDefensa = new ArrayList<Defensa>();
		//Lista donde se elimina defensas.
		listaDescarte = new ArrayList<Defensa>();
	}
	
	public void agregarDefensa(Defensa defensa) {
		listaInsercion.add(defensa);
	}
	
	public void removerDefensa(Defensa defensa) {
		listaDescarte.add(defensa);
	}
	
	public void run() {
		while(isRunning) {
			try {
				Thread.sleep(1000);
				//Se remueve toda la defensa vieja
				for(Defensa descarte : listaDescarte) {
					listaDefensa.remove(descarte);
				}
				listaDescarte.clear();
				//Se agrega toda la defensa nueva
				for(Defensa insertar : listaInsercion) {
					listaDefensa.add(insertar);
				}
				listaInsercion.clear();
				for(Defensa defensa : listaDefensa) {
					//Si la defensa fue destruida se pone para descartar
					if(defensa.getPuntosVida() <= 0) 
						listaDescarte.add(defensa);
					else 
						defensa.atacar();
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

	public void modificarEstado(EstadoMultiplicador estado) {
		for (Defensa d:listaDefensa) {
			System.out.println("cambiar estado "+d);
			d.cambiarEstado(estado);
		}
	}

	public void curar() {
		for (Defensa d: listaDefensa)
			d.curacion();
	}
}
