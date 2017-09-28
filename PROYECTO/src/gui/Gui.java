package gui;

import logica.*;
import objetos.GameObjectGrafico;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import celdas.Celda;
import defensa.Defensa;

import java.awt.BorderLayout;
import javax.swing.JLayeredPane;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class Gui {

	private JFrame frame;
	private Juego juego;
	private final int ALTO = 8;
	private final int ANCHO = 16;
	
	private JLabel[][] matrizLabelCelda;
	private JLabel[][] matrizLabelEstatica;
	private JLabel[][] matrizLabelEnemigo;
	
	private FabricaDeDefensa fabricaDeDefensa = FabricaDeDefensa.getInstancia();
	private JLayeredPane panelMapa;
	
	private final int NIVELCELDA = 0;
	private final int NIVELDEFENSA = 1;
	private final int NIVELENEMIGO = 2;
	
	
	private boolean aEliminar=false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() 
	{
		juego = new Juego(this, ALTO, ANCHO);
		matrizLabelCelda = new JLabel[ANCHO][ALTO];
		matrizLabelEstatica = new JLabel[ANCHO][ALTO];
		matrizLabelEnemigo = new JLabel[ANCHO][ALTO];
		
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelControl = new JPanel();
		frame.getContentPane().add(panelControl, BorderLayout.EAST);
		
		JButton botonAgregar = new JButton("Agregar Jorgito");
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				fabricaDeDefensa.construirJorgito();
			}
		});
		
		panelControl.setLayout(new GridLayout(0, 1, 0, 0));
		panelControl.add(botonAgregar);
		
		
		//eliminar defensa
		JButton botonEliminar= new JButton("Eliminar Jorgito");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				aEliminar=!aEliminar;
	        }
		});
		panelControl.add(botonEliminar);

		
		
		JButton botonAgregarEnemigo = new JButton("AgregarEnemigo");
		botonAgregarEnemigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.crearEnemigo();
				
			}
			
		});
		panelControl.add(botonAgregarEnemigo);

		
		panelMapa = new JLayeredPane();
		frame.getContentPane().add(panelMapa);
		panelMapa.setLayout(new GridBagLayout());

		//Pide todas las celdas graficas y los agrega a un panel con un gridbaglayout.
		GameObjectGrafico[][] graficos = juego.getCeldasGraficas();
		for(int i = 0; i < ANCHO; i++) {
			for (int j = 0; j < ALTO; j++) {
				GridBagConstraints cons = new GridBagConstraints();
				cons.gridheight = cons.gridwidth = 1;
				cons.gridx = i;
				cons.gridy = j;
				JLabel label = new JLabel();
				label.setIcon(new ImageIcon(graficos[i][j].getImagen()));
				label.addMouseListener(getMouseListener());
				panelMapa.add(label, cons, NIVELCELDA);
				matrizLabelCelda[i][j] = label;
				
			}
		}
	}
	
	public void agregarEnemigo(Celda celda, BufferedImage imagen) {
		JLabel label = matrizLabelCelda[celda.getX()][celda.getY()];
		GridBagConstraints cons = new GridBagConstraints();
		cons.gridheight = cons.gridwidth = 1;
		cons.gridx = celda.getX();
		cons.gridy = celda.getY();
		JLabel labelEnemigo = new JLabel();
		labelEnemigo.setIcon(new ImageIcon(imagen));
		labelEnemigo.setBounds(label.getBounds());
		matrizLabelEnemigo[celda.getX()][celda.getY()] = labelEnemigo;
		panelMapa.add(labelEnemigo, cons, NIVELENEMIGO);
	//	panelMapa.validate();
	
	}
	
	
	
	private Vector<Integer> buscarCoordenadas(JLabel label) {
		Vector<Integer> toReturn = new Vector<Integer>(2);
		Boolean encontre = false;
		for(int i = 0; i < matrizLabelCelda.length && !encontre; i++) {
			for(int j = 0; j < matrizLabelCelda[0].length && !encontre; j++) {
				if(matrizLabelCelda[i][j] == label) {
					toReturn.add(0, i);
					toReturn.add(1, j);
					encontre = true;
				}
			}
		}
		return toReturn;
	}
	
	public void moverEnemigoGrafico(int x, int y, int xAnterior, int yAnterior) {
		
		JLabel labelCelda = matrizLabelEnemigo[xAnterior][yAnterior];
		matrizLabelEnemigo[xAnterior][yAnterior] = null;
		matrizLabelEnemigo[x][y] = labelCelda;
		labelCelda.setBounds(matrizLabelCelda[x][y].getBounds());
		labelCelda.repaint();
		
	}
	
	
	public MouseListener getMouseListener() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel labelCelda = (JLabel) e.getComponent();
				Vector<Integer> vector = buscarCoordenadas(labelCelda);
				int x=vector.get(0);
				int y=vector.get(1);
				if(aEliminar)
				{
					juego.eliminarDefensa(x, y);
					JLabel remover = matrizLabelEstatica[x][y];
					matrizLabelEstatica[x][y] = null;
					panelMapa.remove(remover);
					panelMapa.repaint();
				}
				else
				{ Defensa defensa = fabricaDeDefensa.getDefensa();
				  if(defensa != null) 
				  {

					juego.agregarDefensa(x,y);
					GridBagConstraints cons = new GridBagConstraints();
					cons.gridheight = cons.gridwidth = 1;
					System.out.println("x "+vector.get(1)+" y "+vector.get(0));
					cons.gridx = x;
					cons.gridy = y;
					BufferedImage imagen = defensa.getGrafico();
					JLabel labelNuevo = new JLabel(new ImageIcon(imagen));
					labelNuevo.setBounds(labelCelda.getBounds());
					matrizLabelEstatica[x][y] = labelNuevo;
					System.out.println(cons.gridheight+" "+cons.gridwidth);
					panelMapa.add(labelNuevo, cons, NIVELDEFENSA);
				 }
			   }
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
}
