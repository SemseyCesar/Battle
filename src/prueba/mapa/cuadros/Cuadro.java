package prueba.mapa.cuadros;

import Logica.Disparo;
import prueba.graficos.Pantalla;
import prueba.graficos.Sprite;

public abstract class Cuadro 
{

	protected int x;
	protected int y;
	protected boolean solido;
	public Sprite sprite;
	protected boolean destruible;
	public boolean impactable;
	
	//coleccion temporal cuadros
	public static final Cuadro ACERO= new Acero(Sprite.ACERO);
	public static final Cuadro BOSQUE= new Bosque(Sprite.BOSQUE);
	public static final Cuadro AGUA= new Agua(Sprite.AGUA);
	public static final Cuadro LADRILLO= new Ladrillo(Sprite.LADRILLO);
	public static final Cuadro VACIO= new Vacio(Sprite.VACIO);
	public static final Cuadro LADRILLO1= new Ladrillo1(Sprite.LADRILLO1);
	public static final Cuadro LADRILLO2= new Ladrillo2(Sprite.LADRILLO2);
	public static final Cuadro LADRILLO3= new Ladrillo3(Sprite.LADRILLO3);
	public static final Cuadro ACERO1= new Acero1(Sprite.ACERO1);
	public static final Cuadro ACERO2= new Acero2(Sprite.ACERO2);
	public static final Cuadro ACERO3= new Acero3(Sprite.ACERO3);
	public static final Cuadro AGUILA= new Aguila(Sprite.AGUILA);
	public static final Cuadro AGUILAMUERTA= new AguilaMuerta(Sprite.AGUILAMUERTA);
	
	
	public  Cuadro(Sprite sprite)
	{
		this.sprite=sprite;
		destruible=false;
		solido=false;
		impactable=true;
	}
	public  Cuadro(Sprite sprite,boolean sol)
	{
		this.sprite=sprite;
		destruible=false;
		solido=sol;
		impactable=true;
	}
	
	public void mostrar(int x,int y, Pantalla pantalla)
	{
		pantalla.mostrarCuadro(x*16,y*16,this);
		
	}
	
	public boolean solido(){return solido;}
	
	//sprint 3
	public boolean esDestruible(){return destruible;}
	
	public Cuadro impacto(Disparo d)
	{
	
		return this;
	}
	
	public boolean impactable(){ return impactable;}
}
