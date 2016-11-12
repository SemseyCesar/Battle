package prueba;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;


import Logica.*;
import Logica.enemigos.*;
import Logica.powerUp.*;
import prueba.mapa.Mapa;

public class Log 
{	
	private Random aleatorio=new Random();
	private LinkedList <GameObject> objetos= new LinkedList<GameObject>();
	private LinkedList <Tanque> tanques= new LinkedList<Tanque>();
	private TanqueJugador jugador;
	private int cantEnemigos;
	private int powerUpcont;
	private int enemigosDestruidos;
	private int puntos;
	private int vida;
	private Mapa map;
	private int time;
	private int pos;
	private Game juego;
	
	public Log(Mapa map,Game juego)
	{
	this.map=map;
	this.juego=juego;
	jugador= new TanqueJugador(map,this);
	objetos.add(jugador);
	tanques.add(jugador);
	enemigosDestruidos=0;
	time=0;
	vida=3;
	pos=1;
	cantEnemigos=0;
	puntos=0;
	jugador.start();
	}
	




	public synchronized void actualizar()
	{
	
	
		if(powerUpcont>=4)
		{
			generarPowerUp();	
			powerUpcont=0;
		}
		
		if(time>40 && cantEnemigos<4)
		{
			enemigo(pos);
			pos=(pos+1)%3;
			time=0;
		}
		else
			if(time>40)
				time=0;
		time++;

	
	}
		
	public void keyPressed(KeyEvent e) 
	{
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{jugador.setDirX(-1); jugador.setDirY(0);
			jugador.setSprite("IZQUIERDA");
			}
		else
		  if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			 {jugador.setDirX(1);jugador.setDirY(0);
			 jugador.setSprite("DERECHA");
			 }
		  else
			  if (e.getKeyCode() == KeyEvent.VK_UP)
				  {jugador.setDirY(-1);jugador.setDirX(0);
				  jugador.setSprite("ARRIBA");
				  }
			  else
				  if (e.getKeyCode() == KeyEvent.VK_DOWN)
						 {jugador.setDirY(1);jugador.setDirX(0);
						 jugador.setSprite("ABAJO");
						 }						
	}
	
	public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode()== KeyEvent.VK_F)
		  {
			  jugador.disparar();
			  
			  
		  }
		
	}
	
	private void enemigo(int i) 
	{
		
		if(cantEnemigos<4)
		{
			TanqueEnemigo enemigo;
			int R= aleatorio.nextInt(5);
			
			if((R==0))
				{enemigo=new Poder(map,this,i); }
			else
				if(R==1)
					{enemigo=new Rapido(map,this,i);}
				else 
					if (R==2)
						{enemigo=new Blindado(map,this,i);}
					else
						{enemigo=new Basico(map,this,i);}
			
			
			objetos.add(enemigo);
			tanques.add(enemigo);
			enemigo.setX(16*6*i);
			enemigo.start();
			cantEnemigos++;
		}
	}
	

	
	

	public TanqueJugador getJugador()
	{
		return jugador;
	}
	
	public int getPuntos(){return puntos;}
	public LinkedList<GameObject> getGameObjets()
	{
		return objetos;
	}
	
	public LinkedList<Tanque> getTanques()
	{
		return tanques;
	}

	public void enemigoDestruido(int puntos)
	{
		
		this.puntos+=puntos;
		cantEnemigos--;
		enemigosDestruidos++;
		powerUpcont++;
		if (enemigosDestruidos>15)
			juego.ganar(true);
	}
	
	public void sumarPuntos(int puntos)
	{
		this.puntos+=puntos;
	}
	
	public int cantEnemigosDestruidos(){return enemigosDestruidos;}



	public void jugadorDestruido() 
	{
		vida--;
		if(vida>0)
		{
		jugador= new TanqueJugador(map,this);
		objetos.add(jugador);
		tanques.add(jugador);
		jugador.start();
		}
		else
		{
			juego.ganar(false);
		}
		
	}
	
	public void efectoVida()
	{
		vida++;
	}
	
	public int getVida(){return vida;}
	
	
	private void generarPowerUp()
	{
		PowerUp pow;
		int n =aleatorio.nextInt(156);
		int pos=map.obtenerPosPowerUp(n);
		n=aleatorio.nextInt(6);
		
		if(n==0)
			pow=new Casco((pos%map.getAncho())*16,(pos/map.getAncho())*16,this, map);
		else
			if(n==1)
				pow=new Granada((pos%map.getAncho())*16,(pos/map.getAncho())*16,this, map);
			else
				if(n==2)
					pow=new Pala((pos%map.getAncho())*16,(pos/map.getAncho())*16,this, map);
				else
					if(n==3)
						pow=new Timer((pos%map.getAncho())*16,(pos/map.getAncho())*16,this, map);
					else
						if(n==4)
							pow=new Vida((pos%map.getAncho())*16,(pos/map.getAncho())*16,this, map);
						else
								pow=new Estrella ((pos%map.getAncho())*16,(pos/map.getAncho())*16,this, map);
		objetos.add(pow);
	}
	
	public void perder()
	{
		juego.ganar(false);
	}
}
