package Logica.nivel;

import prueba.graficos.Sprite;

public class Nivel4 extends Nivel 
{

	public Nivel4()
	{
		resist=4;
		velMov=2;
		velDisp=3;
		dispSim=3;
		
	}
	public Sprite sprite(String direccion) 
	{
		
		if(direccion=="ABAJO")
			return Sprite.jugadorDOWN4;
		else if(direccion=="ARRIBA")
			return Sprite.jugadorUP4;
		else if(direccion=="DERECHA")
			return Sprite.jugadorRIGHT4;
		else if(direccion=="IZQUIERDA")
			return Sprite.jugadorLEFT4;
		
		return Sprite.VACIO;
	}

	public Nivel subirNivel() 
	{
		return this;	
	}
	public boolean destruyeAcero(){return true;}
}
