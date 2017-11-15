package defensa;

import objetos.GameObject;
import nivel.*;
import colisiones.*;

public abstract class Defensa extends GameObject 
{
     //protected Nivel nivel;
     protected VisitorDefensa visitor = new VisitorDefensa(this);
     
     //Cuanto cuesta crear esta defensa
     protected int precio;
     
     //Valor que da el tiempo entre ataque y ataque
     protected int velocidadAtaque;
     
     //Contador que se va decrementando, cuando llega a 0 la defensa ataca.
     protected int proximoAtaque;

     
     public void aceptar(Visitor v)
     {
    	 v.visitarDefensa(this);
     }
  
}
