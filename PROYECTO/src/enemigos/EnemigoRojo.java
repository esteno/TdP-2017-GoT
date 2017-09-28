package enemigos;

public class EnemigoRojo extends Enemigo implements Runnable {
	

	public EnemigoRojo() {
		super("res/imagenes/enemigo/enemigo.png");
	    velocidad=1000;	
	}

}
