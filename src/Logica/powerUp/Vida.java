package Logica.powerUp;

import Logica.GameObject;
import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;

public class Vida extends PowerUp 
{

	
	public Vida(int X, int Y, Log log, Mapa map ) 
	{
		super(X, Y,log,map);
		sprite= Sprite.VIDA;
		vive=true;
	}

	public synchronized void effecto() 
	{
		log.efectoVida();
		log.getGameObjets().remove(this);
		fin();
	}
	

	
	public boolean Collide(GameObject g) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}