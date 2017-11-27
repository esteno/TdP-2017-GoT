package gui;


import javax.swing.JTextArea;

public class ConsolaMensajes {
	
	private static JTextArea contenedor;
	
	public static void setContainer(JTextArea consola) {
		contenedor = consola;
	}
	
	public static void mostrarMensaje(String msj) {
		if(contenedor == null) {
			System.out.println("--CONSOLA DE MENSAJES NO CONFIGURADA-- Mensaje original:\n"+msj);
		}
		contenedor.setText(contenedor.getText()+"\n"+msj);
	}
}
