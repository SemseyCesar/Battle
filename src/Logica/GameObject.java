package Logica;

import java.awt.Rectangle;

import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;

public abstract class GameObject  extends Thread
{
	protected volatile boolean vive=true;
	
	protected Log log;
	protected Mapa map;
	protected int X;
	protected int Y;
	protected Sprite sprite;
	protected int dirX;
	protected int dirY;
	
	abstract public boolean Collide(GameObject g);
	
	public Sprite getImg(){return sprite;}
	public int getX(){return X;}
	public int getY(){return Y;}
	
	public void setImg (Sprite sprite){this.sprite=sprite;}
	
	public void setX(int x){X=x;}
	
	public void setY(int y){Y=y;}
	
	public boolean estaVivo(){return vive;	}
	
	public  Rectangle getCaja(int x, int y)
	{
		return new Rectangle (x,y,sprite.getAncho(),sprite.getAlto());
	}
	public  Rectangle getCaja()
	{
		return new Rectangle (X,Y,sprite.getAncho(),sprite.getAlto());
	}
	
	public abstract void destruir();
	
}