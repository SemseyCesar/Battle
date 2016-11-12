package Logica.nivel;

import prueba.graficos.Sprite;

public class Nivel2 extends Nivel {

	public Nivel2()
	{
		resist=1;
		velMov=4;
		velDisp=2;
		dispSim=1;
		
	}

	public Nivel subirNivel() 
	{
		return new Nivel3();	
	}
	public Sprite sprite(String direccion) 
	{
		
		if(direccion=="ABAJO")
			return Sprite.jugadorDOWN2;
		else if(direccion=="ARRIBA")
			return Sprite.jugadorUP2;
		else if(direccion=="DERECHA")
			return Sprite.jugadorRIGHT2;
		else if(direccion=="IZQUIERDA")
			return Sprite.jugadorLEFT2;
		
		return Sprite.VACIO;
	}

}
