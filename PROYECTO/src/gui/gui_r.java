package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logica.FabricaDeDefensa;
import logica.Juego;
import objetos.GameObjectGrafico;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import defensa.Defensa;
import javax.swing.border.LineBorder;

public class gui_r
{

	private JFrame frame;
	
	private Juego juego;
	private final int ALTO = 8;
	private final int ANCHO = 16;
	private final int NIVELCELDA = 0;
	private final int NIVELDEFENSA = 1;
	private final int NIVELENEMIGO = 2;
	
	private FabricaDeDefensa fabricaDeDefensa = FabricaDeDefensa.getInstancia();
	
	private JLabel labelPuntaje;
	private boolean aEliminar=false;
	
	private JLayeredPane panelMapa;
	private JPanel panelControl;
	private JPanel panelCeldas;
	private JPanel panelDefensa;
	private JPanel panelEnemigos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_r window = new gui_r();
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
	public gui_r() 
	{
		initialize();	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		juego = new Juego(this, ALTO, ANCHO);
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		panelMapa = new JLayeredPane();
		panelMapa.setBounds(0,0,ANCHO*32,ALTO*32);
		panelMapa.setBackground(Color.GRAY);
		
		
		panelCeldas = new JPanel();
		panelCeldas.setLayout(null);
		panelCeldas.setBounds(panelMapa.getBounds());
		System.out.println(panelMapa.getBounds());
		panelMapa.add(panelCeldas, NIVELCELDA);
		
		panelDefensa = new JPanel();
		panelDefensa.setLayout(null);
		panelDefensa.setBounds(panelMapa.getBounds());
		panelDefensa.setBackground(new Color(0,0,0,0));
		panelMapa.add(panelDefensa, NIVELDEFENSA);
		
		panelEnemigos = new JPanel();
		panelEnemigos.setLayout(null);
		panelEnemigos.setBounds(panelMapa.getBounds());
		panelEnemigos.setBackground(new Color(0,0,0,0));
		panelMapa.add(panelEnemigos, NIVELENEMIGO);

		GameObjectGrafico[][] graficos = juego.getCeldasGraficas();
		
		for(int i = 0; i < ANCHO; i++) 
		{
			for (int j = 0; j < ALTO; j++) 
			{
				BufferedImage imagen = graficos[i][j].getImagen();
				int ancho = imagen.getWidth();
				int alto = imagen.getHeight();
				int x = i*ancho;
				int y = j*alto;
				JLabel label = new JLabel();
				label.setBounds(x ,y,alto,ancho);
				label.setIcon(new ImageIcon(imagen));
				//label.addMouseListener(getMouseListener());
				panelCeldas.add(label);
				
			}
		}
		
		frame.getContentPane().add(panelMapa, BorderLayout.CENTER);
		panelMapa.setLayout(null);
		
		panelControl = new JPanel();
		frame.getContentPane().add(panelControl, BorderLayout.EAST);
		panelControl.setLayout(new GridLayout(0, 1, 0, 0));
		int x = panelMapa.getX() + panelMapa.getWidth();
		int y = panelMapa.getY() + panelMapa.getHeight();
		panelControl.setBounds(x, y, 300, 500);
		
		labelPuntaje = new JLabel("Puntaje: 0");
		panelControl.add(labelPuntaje);
	
		
		/*JButton botonPersonaje1 = new JButton("Personaje1");
		botonPersonaje1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				fabricaDeDefensa.construirJorgito();
			}
		});
		panelControl.add(botonPersonaje1);
		*/
		
		JButton botonPersonaje2 = new JButton("Personaje2");
		botonPersonaje2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				fabricaDeDefensa.construirJorgito();
			}
		});
		panelControl.add(botonPersonaje2);
		
		JButton botonPersonaje3 = new JButton("Personaje3");
		botonPersonaje3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				fabricaDeDefensa.construirJorgito();
			}
		});
		panelControl.add(botonPersonaje3);
		
		JButton botonPersonaje4 = new JButton("Personaje4");
		botonPersonaje4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				fabricaDeDefensa.construirJorgito();
			}
		});
		panelControl.add(botonPersonaje4);
		
		
		JButton botonPersonaje5 = new JButton("Personaje5");
		botonPersonaje5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				fabricaDeDefensa.construirJorgito();
			}
		});
		panelControl.add(botonPersonaje5);
		
		
		
	}
	
	//////////////// METODOS CON FUNCIONALIDADES /////////////////
	public void agregarEnemigo(int x, int y, BufferedImage e) 
	{
		System.out.println("GUI agregarEnemigo x "+x*32+" y "+y*32);
		JLabel labelEnemigo = new JLabel(new ImageIcon(e));
		labelEnemigo.setBounds(x*32, y*32,e.getWidth(),e.getHeight());
		panelEnemigos.add(labelEnemigo);
		panelEnemigos.repaint();
	}
	
	public void moverEnemigoGrafico(int x, int y, int xAnterior, int yAnterior) 
	{
		
	}
	
	
	public void puntaje(int puntaje) 
	{
		labelPuntaje.setText("Puntaje: "+puntaje);
	}

}
