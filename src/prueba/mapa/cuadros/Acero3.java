package prueba.mapa.cuadros;

import Logica.Disparo;
import prueba.graficos.Sprite;

public class Acero3 extends Cuadro

{
	
	public Acero3(Sprite sprite) {super(sprite);destruible=true;solido=true;}
	
	public Cuadro impacto(Disparo d)
	{
		if(d.destruyeAcero())
		return Cuadro.VACIO;
		return this;
	}
	
}