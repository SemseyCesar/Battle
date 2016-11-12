package Logica.enemigos;

import Logica.GameObject;
import Logica.TanqueEnemigo;
import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;

public class Basico extends TanqueEnemigo
{

	
	public Basico(Mapa map,Log log,int pos)
	{
		super(map, log,pos);
		puntos=100;
		velMov=1;
		velDisp=1;
		resist=1;
		dirX=0;dirY=0;
		X=0;Y=0;
		sprite=Sprite.basicoDOWN;
	}
	
	public boolean Collide(GameObject g) 
	{
		return false;
	
	}

	@Override
	public void setSprite(String direccion) 
	{
		
		if(direccion=="ABAJO")
			sprite=Sprite.basicoDOWN;
		else if(direccion=="ARRIBA")
			sprite=Sprite.basicoUP;
		else if(direccion=="DERECHA")
			sprite=Sprite.basicoRIGHT;
		else if(direccion=="IZQUIERDA")
			sprite=Sprite.basicoLEFT;
		
	}
}
	