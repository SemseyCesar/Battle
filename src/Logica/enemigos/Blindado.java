package Logica.enemigos;

import Logica.GameObject;
import Logica.TanqueEnemigo;
import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;

public class Blindado extends TanqueEnemigo
{

	
	public Blindado(Mapa map,Log log,int pos)
	{
		super(map, log,pos);
		puntos=400;
		velMov=1;
		velDisp=2;
		resist=4;
		dirX=0;dirY=0;
		X=0;Y=0;
		sprite=Sprite.blindadoDOWN;
	}
	
	public boolean Collide(GameObject g) 
	{
		return false;
	
	}

	@Override
	public void setSprite(String direccion) 
	{
		
		if(direccion=="ABAJO")
			sprite=Sprite.blindadoDOWN;
		else if(direccion=="ARRIBA")
			sprite=Sprite.blindadoUP;
		else if(direccion=="DERECHA")
			sprite=Sprite.blindadoRIGHT;
		else if(direccion=="IZQUIERDA")
			sprite=Sprite.blindadoLEFT;
		
	}

	
	

	
	

}
