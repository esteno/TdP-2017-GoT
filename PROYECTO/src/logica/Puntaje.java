package logica;

public class Puntaje {
	
	private int puntos = 0;
	private int oro = 2000;
	private int bombasDisponibles = 0;
	private int barricadasDisponibles = 0;
	
	public Puntaje() {
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
	
	public void agregarBomba() {
		bombasDisponibles++;
	}

	public void agregarBarricada() {
		barricadasDisponibles++;
	}
	
	public boolean hayBombas() {
		return bombasDisponibles > 0;
	}
	
	public boolean hayBarricadas() {
		return barricadasDisponibles > 0;
	}
	
	public void restarBomba() {
		bombasDisponibles--;
	}
	
	public void restarBarricada() {
		barricadasDisponibles--;
	}
	
	public int getPuntaje() {
		return puntos;
	}
	
	public int getOro() {
		return oro;
	}
}
