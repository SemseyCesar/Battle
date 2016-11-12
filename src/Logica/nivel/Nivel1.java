package Logica.nivel;

import prueba.graficos.Sprite;

public class Nivel1 extends Nivel
{
	public Nivel1()
	{
		resist=1;
		velMov=2;
		velDisp=1;
		dispSim=1;
		
	}

	public Nivel subirNivel() 
	{
		return new Nivel2();	
	}

	public Sprite sprite(String direccion) 
	{
		
		if(direccion=="ABAJO")
			return Sprite.jugadorDOWN1;
		else if(direccion=="ARRIBA")
			return Sprite.jugadorUP1;
		else if(direccion=="DERECHA")
			return Sprite.jugadorRIGHT1;
		else if(direccion=="IZQUIERDA")
			return Sprite.jugadorLEFT1;
		
		return Sprite.VACIO;
	}


}
