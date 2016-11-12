package prueba.mapa.cuadros;

import Logica.Disparo;
import prueba.graficos.Sprite;

public class Ladrillo2 extends Cuadro
{

	public Ladrillo2(Sprite sprite) {super(sprite); destruible=true;solido=true;	}
	
	public Cuadro impacto(Disparo d)
	{
	
		return Cuadro.LADRILLO3;
	}
	

	
}