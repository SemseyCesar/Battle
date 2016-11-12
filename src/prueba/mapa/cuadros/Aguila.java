package prueba.mapa.cuadros;

import Logica.Disparo;
import prueba.graficos.Sprite;

public class Aguila extends Cuadro

{
	
	public Aguila(Sprite sprite) {super(sprite);destruible=true;solido=true;}
	
	public Cuadro impacto(Disparo d)
	{	
		
		return Cuadro.AGUILAMUERTA;
	}
	
}