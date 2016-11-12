package prueba.mapa.cuadros;

import Logica.Disparo;
import prueba.graficos.Sprite;

public class Acero1 extends Cuadro

{
	
	public Acero1(Sprite sprite) {super(sprite);destruible=true;solido=true;}
	
	public Cuadro impacto(Disparo d)
	{
		if(d.destruyeAcero())
		return Cuadro.ACERO2;
		return this;
	}
	
}