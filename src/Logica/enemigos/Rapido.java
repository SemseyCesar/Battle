package Logica.enemigos;

import Logica.GameObject;
import Logica.TanqueEnemigo;
import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;

public class Rapido extends TanqueEnemigo
{

	
	public Rapido(Mapa map,Log log,int pos)
	{
		super(map, log,pos);
		puntos=400;
		velMov=3;
		velDisp=2;
		resist=1;
		dirX=0;dirY=0;
		X=0;Y=0;
		sprite=Sprite.rapidoDOWN;
	}
	
	public boolean Collide(GameObject g) 
	{
		return false;
	
	}

	@Override
	public void setSprite(String direccion) 
	{
		
		if(direccion=="ABAJO")
			sprite=Sprite.rapidoDOWN;
		else if(direccion=="ARRIBA")
			sprite=Sprite.rapidoUP;
		else if(direccion=="DERECHA")
			sprite=Sprite.rapidoRIGHT;
		else if(direccion=="IZQUIERDA")
			sprite=Sprite.rapidoLEFT;
		
	}
}
	