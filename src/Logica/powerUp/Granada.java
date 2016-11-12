package Logica.powerUp;

import java.util.LinkedList;

import Logica.GameObject;
import Logica.Tanque;
import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;

public class Granada extends PowerUp 
{

	
	public Granada(int X, int Y, Log log, Mapa map) 
	{
		super(X, Y, log, map);
		sprite=Sprite.GRANADA;
	}

	public synchronized void effecto() 
	{
		LinkedList <Tanque> tanques= new LinkedList<Tanque>();
		
		for(Tanque t : log.getTanques())
		{
			if (t!=log.getJugador())
				tanques.add(t);
		}
		for(Tanque t : tanques)
		{
				t.destruir();
				
		}
		log.getGameObjets().remove(this);
		fin();
	}


	public boolean Collide(GameObject g) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
