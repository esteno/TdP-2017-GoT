package defensa;

import objetos.GameObject;
import nivel.*;
import colisiones.*;

public abstract class Defensa extends GameObject 
{
     //protected Nivel nivel;
     protected VisitorDefensa visitor;
     
     //Cuanto cuesta crear esta defensa
     protected int precio;
     
     //Valor que da el tiempo entre ataque y ataque
     protected int velocidadAtaque;
     
     //Contador que se va decrementando, cuando llega a 0 la defensa ataca.
     protected int proximoAtaque;
     
     protected final int puntos_vida_inicio = this.puntos_vida;
     
     protected final int fuerza_impacto_inicio=this.fuerza_impacto;
     
     
     
     public void aceptar(Visitor v)
     {
    	 v.visitarDefensor(this);
     }
     
  
}
