package defensa;

import objetos.GameObject;
import nivel.*;
import colisiones.*;

public abstract class Defensa extends GameObject 
{
     protected Nivel nivel;
     protected Visitor visitor;
     protected int precio;
     
     
     public Defensa()
     {
    	 
     }
}
