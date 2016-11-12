package Logica;

import prueba.Log;
import prueba.mapa.Mapa;

public abstract class Tanque extends GameObject
{
	
	protected int resist;
	protected int velMov;
	protected int velDisp;
	protected int disparosVivo;

	public int getResist(){return resist;}
	public int getVelMov(){return velMov;}
	public int getVelDisp(){return velDisp;}
	public void setResist(int r){resist=r;}
	public abstract void setSprite(String direccion);
	public abstract void disparar();
	protected Tanque (Mapa map, Log log)
	{
		this.map=map;
		this.log=log;
	}
	
	public synchronized void mover(int x, int y)
	{
		if(!enColision(x,0))
			this.setX(this.getX()+x);
	
		if(!enColision(0,y))
			this.setY(this.getY()+y);
		
	}
	private synchronized boolean enColision(int x, int y) 
	{
		boolean colision=false;
		
		
		int posX=X+x;
		int posY=Y+y;
		if (posX<0 || posX>(sprite.getLado()* (map.getAncho()-1)))
			return true;
		if (posY<0 || posY>(sprite.getLado()*(map.getAlto()-1))) 
			return true;
		
		
		int ladoIzquierdo=(posX)/16;
		int ladoDerecho=(posX+15)/16;
		int ladoSuperior=(posY)/16;
		int ladoInferior=(posY+15)/16;
		
		if (map.cuadrosLog[ladoIzquierdo+ladoSuperior*map.getAncho()].solido())
		{
			colision=true;
		}
		if (map.cuadrosLog[ladoIzquierdo+ladoInferior*map.getAncho()].solido())
		{
			colision=true;
		}
		if (map.cuadrosLog[ladoDerecho+ladoSuperior*map.getAncho()].solido())
		{
			colision=true;
		}
		if (map.cuadrosLog[ladoDerecho+ladoInferior*map.getAncho()].solido())
		{
			colision=true;
		}
			
		for (GameObject t: log.getTanques())
		{
				
			if(getCaja(posX,posY).intersects(t.getCaja()) && t!=this)
				return true;
			
		}
			
			
		
		return colision;
		
	}
	
	public boolean Collide(GameObject g)
	{
		return false;	
	}
	
	public abstract void Impacto(Disparo disparo);
	
	@SuppressWarnings("deprecation")
	public synchronized void destruir()
	{
		vive=false;
		log.getGameObjets().remove(this);
		log.getTanques().remove(this);
		stop();

	}
	public void disparoFin() 
	{
		
		disparosVivo--;
		
	}
	
	

}