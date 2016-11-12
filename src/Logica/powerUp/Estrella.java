package Logica.powerUp;

import Logica.GameObject;
import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;

public class Estrella extends PowerUp 
{

	
	public Estrella(int X, int Y, Log log, Mapa map ) 
	{
		super(X, Y,log,map);
		sprite= Sprite.ESTRELLA;
		vive=true;
	}

	public synchronized void effecto() 
	{
		log.getJugador().subirNivel();
		log.getGameObjets().remove(this);
		fin();
	}
	

	
	public boolean Collide(GameObject g) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
