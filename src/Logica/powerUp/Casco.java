package Logica.powerUp;

import Logica.GameObject;
import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;

public class Casco extends PowerUp 
{
	private int timer;
	
	public Casco(int X, int Y, Log log, Mapa map ) 
	{
		super(X, Y,log,map);
		sprite= Sprite.CASCO;
	}

	public synchronized void effecto() 
	{
		log.getJugador().invulnerable(true);
		log.getGameObjets().remove(this);
		vive=false;
		timer=0;
		
	}
	
	public void run()
	{
		super.run();
		while(timer<10 && !vive)
		{
			timer++;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.getJugador().invulnerable(false);
		fin();
		
			
	}
	
	
	
	@Override
	public boolean Collide(GameObject g) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}