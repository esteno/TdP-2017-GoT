package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import defensa.Defensa;
import enemigos.Enemigo;
import logica.FabricaDeDefensa;
import logica.Juego;
import objetos.*;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Gui implements Runnable
{

	private JFrame frame;
	
	private Juego juego;
	private final int ALTO = 8; // cantidad de filas
	private final int ANCHO = 16; // cantidad de columnas
	
	
	private final int ALTO_IMG = 50; // antes 32
	private final int ANCHO_IMG = 50; // antes 32
	
	private final int NIVELCELDA = 2;
	private final int NIVELDEFENSA = 0;
	private final int NIVELENEMIGO = 1;
	
	private FabricaDeDefensa fabricaDeDefensa = FabricaDeDefensa.getInstancia();
	
	private JLabel labelPuntaje;
	private boolean aEliminar=false;
	
	private JLayeredPane panelMapa;
	private JPanel panelControl;
	private JPanel panelCeldas;
	private JPanel panelDefensa;
	private JPanel panelEnemigos;
	private JPanel panelPersonajes;
	private JButton btnJorgito;
	
	private List<ObjetoMovil> moviles;
	private List<ObjetoMovil> movilesDescarte;
	

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
		frame = new JFrame("NIGHT KING DEFENSE");
		frame.setBounds(100, 100, 600, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		moviles= new LinkedList<ObjetoMovil>();
		movilesDescarte= new LinkedList<ObjetoMovil>();
		panelMapa = new JLayeredPane();
		panelMapa.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMapa.setBounds(0,0,ANCHO*ANCHO_IMG,ALTO*ALTO_IMG);
		panelMapa.setLocation(200,100);
		panelMapa.setBackground(Color.GRAY);
		
		
		panelCeldas = new JPanel();
		panelCeldas.setLayout(null);
		panelCeldas.setBounds(panelMapa.getBounds());
		panelCeldas.setBackground(new Color(0,0,0,0));
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
		
		frame.getContentPane().repaint();
		juego = new Juego(this, ALTO, ANCHO);
		GameObjectGrafico[][] graficos = juego.getCeldasGraficas();
		
		
		for(int i = 0; i < ALTO; i++) 
		{
			for (int j = 0; j < ANCHO; j++) 
			{
				ImageIcon imagen = graficos[i][j].getImagen();
				int ancho = imagen.getIconWidth();
				int alto = imagen.getIconHeight();
				int x = i*ancho;
				int y = j*alto;
				JLabel label = new JLabel();
				label.setBounds(x ,y,alto,ancho);
				label.setIcon(imagen);
				label.addMouseListener(getMouseListener());
				panelCeldas.add(label);
				
			}
		}
		
		juego.crearMuro();
		
		frame.getContentPane().add(panelMapa, BorderLayout.CENTER);
		panelMapa.setLayout(null);
		
		JPanel panelPuntaje = new JPanel();
		panelPuntaje.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPuntaje.setBackground(SystemColor.menu);
		panelPuntaje.setBounds(171, 11, 117, 81);
		panelMapa.add(panelPuntaje);
		panelPuntaje.setLayout(null);
		
		labelPuntaje = new JLabel("Puntaje: 0");
		labelPuntaje.setBounds(26, 11, 64, 14);
		panelPuntaje.add(labelPuntaje);
		
		panelPersonajes = new JPanel();
		panelPersonajes.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPersonajes.setBounds(10, 11, 151, 539);
		panelMapa.add(panelPersonajes);
		panelPersonajes.setLayout(null);
		
		btnJorgito = new JButton("Jorgito");
		btnJorgito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FabricaDeDefensa.getInstancia().construirJorgito(); 
			}
		});
		btnJorgito.setBounds(10, 11, 83, 54);
		panelPersonajes.add(btnJorgito);
		
		JButton botonYgritte = new JButton("");
		botonYgritte.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\defensa\\ygretteespera.gif"));
		botonYgritte.setBounds(10, 76, 83, 66);
		panelPersonajes.add(botonYgritte);
		
		JButton btnDragon = new JButton("Drogon");
		btnDragon.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\defensa\\blackdragonespera.gif"));
		btnDragon.setBounds(10, 153, 83, 54);
		panelPersonajes.add(btnDragon);
		
		JPanel paneloExplosivos = new JPanel();
		paneloExplosivos.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneloExplosivos.setBounds(425, 11, 228, 81);
		panelMapa.add(paneloExplosivos);
		paneloExplosivos.setLayout(null);
		
		JButton botonBomba = new JButton("");
		botonBomba.setEnabled(false);
		botonBomba.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\premios\\objetosPreciosos\\iconoBomba.png"));
		botonBomba.setBounds(95, 11, 63, 59);
		paneloExplosivos.add(botonBomba);
		
		JButton botonMina = new JButton("");
		botonMina.setEnabled(false);
		botonMina.setIcon(null);
		botonMina.setBounds(159, 11, 63, 59);
		paneloExplosivos.add(botonMina);
		
		JLabel labelExplosivos = new JLabel("EXPLOSIVOS: ");
		labelExplosivos.setHorizontalAlignment(SwingConstants.TRAILING);
		labelExplosivos.setBounds(0, 23, 85, 47);
		paneloExplosivos.add(labelExplosivos);
		
		JPanel panelMonedas = new JPanel();
		panelMonedas.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMonedas.setBounds(298, 11, 117, 81);
		panelMapa.add(panelMonedas);
		panelMonedas.setLayout(null);
		
		JLabel lblMonedas = new JLabel("Monedas:  0");
		lblMonedas.setBounds(10, 11, 97, 14);
		panelMonedas.add(lblMonedas);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\juego\\monedas.gif"));
		label.setBounds(37, 25, 70, 45);
		panelMonedas.add(label);
		
		JPanel panelMagiaTemporal = new JPanel();
		panelMagiaTemporal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMagiaTemporal.setBounds(171, 502, 600, 48);
		panelMapa.add(panelMagiaTemporal);
		panelMagiaTemporal.setLayout(null);
		
		JLabel lblMagiaTemporal = new JLabel("MAGIA TEMPORAL: ");
		lblMagiaTemporal.setBounds(28, 23, 135, 14);
		panelMagiaTemporal.add(lblMagiaTemporal);
		
		JButton botonCampoProteccion = new JButton("");
		botonCampoProteccion.setEnabled(false);
		botonCampoProteccion.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\premios\\gemaceleste.png"));
		botonCampoProteccion.setBounds(202, 11, 89, 30);
		panelMagiaTemporal.add(botonCampoProteccion);
		
		JButton botonDanioDoble = new JButton("");
		botonDanioDoble.setEnabled(false);
		botonDanioDoble.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\premios\\gemaroja.png"));
		botonDanioDoble.setBounds(338, 11, 89, 30);
		panelMagiaTemporal.add(botonDanioDoble);
		
		JButton botonCuracion = new JButton("");
		botonCuracion.setEnabled(false);
		botonCuracion.setIcon(new ImageIcon("C:\\CARPETAS_DE_ESCRITORIO\\TdP-2017-GoT\\PROYECTO\\res\\imagenes\\premios\\gemaverde.png"));
		botonCuracion.setBounds(479, 11, 89, 30);
		panelMagiaTemporal.add(botonCuracion);
		
		//panelControl = new JPanel();
		/*panelControl.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelControl.setBackground(new Color(255, 0, 255));
		frame.getContentPane().add(panelControl, BorderLayout.EAST);
		panelControl.setLayout(new GridLayout(0, 1, 0, 0));
		int x = panelMapa.getX() + panelMapa.getWidth();
		int y = panelMapa.getY() + panelMapa.getHeight();
		//panelControl.setBounds(x, y, 300, 500);
		 * */
		//panelControl.setLocation(0, 0);
		
		
	}
	
	public void puntaje(int puntaje)
	{
		labelPuntaje.setText("Puntaje: "+puntaje);
	}

	public void agregarObjetoMovil(int x, int y, GameObject obj) 
	{
		
		JLabel labelEnemigo = new JLabel();
		obj.getGrafico().setLabel(labelEnemigo);
		labelEnemigo.setIcon(obj.getGrafico().getImagen());
		labelEnemigo.setBounds(x*ANCHO_IMG, y*ALTO_IMG,50,50);
		panelEnemigos.add(labelEnemigo);
		repintar();
	}
	
	public void moverEnemigoGrafico(ObjetoMovil o) 
	{
		moviles.add(o);
		System.out.println("agrego un obj");
	}
	
	public void run(){
		System.out.println("startttttttttttttt  "+moviles.isEmpty());
		boolean estado=true;
		while(estado){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Quiere mover");
			for(ObjetoMovil o : moviles) {
				System.out.println("Tama�o de moviles "+moviles.size());
				if(!o.moverGrafico()){
					movilesDescarte.add(o);
					o.Lock(false);
				}
				repintar();
			}
			for(ObjetoMovil o : movilesDescarte){
				moviles.remove(o);
			}
			if(movilesDescarte.size()>0)
				movilesDescarte.clear();
		}
	}
	
	public void eliminarMovil(int x, int y) {
		System.out.println("GUI Quiero eliminar en x "+x+" y "+y);
		JLabel aEliminar = buscarLabel(x, y, panelEnemigos);
		panelEnemigos.remove(aEliminar);
		repintar();
		
	}
	
	private JLabel buscarLabel(int x, int y, JPanel panel) {
		Component[] arrComponents = panel.getComponents();
		JLabel label = null;
		boolean encontre = false;
		for(int i = 0; !encontre && i < arrComponents.length; i++ ) {
			Component comp = arrComponents[i];
			if(comp.getBounds().x == x*ALTO_IMG && comp.getBounds().y == y*ANCHO_IMG) 
			{
				encontre = true;
				label = (JLabel) arrComponents[i];
			}
		}
		return label;
	}
	
	private void repintar() {
		///panelMapa.validate();
		panelMapa.repaint();

	}
	
	public MouseListener getMouseListener() {
		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel labelCelda = (JLabel) e.getComponent();
				int x= labelCelda.getBounds().x / ANCHO_IMG;
				int y= labelCelda.getBounds().y / ALTO_IMG;
				if(aEliminar)
				{
					
					JLabel remover = buscarLabel(x, y, panelDefensa);
					if(remover!=null){
						juego.eliminarDefensa(x, y);
					}
					aEliminar=false;
				}
				else {
					Defensa defensa = fabricaDeDefensa.getDefensa();
					if(defensa != null) 
					{
						juego.agregarDefensa(x,y);
						ImageIcon imagen = defensa.getGrafico().getImagen();
						JLabel labelNuevo = new JLabel(imagen);
						defensa.getGrafico().setLabel(labelNuevo);
						labelNuevo.setBounds(labelCelda.getBounds());
						panelDefensa.add(labelNuevo);
						repintar();
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
	
	public void dibujarDefensa(int x, int y, GameObject obj) {
		JLabel labelCelda = buscarLabel(x, y, panelCeldas);
		JLabel labelNuevo = new JLabel(obj.getGrafico().getImagen());
		obj.getGrafico().setLabel(labelNuevo);
		labelNuevo.setBounds(labelCelda.getBounds());
		panelDefensa.add(labelNuevo);
		repintar();
	}

	public void gameOver() {
		int reply = JOptionPane.showConfirmDialog(frame, "Has perdido!\nQuieres jugar de nuevo?", "Game Over", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			frame.getContentPane().removeAll();
			frame.getContentPane().repaint();
			
			initialize();
		}
		else {
			JOptionPane.showMessageDialog(null, "Gracias por jugar!");
			System.exit(0);
		}
		
	}
}
