package defensa;

import objetos.GameObject;
import nivel.*;
import colisiones.*;

public abstract class Defensa extends GameObject 
{
     //protected Nivel nivel;
     protected VisitorDefensa visitor = new VisitorDefensa(this);
     
     
     //Valor que da el tiempo entre ataque y ataque
     protected int velocidadAtaque;
     
     //Contador que se va decrementando, cuando llega a 0 la defensa ataca.
     protected int proximoAtaque;

     //precio de costo
     protected int precio;
     
     
     public void aceptar(Visitor v)
     {
    	 v.visitarDefensa(this);
     }
  
     
 	public int getPrecio()
 	{
 		return precio;
 	}
}
