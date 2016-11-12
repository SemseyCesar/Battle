package Logica.enemigos;

import Logica.GameObject;
import Logica.TanqueEnemigo;
import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;

public class Poder extends TanqueEnemigo
{

	
	public Poder(Mapa map,Log log,int pos)
	{
		super(map, log,pos);
		puntos=300;
		velMov=2;
		velDisp=3;
		resist=1;
		dirX=0;dirY=0;
		X=0;Y=0;
		sprite=Sprite.poderDOWN;
	}
	
	public boolean Collide(GameObject g) 
	{
		return false;
	}

	@Override
	public void setSprite(String direccion) 
	{
		
		if(direccion=="ABAJO")
			sprite=Sprite.poderDOWN;
		else if(direccion=="ARRIBA")
			sprite=Sprite.poderUP;
		else if(direccion=="DERECHA")
			sprite=Sprite.poderRIGHT;
		else if(direccion=="IZQUIERDA")
			sprite=Sprite.poderLEFT;
		
	}

	
	

	
	

}