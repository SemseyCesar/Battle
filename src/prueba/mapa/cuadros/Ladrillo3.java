package prueba.mapa.cuadros;

import Logica.Disparo;
import prueba.graficos.Sprite;

public class Ladrillo3 extends Cuadro
{

	public Ladrillo3(Sprite sprite) {super(sprite); destruible=true;solido=true;	}
	
	public Cuadro impacto(Disparo d)
	{
	
		return Cuadro.VACIO;
	}
	

	
}