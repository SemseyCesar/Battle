package prueba.mapa.cuadros;

import Logica.Disparo;
import prueba.graficos.Sprite;

public class Acero2 extends Cuadro

{
	
	public Acero2(Sprite sprite) {super(sprite);destruible=true;solido=true;}
	
	public Cuadro impacto(Disparo d)
	{
		if(d.destruyeAcero())
		return Cuadro.ACERO3;
		return this;
	}
	
}