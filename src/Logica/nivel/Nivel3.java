package Logica.nivel;

import prueba.graficos.Sprite;

public class Nivel3 extends Nivel {

	public Nivel3()
	{
		resist=2;
		velMov=2;
		velDisp=2;
		dispSim=2;
		
	}
	public Sprite sprite(String direccion) 
	{
		
		if(direccion=="ABAJO")
			return Sprite.jugadorDOWN3;
		else if(direccion=="ARRIBA")
			return Sprite.jugadorUP3;
		else if(direccion=="DERECHA")
			return Sprite.jugadorRIGHT3;
		else if(direccion=="IZQUIERDA")
			return Sprite.jugadorLEFT3;
		
		return Sprite.VACIO;
	}

	public Nivel subirNivel() 
	{
		return new Nivel4();	
	}
}
