package prueba.graficos;

import prueba.mapa.cuadros.Cuadro;

public class Pantalla 
{
		private final int ANCHO;
		private final int ALTO;
		// declaro puclico para tener acceso mas rapido
		public int[] pixeles;
	
		
	public Pantalla (final int an, final int al)
	{
		ANCHO=an;
		ALTO=al;
		pixeles=new int[ANCHO*ALTO];
	}
	
	public void limpiar()
	{
		for (int i=0; i<pixeles.length;i++)
			pixeles[i]=0;
	}
	

	public void mostrarCuadro(int x, int y, Cuadro cuadro)
	{
		if(cuadro==Cuadro.AGUA)
		{
			for (int j =0; j<16;j++)
				for (int i =0; i<16;i++)
				{
					if(pixeles[(x+i)+(y+j)*ANCHO]==0)
					pixeles[(x+i)+(y+j)*ANCHO]=cuadro.sprite.pixeles[i+j*16];
				}
		}
		else
			if(cuadro==Cuadro.BOSQUE)
			{
			
				for (int j =0; j<16;j++)
					for (int i =0; i<16;i++)
					{
						if(Sprite.BOSQUE.pixeles[i+j*16]!=0)
						pixeles[(x+i)+(y+j)*ANCHO]=cuadro.sprite.pixeles[i+j*16];
						
					}
				
			}
		else
		
				if(cuadro!=Cuadro.VACIO)
				{
						for (int j =0; j<16;j++)
							for (int i =0; i<16;i++)
								{
									pixeles[(x+i)+(y+j)*ANCHO]=cuadro.sprite.pixeles[i+j*16];
				}
	  }		
	}
	public void mostrarGameObject(int x, int y, Sprite sprite)
	{
		for (int j =0; j<sprite.getAlto();j++)
			for (int i =0; i<sprite.getAncho();i++)
			{
				pixeles[(x+i)+(y+j)*ANCHO]=sprite.pixeles[i+j*sprite.getAncho()];
			}
	}

	public void perder() 
	{
		
		
	}

} 
