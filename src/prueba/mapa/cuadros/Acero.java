package prueba.mapa.cuadros;

import Logica.Disparo;
import prueba.graficos.Sprite;

public class Acero extends Cuadro

{
	
	
	public Acero(Sprite sprite) {super(sprite);destruible=true;solido=true;}
	
	public Cuadro impacto(Disparo d)
	{
		
		if(d.destruyeAcero())
			return Cuadro.ACERO1;
			return this;
	}
	
}