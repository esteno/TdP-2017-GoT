package gui;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import logica.CostosDeDefensa;
import logica.FabricaDeDefensa;
import logica.Juego;
import logica.Puntaje;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Insets;


import javax.swing.JOptionPane;
import defensa.Defensa;
import objetos.*;

import java.awt.Color;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ventana implements Runnable{

	private JFrame frame;
	private Juego juego;
	
	private final int ALTO = 8;
	private final int ANCHO = 16;
	private final int ALTO_IMG = 50; // antes 32
	private final int ANCHO_IMG = 50; // antes 32
	private boolean clickCampo = false;
	
	private FabricaDeDefensa fabricaDeDefensa = FabricaDeDefensa.getInstancia();
	private CostosDeDefensa costosDeDefensa = CostosDeDefensa.getInstancia();
	
	private boolean aEliminar = false;
	private boolean campoProtector = false;
	private boolean seCreoBomba = false;
	
	
	private JButton botonPremioBomba;
	private JButton botonPremioOro;
	private JButton botonPremioCuracion;
	private JButton botonPremioDanioDoble;
	private JButton botonPremioCampoProtector;
    private JButton	botonPremioBarricada;
	
	private List<ObjetoMovil> moviles;
	private List<ObjetoMovil> aBorrar;
	private List<ObjetoMovil> aAgregar;
	private JLayeredPane panelMapa;
	private JPanel panelEnemigos;
	private JPanel panelCeldas;
	private JPanel panelDefensa;
	private JPanel panelCeldaPremios;
	private JPanel panelPersonajes;
	private JPanel panelObstaculos;
	
	
	private JButton botonYgritte;
	private JButton botonMountain;
	private JButton botonDragon;
	private JButton botonInmaculado;
	private JButton botonBronn;
	private JButton botonGendry;
	
	private JButton botonFuegoValyrio;
	private JButton botonBarricada;
	private JButton botonRoca;
	private JButton botonTrinchera;
	private JButton botonMuro;
	
	
	
	
	private JButton botonBomba;
	private JButton botonCampo;
	
	private JLabel lblPuntaje;
	private JLabel lblMonedas_1;
	
	private JLabel muroJuego;
	private String muroJ = "res/imagenes/juego/muroHieloJuego.png";


	private final String imagenBotonYgritte = "res/imagenes/juego/botonYgritte.png";
	private final String imagenBotonBronn = "res/imagenes/juego/botonBronn.png";
	private final String imagenBotonMountain = "res/imagenes/juego/botonMountain.png" ;
	private final String imagenBotonDragon = "res/imagenes/juego/botonDragon.png";
	private final String imagenBotonGendry = "res/imagenes/juego/botonGendry.png";
	private final String imagenBotonInmaculado = "res/imagenes/juego/botonInmaculado.png";
	
	
	public String imagenFuegoValyrio = "res/imagenes/juego/botonFuegoValyrio.png";
	public final String imagenBotonMuro = "res/imagenes/juego/botonMuro.png" ;
	public final String imagenBotonRoca = "res/imagenes/juego/botonRoca.png";
	public final String imagenBotonTrinchera = "res/imagenes/juego/botonTrinchera.png";
	 
	
	public final String imagenBotonBomba = "res/imagenes/premios/iconoBomba.png";
	public final String imagenBotonCampo = "res/imagenes/premios/campoProtectorR.gif";
	public final String imagenBotonBarricada = "res/imagenes/premios/botonBarricada.png";
	
	private final String imagenBotonPremioBarricada = "res/imagenes/obstaculos/barricada.png";
	private final String imagenBotonPremioOro = "res/imagenes/premios/monedas.gif";
	private final String imagenBomba = "res/imagenes/premios/iconoBomba.png";
	private final String imagenBombita = "res/imagenes/premios/bombita.png";
	private final String imagenCuracion = "res/imagenes/premios/curacion.png";
	private final String imagenDanioDoble = "res/imagenes/premios/danioDoble.png" ;
	private final String imagenBotonCampoBis = "res/imagenes/premios/campoProtector.gif";


	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("NIGHT KING DEFENSE");
		frame.setBounds(new Rectangle(0, 0, 1000, 800));
		frame.getContentPane().setBounds(new Rectangle(0, 0, 1000,600));
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		moviles= new LinkedList<ObjetoMovil>();
		aBorrar= new LinkedList<ObjetoMovil>();
		aAgregar= new LinkedList<ObjetoMovil>();
		
		panelMapa = new JLayeredPane();
		panelMapa.setBounds(180, 120, 800, 400);
		frame.getContentPane().add(panelMapa);
				
		panelDefensa = new JPanel();
		panelDefensa.setOpaque(false);
		panelDefensa.setBounds(0, 0, 800, 400);
		panelDefensa.setLayout(null);
		panelMapa.add(panelDefensa);
		
		panelEnemigos = new JPanel();
		panelEnemigos.setOpaque(false);
		panelEnemigos.setBounds(0, 0, 800, 400);
		panelEnemigos.setLayout(null);
		panelMapa.add(panelEnemigos);
		
		panelCeldaPremios = new JPanel();
		panelCeldaPremios.setOpaque(false);
		panelCeldaPremios.setBounds(0, 0, 800, 400);
		panelCeldaPremios.setLayout(null);
		panelMapa.add(panelCeldaPremios);
		
		panelCeldas = new JPanel();
		panelCeldas.setOpaque(false);
		panelCeldas.setBounds(0, 0, 800, 400);
		panelCeldas.setLayout(null);
		panelMapa.add(panelCeldas);
		
		//-----------------
		panelPersonajes = new JPanel();
		panelPersonajes.setOpaque(false);
		panelPersonajes.setBounds(0, 0, 100, 562);
		frame.getContentPane().add(panelPersonajes);
		panelPersonajes.setLayout(null);
		
		botonYgritte = new JButton("");
		botonYgritte.setBounds(0, 0, 100, 93);
		botonYgritte.setIcon(new ImageIcon(imagenBotonYgritte));
		panelPersonajes.add(botonYgritte);
		
		botonMountain = new JButton("");
		botonMountain.setBounds(0, 93, 100, 93);
		botonMountain.setIcon(new ImageIcon(imagenBotonMountain));
		panelPersonajes.add(botonMountain);
		
		botonDragon = new JButton("");
		botonDragon.setBounds(0, 186, 100, 96);
		botonDragon.setIcon(new ImageIcon(imagenBotonDragon));
		panelPersonajes.add(botonDragon);
		
		botonInmaculado = new JButton("");
		botonInmaculado.setBounds(0, 279, 100, 94);
		botonInmaculado.setIcon(new ImageIcon(imagenBotonInmaculado));
		panelPersonajes.add(botonInmaculado);
		
		botonBronn = new JButton("");
		botonBronn.setBounds(0, 373, 100, 94);
		botonBronn.setIcon(new ImageIcon(imagenBotonBronn));
		panelPersonajes.add(botonBronn);
		
		botonGendry = new JButton("");
		botonGendry.setBounds(0, 468, 100, 94);
		botonGendry.setIcon(new ImageIcon(imagenBotonGendry));
		panelPersonajes.add(botonGendry);
		
		// ------------------------
		
		lblMonedas_1 = new JLabel("Monedas: 0");
		lblMonedas_1.setBounds(110, 11, 139, 31);
		frame.getContentPane().add(lblMonedas_1);
		lblMonedas_1.setOpaque(true);
		lblMonedas_1.setFont(new Font("Century", Font.PLAIN, 17));
		
		lblPuntaje = new JLabel("Puntaje: 0");
		lblPuntaje.setBounds(110, 53, 139, 31);
		frame.getContentPane().add(lblPuntaje);
		lblPuntaje.setForeground(Color.BLACK);
		lblPuntaje.setBorder(null);
		lblPuntaje.setOpaque(true);
		lblPuntaje.setFont(new Font("Century", Font.PLAIN, 17));
		
	
		// --------------------- premios
		
		botonBarricada = new JButton();
		botonBarricada.setEnabled(false);
		botonBarricada.setBounds(754, 4, 60, 60);
		botonBarricada.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				FabricaDeDefensa.getInstancia().construirBarricada();
				juego.restarBarricada();	
				if (!juego.hayBarricada())
					botonBarricada.setEnabled(false);
			}
		});
		botonBarricada.setIcon(new ImageIcon(imagenBotonBarricada));
		frame.getContentPane().add(botonBarricada);
		
		
		
		botonBomba = new JButton();
		botonBomba.setEnabled(false);
		botonBomba.setBounds(824, 4, 60, 60);
		botonBomba.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				seCreoBomba = true;
				juego.restarBomba();
				if(!juego.hayBombas()) {
					botonBomba.setEnabled(false);
				}
			}
		});
	    botonBomba.setIcon(new ImageIcon(imagenBotonBomba));
		frame.getContentPane().add(botonBomba);
		
		
		botonCampo = new JButton("");
		botonCampo.setIcon(new ImageIcon(imagenBotonCampo));
		botonCampo.setHorizontalAlignment(SwingConstants.LEADING);
		botonCampo.setEnabled(false);
		botonCampo.setBounds(903, 4, 60, 60);
		botonCampo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				campoProtector = true;
				botonCampo.setEnabled(false);
			}
		});
		frame.getContentPane().add(botonCampo);
		
		
		// ------------------- obstaculos
		
		botonFuegoValyrio = new JButton("");
		botonFuegoValyrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				juego.restarOro(costosDeDefensa.costoFuegoValyrio());
				FabricaDeDefensa.getInstancia().construirFuegoValyrio();
			}
		});
		botonFuegoValyrio.setBounds(521, 4, 80, 80);
		botonFuegoValyrio.setIcon(new ImageIcon(imagenFuegoValyrio));
		frame.getContentPane().add(botonFuegoValyrio);
		
		
		botonMuro = new JButton("");
		botonMuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.restarOro(costosDeDefensa.costoMuro());
				FabricaDeDefensa.getInstancia().construirMuro();
			}
		});
		botonMuro.setBounds(256, 4, 80, 80);
		botonMuro.setIcon(new ImageIcon(imagenBotonMuro));
		frame.getContentPane().add(botonMuro);
		
		
		botonRoca = new JButton("");
		botonRoca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.restarOro(costosDeDefensa.costoRoca());
				FabricaDeDefensa.getInstancia().construirRoca();
			}
		});
		botonRoca.setBounds(346, 4, 80, 80);
		botonRoca.setIcon(new ImageIcon(imagenBotonRoca));
		frame.getContentPane().add(botonRoca);
		
		botonTrinchera = new JButton("");
		botonTrinchera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.restarOro(costosDeDefensa.costoTrinchera());
				FabricaDeDefensa.getInstancia().construirTrinchera();
			}
		});
		botonTrinchera.setBounds(436, 4, 80, 80);
		botonTrinchera.setIcon(new ImageIcon(imagenBotonTrinchera));
		frame.getContentPane().add(botonTrinchera);
		
		// ----------------
		muroJuego = new JLabel("");
		muroJuego.setIcon(new ImageIcon(muroJ));
		muroJuego.setBounds(136, 120, 45, 400);
		frame.getContentPane().add(muroJuego);

		// -------------
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setBackground(Color.ORANGE);
		labelFondo.setForeground(Color.ORANGE);
		labelFondo.setIcon(new ImageIcon("res/imagenes/juego/fondo.jpg"));
		labelFondo.setBounds(0, 0, 1000, 562);
		frame.getContentPane().add(labelFondo);
		
		
		JTextArea consola = new JTextArea();
		consola.setLineWrap(true);
		consola.setEditable(false);
		consola.setForeground(Color.white);
		consola.setBackground(Color.DARK_GRAY);
		consola.setBorder(new MatteBorder(2,2,2,2,Color.DARK_GRAY));
		consola.setBounds(2, 564, 994, 135);
		ConsolaMensajes.setContainer(consola);
		ConsolaMensajes.mostrarMensaje("¡Bienvenido! ¡Gracias por jugar!\n Aqui apareceran mensajes importantes.");
		
		JScrollPane sp = new JScrollPane(consola);
		sp.setAutoscrolls(true);
		sp.setBounds(consola.getBounds());
		frame.getContentPane().add(sp);
		

		
		
		///--- ACCIONES DE LOS BOTONES ----
		botonYgritte.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				FabricaDeDefensa.getInstancia().construirYgritte(); 
 				juego.restarOro(costosDeDefensa.costoYgritte());	
 			}
 		});
		
		botonMountain.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				FabricaDeDefensa.getInstancia().construirMountain();
 				juego.restarOro(costosDeDefensa.costoMountain());
 			}
 		});
		
		botonDragon.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				FabricaDeDefensa.getInstancia().construirDragon();
 				juego.restarOro(costosDeDefensa.costoDragon());
 			}
 		});
		
 		botonInmaculado.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				FabricaDeDefensa.getInstancia().construirInmaculado();
 				juego.restarOro(costosDeDefensa.costoInmaculado());
 			}
 		});
		
 		botonGendry.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				FabricaDeDefensa.getInstancia().construirGendry();
 				juego.restarOro(costosDeDefensa.costoGendry());
 			}
 		});
 		
 		botonBronn.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				FabricaDeDefensa.getInstancia().construirBronn();
 				juego.restarOro(costosDeDefensa.costoBronn());
 			}
 		});
		
 		
 		
		// ----------- BOTONES PREMIOS - aparecen en el mapa
 		
 		botonPremioBarricada = new JButton();
 		botonPremioBarricada.setMargin(new Insets(0, 0, 0, 0));
		botonPremioBarricada.setIcon(new ImageIcon(imagenBotonPremioBarricada));
 		botonPremioBarricada.addActionListener(new ActionListener() {
 			@Override
			public void actionPerformed(ActionEvent arg0) 
 			{
				juego.agregarBarricada();
				botonBarricada.setEnabled(true);
				panelCeldaPremios.remove(botonPremioBarricada);
			}
 		});
 
 		
 		
 		
		botonPremioBomba = new JButton();
		botonPremioBomba.setIcon(new ImageIcon(imagenBombita));
		botonPremioBomba.setMargin(new Insets(0, 0, 0, 0));
 		botonPremioBomba.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				juego.agregarBomba();
				botonBomba.setEnabled(true);
				panelCeldaPremios.remove(botonPremioBomba);
			}
 		});
 		
 		
 		botonPremioOro = new JButton();
 		botonPremioOro.setMargin(new Insets(0, 0, 0, 0));
		botonPremioOro.setIcon(new ImageIcon(imagenBotonPremioOro));
		botonPremioOro.setOpaque(false);
 		botonPremioOro.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				juego.sumarOro(1000);
 				ConsolaMensajes.mostrarMensaje("ï¿½Ganaste 1000 monedas!");
 				panelCeldaPremios.remove(botonPremioOro);
 			}
 		});
 		
 		botonPremioCuracion = new JButton();
 		botonPremioCuracion.setMargin(new Insets(0, 0, 0, 0));
 		botonPremioCuracion.setIcon(new ImageIcon(imagenCuracion));
		botonPremioCuracion.setOpaque(false);
 		botonPremioCuracion.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				juego.curarDefensas();
 				panelCeldaPremios.remove(botonPremioCuracion);
 				ConsolaMensajes.mostrarMensaje("Gema ROJA: Las defensas recuperaron sus vidas iniciales.");
 			}
 		});
 		
 		botonPremioDanioDoble = new JButton();
 		botonPremioDanioDoble.setMargin(new Insets(0, 0, 0, 0));
 		botonPremioDanioDoble.setIcon(new ImageIcon(imagenDanioDoble));
 		botonPremioDanioDoble.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				System.out.println("GUI DD");
 				juego.danioDoble();
 				panelCeldaPremios.remove(botonPremioDanioDoble);
 				ConsolaMensajes.mostrarMensaje("Gema VERDE: Las defensas tienen daï¿½o doble.");
 			}
 		});
 		
 		botonPremioCampoProtector = new JButton();
 		botonPremioCampoProtector.setMargin(new Insets(0, 0, 0, 0));
 		botonPremioCampoProtector.setIcon(new ImageIcon(imagenBotonCampoBis));
 		botonPremioCampoProtector.setOpaque(false);
 		botonPremioCampoProtector.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				botonCampo.setEnabled(true);
 				panelCeldaPremios.remove(botonPremioCampoProtector);
 			}
 		});
		
		///---------------
		juego = new Juego(this, ALTO, ANCHO);
		dibujarMapa(juego.getCeldasGraficas());
		

	}
	
	public void puntaje(int puntaje){
		lblPuntaje.setText("Puntaje: "+puntaje);
	}
	
	public void agregarObjetoMovil(int x, int y, GameObject obj) {
		JLabel labelEnemigo = new JLabel();
		obj.getGrafico().setLabel(labelEnemigo);
		ImageIcon icono = obj.getGrafico().getImagen();
		labelEnemigo.setIcon(obj.getGrafico().getImagen());
		labelEnemigo.setBounds(x*ANCHO_IMG, y*ALTO_IMG,icono.getIconWidth(),icono.getIconHeight());
		panelEnemigos.add(labelEnemigo);
		repintar();
	}

	public synchronized void moverGrafico(ObjetoMovil o, boolean b) {
		if(b){
			for(ObjetoMovil obj : aAgregar){
				moviles.add(obj);
			}
			aAgregar.clear();
		}
		else
			aAgregar.add(o);
	}

	public void run(){
		boolean estado=true;
		while(estado){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			moverGrafico(null,true);
			
			for(ObjetoMovil o : aBorrar){
				moviles.remove(o);
			}
			aBorrar.clear();
			
			for(ObjetoMovil o : moviles) {
				if(!o.getGrafico().moverGrafico(o.getVelocidad())){
					aBorrar.add(o);
					o.getGrafico().Lock(false);
				}
			}
			repintar();
		}
	}
	
	private void repintar() {
		panelMapa.repaint();
	}
	
	private JLabel buscarLabel(int x, int y, JPanel panel) {
		Component[] arrComponents = panel.getComponents();
		JLabel label = null;
		boolean encontre = false;
		for(int i = 0; !encontre && i < arrComponents.length; i++ ) {
			Component comp = arrComponents[i];
			if(comp.getBounds().x == x*ANCHO_IMG && comp.getBounds().y == y*ALTO_IMG) {
				encontre = true;
				label = (JLabel) arrComponents[i];
			}
		}
		return label;
	}
	
	public void dibujarDefensa(int x, int y, GameObject obj) {
		JLabel labelCelda = buscarLabel(x, y, panelCeldas);
		JLabel labelNuevo = new JLabel(obj.getGrafico().getImagen());
		ImageIcon icono = obj.getGrafico().getImagen();
		obj.getGrafico().setLabel(labelNuevo);
		labelNuevo.setBounds(labelCelda.getX(), labelCelda.getY(), icono.getIconWidth(), icono.getIconHeight());
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
	
	
	public void ganar(){
		int reply = JOptionPane.showConfirmDialog(frame, "Has ganado!\nQuieres jugar de nuevo?", "Ganaste el juego!", JOptionPane.YES_NO_OPTION);
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
	
	public void oroActual(int oro) {
		lblMonedas_1.setText("Monedas: "+oro);		
		botonYgritte.setEnabled((oro < costosDeDefensa.costoYgritte()) ? false : true);
		botonMountain.setEnabled((oro < costosDeDefensa.costoMountain()) ? false : true); 
		botonDragon.setEnabled((oro < costosDeDefensa.costoDragon()) ? false : true);
		botonInmaculado.setEnabled((oro < costosDeDefensa.costoInmaculado()) ? false : true);
		botonGendry.setEnabled((oro < costosDeDefensa.costoGendry()) ? false : true);
		botonBronn.setEnabled((oro < costosDeDefensa.costoBronn()) ? false : true);
		botonMuro.setEnabled((oro < costosDeDefensa.costoMuro()) ? false : true);
		botonRoca.setEnabled((oro < costosDeDefensa.costoRoca()) ? false : true);
		botonTrinchera.setEnabled((oro < costosDeDefensa.costoTrinchera()) ? false : true);
		botonFuegoValyrio.setEnabled((oro < costosDeDefensa.costoFuegoValyrio()) ? false : true);
	}
	
	
	public MouseListener getMouseListener() {
		return new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel labelCelda = (JLabel) e.getComponent();
				int x= labelCelda.getBounds().x / ANCHO_IMG;
				int y= labelCelda.getBounds().y / ALTO_IMG;
				if(campoProtector){
					
					juego.crearCampo(x, y);
					campoProtector = false;
					
				}
				else if (seCreoBomba) {
					ImageIcon img=new ImageIcon("res/imagenes/premios/iconoBomba.png");
					JLabel nuevo=new JLabel(img);
					nuevo.setBounds(labelCelda.getBounds().x,labelCelda.getBounds().y,img.getIconWidth(),img.getIconHeight());
					panelCeldaPremios.add(nuevo);
					juego.crearBomba(x,y,nuevo);
					if (!juego.hayBombas())
						seCreoBomba=false;

				}
				else{
					Defensa defensa = fabricaDeDefensa.getDefensa();
					if(defensa != null) {
						juego.agregarDefensa(x,y);
					 }
				   }
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		};
	}
	
	public void setCampoGrafico (JLabel label, int x, int y) {
		System.out.println("se ejecuto el setear grafico de campo");
		ImageIcon img=new ImageIcon ("res/imagenes/premios/escudoUp.gif");
		label=new JLabel(img);
		label.setBounds(ANCHO_IMG*x,ALTO_IMG*y,img.getIconWidth(),img.getIconHeight());
		panelCeldaPremios.add(label);
		
	}
	
	public void eliminarLabelPremio(JLabel label) {
		System.out.println("entre a eliminar del panel");
		System.out.println(label==null);
		panelCeldaPremios.remove(label);
	}
	
	//--------------------------
	
	public void agregarPremioBomba(int x, int y) {
		botonPremioBomba.setBounds(x*ANCHO_IMG, y*ALTO_IMG, ANCHO_IMG, ALTO_IMG);
		panelCeldaPremios.add(botonPremioBomba);
	}

	
	public void agregarPremioCuracion(int x, int y) {
		botonPremioCuracion.setBounds(x*ANCHO_IMG, y*ALTO_IMG, ANCHO_IMG, ALTO_IMG);
		panelCeldaPremios.add(botonPremioCuracion);
	}

	
	public void agregarPremioOro(int x, int y) {
		botonPremioOro.setBounds(x*ANCHO_IMG, y*ALTO_IMG, ANCHO_IMG, ALTO_IMG);
		panelCeldaPremios.add(botonPremioOro);
		
	}

	public void agregarPremioDanioDoble(int x, int y) {
		botonPremioDanioDoble.setBounds(x*ANCHO_IMG, y*ALTO_IMG, ANCHO_IMG, ALTO_IMG);
		panelCeldaPremios.add(botonPremioDanioDoble);
	}

	public void agregarPremioCampoProtector(int x, int y) {
		botonPremioCampoProtector.setBounds(x*ANCHO_IMG, y*ALTO_IMG, ANCHO_IMG, ALTO_IMG);
		panelCeldaPremios.add(botonPremioCampoProtector);
	}

	public void agregarPremioBarricada(int x, int y) 
	{
		botonPremioBarricada.setBounds(x*ANCHO_IMG, y*ALTO_IMG, ANCHO_IMG, ALTO_IMG);
		panelCeldaPremios.add(botonPremioBarricada);
	}

	public void dibujarMapa(GameObjectGrafico[][] graficos) 
	{
		// TODO Auto-generated method stub
		panelCeldas.removeAll();
		
		for(int i = 0; i < ANCHO; i++) 
		{
			for (int j = 0; j < ALTO; j++)
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
	}
}