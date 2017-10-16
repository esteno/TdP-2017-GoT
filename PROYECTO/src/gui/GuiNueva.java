package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import defensa.Defensa;
import logica.FabricaDeDefensa;
import logica.Juego;
import objetos.GameObjectGrafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

public class GuiNueva
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
					GuiNueva window = new GuiNueva();
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
	public GuiNueva() {
		juego = new Juego(this, ALTO, ANCHO);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelControl = new JPanel();
		frame.getContentPane().add(panelControl, BorderLayout.EAST);
		panelControl.setLayout(new GridLayout(0, 1, 0, 0));
		
		labelPuntaje = new JLabel("Puntaje: 0");
		panelControl.add(labelPuntaje);
		
		JButton botonAgregar = new JButton("Agregar Jorgito");
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("quiere agregar a jorgito");
				fabricaDeDefensa.construirJorgito();
			}
		});
		panelControl.add(botonAgregar);
		
		
		//eliminar defensa
		JButton botonEliminar= new JButton("Eliminar Jorgito");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				aEliminar=true;
	        }
		});
		panelControl.add(botonEliminar);

		
		
		JButton botonAgregarEnemigo = new JButton("AgregarEnemigo");
		botonAgregarEnemigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("GUI juego.crearEnemigo()");
				juego.crearEnemigo();
				
			}
			
		});
		panelControl.add(botonAgregarEnemigo);
		
		
		
		
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
				label.setBounds(x,y,alto,ancho);
				label.setIcon(new ImageIcon(imagen));
				label.addMouseListener(getMouseListener());
				panelCeldas.add(label);
				
			}
		}
		
		frame.getContentPane().add(panelMapa);
		panelMapa.setLayout(null);
		
		
		
		
	}
	
	public void puntaje(int puntaje) {
		labelPuntaje.setText("Puntaje: "+puntaje);
	}
	
	public void agregarEnemigo(int x, int y, BufferedImage e) {
		System.out.println("GUI imagen "+e);
		JLabel labelEnemigo = new JLabel(new ImageIcon(e));
		
		labelEnemigo.setBounds(x*32, y*32,e.getWidth(),e.getHeight());
		System.out.println("GUI label bounds "+ labelEnemigo.getBounds());
		panelEnemigos.add(labelEnemigo);
		panelEnemigos.repaint();
	}
	
	public void moverEnemigoGrafico(int x, int y, int xAnterior, int yAnterior) {
		JLabel label = buscarLabel(x, y, panelEnemigos);
		label.setBounds(x, y, label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
		panelEnemigos.repaint();
	}
	
	private JLabel buscarLabel(int x, int y, JPanel panel) {
		Component[] arrComponents = panel.getComponents();
		JLabel label = null;
		boolean encontre = false;
		for(int i = 0; !encontre && i < arrComponents.length; i++ ) {
			Component comp = arrComponents[i];
			if(comp.getBounds().x == x*32 && comp.getBounds().y == y*32) {
				encontre = true;
				label = (JLabel) arrComponents[i];
			}
		}
		return label;
	}
	
	public MouseListener getMouseListener() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel labelCelda = (JLabel) e.getComponent();
				System.out.println("label celda"+labelCelda);
				int x= labelCelda.getBounds().x / 32;
				int y= labelCelda.getBounds().y / 32;
				if(aEliminar)
				{
					
					JLabel remover = buscarLabel(x, y, panelDefensa);
					if(remover!=null){
						System.out.println("remover no es nulo");
						juego.eliminarDefensa(x, y);
						panelMapa.remove(remover);
						panelMapa.repaint();
					}
					aEliminar=false;
				}
				else
				{ Defensa defensa = fabricaDeDefensa.getDefensa();
				  if(defensa != null) 
				  {

					juego.agregarDefensa(x,y);
					BufferedImage imagen = defensa.getGrafico();
					System.out.println(imagen);
					JLabel labelNuevo = new JLabel(new ImageIcon(imagen));
					labelNuevo.setBounds(labelCelda.getBounds());
					System.out.println("labelNuevo "+labelNuevo.isOpaque());
					panelDefensa.add(labelNuevo);
					panelCeldas.repaint();
					panelDefensa.repaint();
					System.out.println("panelMapa ND length "+panelDefensa.getComponentCount());
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
