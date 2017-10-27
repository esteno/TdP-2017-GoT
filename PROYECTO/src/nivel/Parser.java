package nivel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import celdas.*;
import mapa.Mapa;

public class Parser 
{
	private Mapa mapa;
	private int alto;
	private int ancho;
	
	public Parser(Mapa m, int alto, int ancho) {
		mapa = m;
	}
	
	public Celda[][] parsearNivel(String path) {
		Celda[][] arregloCeldas = null;
		Celda celda = null;
		try {
            FileReader fileReader = new FileReader(path);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            
            String linea = null;
            
            Celda[][] arreglo = new Celda[alto][ancho];
    		System.out.println("arreglo length "+arreglo.length+ " "+arreglo[0].length);
    		for(int i = 0; i < alto; i++) {
    			linea = bufferedReader.readLine();
    			for(int j = 0; j < ancho; j++) {
    				
    				switch(linea.charAt(j)) {
    					case 'C':
    						celda = new CeldaComun(mapa, i, j);
    						break;
    					case 'A':
    						celda = new CeldaArena(mapa, i, j);
    						break;
    					case 'L':
    						celda = new CeldaLago(mapa, i, j);
    						break;
    					default:
    						celda = new CeldaComun(mapa, i, j);
    				}
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
