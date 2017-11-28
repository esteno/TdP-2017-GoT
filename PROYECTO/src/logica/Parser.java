package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ObjetoDeMapa.*;
import celdas.*;
import mapa.Mapa;

public class Parser 
{
	private Mapa mapa;
	private int alto;
	private int ancho;
	
	public Parser(Mapa mapa, int alto, int ancho) {
		this.mapa = mapa;
		this.alto = alto;
		this.ancho = ancho;
	}
	
	public Celda[][] parsearNivel(String path) 
	{
		Celda[][] arregloCeldas = new Celda[ancho][alto];
		Celda celda = null;
		try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea = null;
            
    		for(int i = 0; i < alto; i++) {
    			linea = bufferedReader.readLine();
    			for(int j = 0; j < ancho; j++) {
    				celda = new Celda(mapa, j, i);
    				switch(linea.charAt(j)) {
    					case 'C':
    						celda.setObjetoDeMapa(new ObjetoComun());
    						break;
    					case 'N':
    						celda.setObjetoDeMapa(new ObjetoNieveProfunda());
    						break;
    					case 'L':
    						celda.setObjetoDeMapa(new ObjetoLago());
    						break;
    				}
    				arregloCeldas[j][i] = celda;
    			}
    		}
            bufferedReader.close();   
        }
        catch(FileNotFoundException e) {
            System.out.println("No se encuentra el archivo en la ubicacion "+path);                
        }
        catch(IOException e) {
            System.out.println("Eror I/O "+path);                  
        }
		return arregloCeldas;
	}
}
