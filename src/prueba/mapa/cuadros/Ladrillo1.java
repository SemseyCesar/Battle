package prueba.mapa.cuadros;

import Logica.Disparo;
import prueba.graficos.Sprite;

public class Ladrillo1 extends Cuadro
{

	public Ladrillo1(Sprite sprite) {super(sprite); destruible=true;solido=true;	}
	
	public Cuadro impacto(Disparo d)
	{
	
		return Cuadro.LADRILLO2;
	}
	

	
}