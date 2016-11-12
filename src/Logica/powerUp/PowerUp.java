package Logica.powerUp;

import Logica.GameObject;
import prueba.Log;
import prueba.mapa.Mapa;

public abstract class PowerUp extends GameObject
{	
	
	protected PowerUp(int X, int Y,Log log , Mapa map)
	{
		this.X=X;
		this.Y=Y;
		this.log=log;
		this.map=map;
		this.start();
		vive=true;
	}
	public abstract void effecto();
	
	protected void fin()
	{
		vive=false;
		try {
			join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void destruir()
	{	
		log.getGameObjets().remove(this);
		fin();	
	}
	public void run()
	{
		while (vive)
		{
			sprite.animacion();
			if(this.getCaja().intersects(log.getJugador().getCaja()))
				this.effecto();
			try {
				sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}
