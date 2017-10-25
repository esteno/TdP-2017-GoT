package defensa;

import objetos.GameObject;
import nivel.*;
import colisiones.*;

public abstract class Defensa extends GameObject 
{
     //protected Nivel nivel;
     protected VisitorDefensa visitor;
     protected int precio;
     protected int velocidadAtaque;
     protected int proximoAtaque;
     
    
     
     public void aceptar(Visitor v)
     {
    	 v.visitarDefensor(this);
     }
     
     
     public void recibirAtaque(int i)
     {
    	 fuerza_impacto=-i;
     }
}
