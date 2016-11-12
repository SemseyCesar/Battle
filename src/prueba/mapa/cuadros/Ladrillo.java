package prueba.mapa.cuadros;

import Logica.Disparo;
import prueba.graficos.Sprite;

public class Ladrillo extends Cuadro
{

	public Ladrillo(Sprite sprite) {super(sprite); destruible=true;solido=true;	}
	
	public Cuadro impacto(Disparo d)
	{
	
		return Cuadro.LADRILLO1;
	}
	

	
}
