package colisiones;

import enemigos.Enemigo;
import defensa.Defensa;

public class VisitorEnemigo extends Visitor
{
	protected Enemigo miEnemigo;
	
	//constructor
	public VisitorEnemigo(Enemigo g){
		miEnemigo=g;
	}

	//metodos
	@Override
	public void visitarDefensa(Defensa d){
		d.recibirAtaque(miEnemigo.getFuerzaImpacto());
	}
	
	@Override
    public void visitarEnemigo(Enemigo e){
    	///Un enemigo ha visitado un enemigo. No hay accion
    }
}