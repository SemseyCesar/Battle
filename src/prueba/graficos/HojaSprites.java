package prueba.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites 
{
	private final int ANCHO=400;
	private final int ALTO=256;
	public int pixeles[]=new int [ANCHO*ALTO];
	//Hoja principal
	public static HojaSprites hoja =new HojaSprites("/Hoja.png");
	
	public HojaSprites(String ruta) 
	{
		BufferedImage hoja;
	
		try {
			hoja=ImageIO.read(getClass().getResource(ruta));
			hoja.getRGB(0, 0, ANCHO, ALTO, pixeles, 0, ANCHO);
		} catch (IOException e) {System.out.println("hoja no cargada");}
		
		
		
	}
	public int getAncho(){return ANCHO;}
}
