package prueba;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


import javax.swing.JFrame;

import Logica.GameObject;
import prueba.graficos.Pantalla;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;

public class Game extends Canvas implements Runnable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ANCHO=208;
	private static final int ALTO=192;
			
	private static JFrame ventana;
	private static volatile Thread thread;
	public static Pantalla pantalla;
	
	//enlazo un arreglo de pixeles(enteros) a una imagen que se puede dibujar en eñ canvas;
	private static BufferedImage imagen=new BufferedImage(ANCHO,ALTO,BufferedImage.TYPE_INT_RGB);
	private static int []pixeles= ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
	private static Mapa map=new Mapa("mapa1.txt");
	private Log log= new Log (map,this);
	//variable del bucle principal
	private static boolean inGame=false;
	
	private Game()
	{
		
		pantalla= new Pantalla(ANCHO, ALTO);
		ventana= new JFrame ("Juego");
		ventana.setPreferredSize(new Dimension(ANCHO,ALTO));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.X_AXIS));
		ventana.getContentPane().add(this);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		this.addKeyListener(new Teclado());
	
	}
	
	//en el bucle principal actualiza la pantalla o graficas
	private void mostrar()
	{
		// suavizar imagen
		BufferStrategy estrategia= getBufferStrategy();
		if(estrategia==null)
		{
			createBufferStrategy(3);
			return;
		}
		pantalla.limpiar();
		
		for(GameObject g: log.getGameObjets())
		{
			pantalla.mostrarGameObject(g.getX(), g.getY(), g.getImg());
		}
		
		map.mostrar(pantalla);
	
		for (int i=0;i<pixeles.length;i++)
			pixeles[i]=pantalla.pixeles[i];
		
		//cargo la imagen o pixeles al buffer y lo dibujo en el canvas
		Graphics g=estrategia.getDrawGraphics();
		
		g.drawImage(imagen, 0,0,getWidth(),getHeight(),null);
		
		g.setColor(Color.RED);
		g.drawString("pts: " +log.getPuntos() , 10, 10);
		g.drawString("ED: "+ log.cantEnemigosDestruidos(), 10, 25);
		g.drawString("Vida: "+ log.getVida(),10, 40);
		
		g.dispose();// limpio el buffer
		
		estrategia.show();
	}


	public synchronized void actualizar()
	{
		log.actualizar();
			
	}
	private synchronized void iniciar()
	{
		inGame=true;
		thread=new Thread (this,"graficos");
		thread.start();
	}
	
//	private synchronized void detener()
//	{
//		inGame=false;
//		thread.suspend();
//	}
////	private synchronized void renaudar()
////	{
////		inGame=true;
////		thread.resume();
////	}

	
	
	public synchronized void ganar(boolean gano)
	 {
		 inGame=false;
		 pantalla.limpiar();
		 
		 if(gano)
			 pantalla.mostrarGameObject(6*16, 6*16, Sprite.GANAR);
		 else
			 pantalla.mostrarGameObject(6*16, 6*16, Sprite.PERDER);
		 
		 for (int i=0;i<pixeles.length;i++)
				pixeles[i]=pantalla.pixeles[i];
		 Graphics g=this.getGraphics();
		 g.drawImage(imagen, 0,0,getWidth(),getHeight(),null);
		 g.setColor(Color.WHITE);
		 g.drawString("pts: " +log.getPuntos() , 10, 10);
	 
	 }
	 
	@SuppressWarnings("static-access")
	public void run() {
		
		while(map.aguilaViva()&& inGame)
		{
			actualizar();
			mostrar();
			try {
				thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!map.aguilaViva())
			ganar(false);
	}

	public static void main(String[] args)
	{
		Game juego= new Game();
		juego.iniciar();
		
		
	}
	
	private class Teclado implements KeyListener
	{
	
		public void keyTyped(KeyEvent e) 
		{
			
			log.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) 
		{
			log.keyReleased(e);
		}
		public void keyPressed(KeyEvent e) {
			log.keyPressed(e);
		}
		
	}
}
