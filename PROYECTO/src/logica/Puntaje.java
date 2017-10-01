package logica;

public class Puntaje {
	
	private int puntos;
	private int oro;
	
	public Puntaje() {
		puntos = 0;
		oro = 0;
	}
	
	public void sumarPuntaje(int p) {
		puntos += p;
	}
	
	public void sumarOro(int o) {
		oro += o;
	}
	
	public void restarOro(int o) {
		oro -= o;
	}
	
	public int puntaje() {
		return puntos;
	}
	
	public int getOro() {
		return oro;
	}

}
