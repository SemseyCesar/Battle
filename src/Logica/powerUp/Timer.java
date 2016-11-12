package Logica.powerUp;

import Logica.GameObject;
import Logica.Tanque;
import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;
@SuppressWarnings("deprecation")
public class Timer extends PowerUp 
{
	private int timer;
	
	public Timer(int X, int Y, Log log, Mapa map ) {
		super(X, Y,log,map);
		sprite= Sprite.TIMER;
	}

	
	public synchronized void effecto() 
	{
		for (Tanque t :log.getTanques())
		{
			if(t!=log.getJugador())
			t.suspend();
		}	
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
		for (Tanque t : log.getTanques())
		{
			if(t!=log.getJugador())
				t.resume();
			System.out.println("renaudo");
		}	
		fin();
		
			
	}
	
	
	
	@Override
	public boolean Collide(GameObject g) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}