package prueba.mapa;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.LinkedList;

import Logica.Disparo;
import prueba.graficos.Pantalla;
import prueba.mapa.cuadros.Cuadro;

public class Mapa 
{
	// ancho en cuadros
	private final static int  ANCHO=13;
	private final static int ALTO=12;
	private String ruta;
	public int [] cuadros= new int [ANCHO*ALTO];
	public Cuadro [] cuadrosLog= new Cuadro[ANCHO*ALTO]; 
	public Cuadro[] catalogo= new Cuadro[6];
	private LinkedList <Integer> posPowerUp= new LinkedList<Integer>() ;
	
	
	
	public Mapa(String ruta)
	{
		this.ruta=ruta;
		
		generarMapa();
		iniciarCatalogo();
		generarCuadros();
	}



	protected void generarMapa() 
	{
		
			
			try 
			{
			
			FileReader archivo = new FileReader (ruta);
			BufferedReader buffer= new BufferedReader(archivo);
			String temp="";
			int i=0;
			char c;
			while (temp!=null)
			{
				
					
				temp=buffer.readLine();
				for (int j=0; (j<ANCHO)&&(temp!=null); j++)
				{
					c=temp.charAt(j);
					cuadros[j+i*ANCHO]=c-48;
	
				}
				i++;
			}
			buffer.close();
		} catch (Exception e) {System.out.println("no se cargo mapa");	}
			
			
				
	}
			
		
	private void generarCuadros()
	{
		for (int i=0; i<cuadros.length;i++)
		{
			    int x=cuadros[i] % 6;
				cuadrosLog[i]=catalogo[x];
				if(x==0)
				{
					posPowerUp.add(i);
				}
		}
		
	}
	
	public void mostrar(Pantalla pantalla)
	{
		
			for (int j=0; j<ALTO;j++)
				for (int i=0; i<ANCHO;i++)
			{
				
				cuadrosLog[i+j*ANCHO].mostrar(i, j, pantalla);
				
			}
	}

	private void iniciarCatalogo()
	{
		catalogo[0]= Cuadro.VACIO;
		catalogo[1]= Cuadro.LADRILLO;
		catalogo[2]= Cuadro.ACERO;
		catalogo[3]= Cuadro.BOSQUE;
		catalogo[4]= Cuadro.AGUA;
		catalogo[5]=Cuadro.AGUILA;
	}
	
	public void Impacto(Disparo d,int i, int j)
	{
		cuadrosLog[i+j*ANCHO]=cuadrosLog[i+j*ANCHO].impacto(d);
	}
	
	public int getAncho(){return ANCHO;}
	public int getAlto(){return ALTO;}
	public void efectoPala()
	{
		cuadrosLog[5+11*ANCHO]=Cuadro.ACERO;
		cuadrosLog[5+10*ANCHO]=Cuadro.ACERO;		
		cuadrosLog[6+10*ANCHO]=Cuadro.ACERO;
		cuadrosLog[7+10*ANCHO]=Cuadro.ACERO;
		cuadrosLog[7+11*ANCHO]=Cuadro.ACERO;
		
	}
	public void deshacerEfectoPala()
	{
		cuadrosLog[5+11*ANCHO]=Cuadro.LADRILLO;
		cuadrosLog[5+10*ANCHO]=Cuadro.LADRILLO;		
		cuadrosLog[6+10*ANCHO]=Cuadro.LADRILLO;
		cuadrosLog[7+10*ANCHO]=Cuadro.LADRILLO;
		cuadrosLog[7+11*ANCHO]=Cuadro.LADRILLO;
		
	}
	
	public int obtenerPosPowerUp(int n)
	{
		return posPowerUp.get(n%posPowerUp.size());
	}



	public boolean aguilaViva() 
	{
		
		return cuadrosLog[149]==Cuadro.AGUILA;
	}
}
