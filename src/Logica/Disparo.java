package Logica;

import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;

public class Disparo extends GameObject
{

	protected int ancho;
	protected int alto;
	protected int vel;
	protected Tanque tanque;
	protected boolean destruyeAcero=false;
	
	public Disparo(int x,int y,int dirX, int dirY,Mapa map,Tanque tanque,Log log)
	{
		this.log=log;
		this.map=map;
		this.tanque=tanque;
		X=x; Y=y;
		this.dirX=dirX;
		this.dirY=dirY;
		vel=tanque.getVelDisp()*4;
		if(dirY==1)
			{sprite=Sprite.disparoDOWN;ancho=3; alto=4;}
		else
			if (dirY==-1)
				{sprite=Sprite.disparoUP;ancho=3; alto=4;}
			else
				if (dirX==-1)
					{sprite=Sprite.disparoLEFT;ancho=4; alto=3;}
				else
					{sprite=Sprite.disparoRIGHT;ancho=4; alto=3;}
			
	}
	public Disparo(int x,int y,int dirX, int dirY,Mapa map,Tanque tanque,Log log,boolean destruyeAcero)
	{
		this(x,y,dirX,dirY,map,tanque,log);
		this.destruyeAcero=destruyeAcero;
	
	}
	
	public synchronized void mover(int x, int y)
	{
		
		if(!enColision(x,0))
			this.setX(this.getX()+x);
		else
			destruir();
		if(!enColision(0,y))
			this.setY(this.getY()+y);
		else
			destruir();
	}
	private boolean enColision(int x, int y) 
	{
		boolean colision=false;
		
		
		int posX=X+x;
		int posY=Y+y;
		if (posX<0 || posX>(sprite.getLado()* map.getAncho()-5))
			{return true;}
		if (posY<0 || posY>(sprite.getLado()*map.getAlto()-5)) 
			{return true;}
		
		
		int ladoIzquierdo=posX/16;
		int ladoDerecho=(posX+ancho)/16;
		int ladoSuperior=posY/16;
		int ladoInferior=(posY+alto)/16;
		
		if (map.cuadrosLog[ladoIzquierdo+ladoSuperior*map.getAncho()].impactable())
		{
			map.Impacto(this, ladoIzquierdo, ladoSuperior); return true;
		}
		if (map.cuadrosLog[ladoIzquierdo+ladoInferior*map.getAncho()].impactable())
		{
			map.Impacto(this, ladoIzquierdo, ladoInferior); return true;
		}
		if (map.cuadrosLog[ladoDerecho+ladoSuperior*map.getAncho()].impactable())
		{
			map.Impacto(this, ladoDerecho, ladoSuperior);return true;
		}
		if (map.cuadrosLog[ladoDerecho+ladoInferior*map.getAncho()].impactable())
		{
			map.Impacto(this, ladoDerecho, ladoInferior);return true;
		}
		
		if(tanque==log.getJugador())
			{
				for (Tanque t: log.getTanques())
				{
				
						if(getCaja(posX,posY).intersects(t.getCaja()) && t!=tanque)
						{
							t.Impacto(this);
							return true;
						}
				}
			}
		else
		{
			for (Tanque t: log.getTanques())
			{
			
					if(getCaja(posX,posY).intersects(t.getCaja()) && t!=tanque)
					{
						if(t==log.getJugador())
							t.Impacto(this);
						return true;
					}
			}
		}
			
		return colision;
		
	}
	public synchronized void destruir()
	{
		vive=false;
		tanque.disparoFin();
		log.getGameObjets().remove(this);
		try {
			join();
		} catch (InterruptedException e) {
			
		}
		
	}
	
	public void run() 
	{

		while(vive)
		{
			mover(dirX*vel,dirY*vel);
			try {
				sleep(75);
			} catch (InterruptedException e) 
			{
				System.out.println("hola");
			}
		}
		
	}
	

	
	public boolean Collide(GameObject g) 
	{
		return false;
		
	}
	public int getAncho(){return ancho;}
	public int getAlto(){return alto;}

	public boolean destruyeAcero(){ return destruyeAcero;}
	
	
}
