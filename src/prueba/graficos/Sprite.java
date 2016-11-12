package prueba.graficos;

public class Sprite 
{
	private final int LADO=16;
	private int x,y;
	private int ancho;
	private int alto;
	private int col;
	private int fila;
	private int animacion=0;
	private HojaSprites hs=HojaSprites.hoja;
	public int pixeles[];
	
	// coleccion sprite de mapa
	public static Sprite LADRILLO= new Sprite(16,0,HojaSprites.hoja);
	public static Sprite LADRILLO1= new Sprite(17,0,HojaSprites.hoja);
	public static Sprite LADRILLO2= new Sprite(18,0,HojaSprites.hoja);
	public static Sprite LADRILLO3= new Sprite(19,0,HojaSprites.hoja);
	public static Sprite BOSQUE= new Sprite(17,2,HojaSprites.hoja);
	public static Sprite ACERO= new Sprite(16,1,HojaSprites.hoja);
	public static Sprite ACERO1= new Sprite(17,1,HojaSprites.hoja);
	public static Sprite ACERO2= new Sprite(18,1,HojaSprites.hoja);
	public static Sprite ACERO3= new Sprite(19,1,HojaSprites.hoja);
	public static Sprite AGUA= new Sprite(16,2,HojaSprites.hoja);
	public static Sprite AGUILA= new Sprite(19,2,HojaSprites.hoja);
	public static Sprite AGUILAMUERTA= new Sprite(20,2,HojaSprites.hoja);
	public static Sprite VACIO= new Sprite(16,11,HojaSprites.hoja);
	
	// coleccion sprite de jugador
	//nivel 1
	public static final Sprite jugadorUP1= new Sprite(0,0,HojaSprites.hoja);
	public static final Sprite jugadorDOWN1= new Sprite(4,0,HojaSprites.hoja);
	public static final Sprite jugadorRIGHT1= new Sprite(6,0,HojaSprites.hoja);
	public static final Sprite jugadorLEFT1= new Sprite(2,0,HojaSprites.hoja);
	//nivel 2
	public static final Sprite jugadorUP2= new Sprite(0,1,HojaSprites.hoja);
	public static final Sprite jugadorDOWN2= new Sprite(4,1,HojaSprites.hoja);
	public static final Sprite jugadorRIGHT2= new Sprite(6,1,HojaSprites.hoja);
	public static final Sprite jugadorLEFT2= new Sprite(2,1,HojaSprites.hoja);
	//nivel 3
	public static final Sprite jugadorUP3= new Sprite(0,2,HojaSprites.hoja);
	public static final Sprite jugadorDOWN3= new Sprite(4,2,HojaSprites.hoja);
	public static final Sprite jugadorRIGHT3= new Sprite(6,2,HojaSprites.hoja);
	public static final Sprite jugadorLEFT3= new Sprite(2,2,HojaSprites.hoja);
	//nivel 4
	public static final Sprite jugadorUP4= new Sprite(0,3,HojaSprites.hoja);
	public static final Sprite jugadorDOWN4= new Sprite(4,3,HojaSprites.hoja);
	public static final Sprite jugadorRIGHT4= new Sprite(6,3,HojaSprites.hoja);
	public static final Sprite jugadorLEFT4= new Sprite(2,3,HojaSprites.hoja);
	
	
	//coleccion Enemigos
	//blindado
	public static final Sprite blindadoUP=new Sprite(0,15,HojaSprites.hoja);
	public static final Sprite blindadoDOWN=new Sprite(4,15,HojaSprites.hoja);
	public static final Sprite blindadoLEFT=new Sprite(2,15,HojaSprites.hoja);
	public static final Sprite blindadoRIGHT=new Sprite(6,15,HojaSprites.hoja);
	//poder
	public static final Sprite poderUP=new Sprite(8,6,HojaSprites.hoja);
	public static final Sprite poderDOWN=new Sprite(12,6,HojaSprites.hoja);
	public static final Sprite poderLEFT=new Sprite(10,6,HojaSprites.hoja);
	public static final Sprite poderRIGHT=new Sprite(14,6,HojaSprites.hoja);
	//rapido
	public static final Sprite rapidoUP=new Sprite(8,5,HojaSprites.hoja);
	public static final Sprite rapidoDOWN=new Sprite(12,5,HojaSprites.hoja);
	public static final Sprite rapidoLEFT=new Sprite(10,5,HojaSprites.hoja);
	public static final Sprite rapidoRIGHT=new Sprite(14,5,HojaSprites.hoja);
	//basico
	public static final Sprite basicoUP=new Sprite(8,4,HojaSprites.hoja);
	public static final Sprite basicoDOWN=new Sprite(12,4,HojaSprites.hoja);
	public static final Sprite basicoLEFT=new Sprite(10,4,HojaSprites.hoja);
	public static final Sprite basicoRIGHT=new Sprite(14,4,HojaSprites.hoja);
	
	
	//coleccion disparos
	public static final Sprite disparoUP=new Sprite(20*16+3,6*16+6,HojaSprites.hoja,3,4);
	public static final Sprite disparoDOWN=new Sprite(21*16+3,6*16+6,HojaSprites.hoja,3,4);
	public static final Sprite disparoRIGHT=new Sprite(21*16+10,6*16+6,HojaSprites.hoja,4,3);
	public static final Sprite disparoLEFT=new Sprite(20*16+10,6*16+6,HojaSprites.hoja,4,3);
	
	//coleccion PowerUP
	public static final Sprite ESTRELLA=new Sprite(16,13,HojaSprites.hoja);
	public static final Sprite PALA=new Sprite(16,12,HojaSprites.hoja);
	public static final Sprite GRANADA=new Sprite(16,14,HojaSprites.hoja);
	public static final Sprite CASCO=new Sprite(16,10,HojaSprites.hoja);
	public static final Sprite TIMER=new Sprite(16,11,HojaSprites.hoja);
	public static final Sprite VIDA=new Sprite(16,15,HojaSprites.hoja);
	
	//sprite efectosh
	public static final Sprite PERDER=new Sprite(18*16,11*16+8,HojaSprites.hoja,32,16);
	public static final Sprite GANAR=new Sprite(18*16,12*16+8,HojaSprites.hoja,32,9);
	public Sprite (int col, int fila, HojaSprites hs)
	{
		pixeles=new int [LADO*LADO];
		ancho=LADO;
		alto=LADO;
		this.col=col;
		this.fila=fila;
		x=col*LADO;
		y=fila*LADO;
		
		for(int j=0; j<LADO;j++)
			for(int i=0;i<LADO; i++)
			{
				pixeles[i+j*LADO]=hs.pixeles[(i+x)+(j+y)*hs.getAncho()];
				
			}
	
	}
	public Sprite(int x, int y, HojaSprites hs, int ancho, int alto)
	{
		pixeles=new int [ancho*alto];
		this.ancho=ancho;
		this.alto=alto;
		for(int j=0; j<alto;j++)
			for(int i=0;i<ancho; i++)
			{
				pixeles[i+j*ancho]=hs.pixeles[(i+x)+(j+y)*hs.getAncho()];
				
			}
	}
	
	public void  animacion()
	{
		animacion ++;
		animacion=animacion%2;
		int c=col+animacion;
		x=c*LADO;
		y=fila*LADO;
		
		for(int j=0; j<LADO;j++)
			for(int i=0;i<LADO; i++)
			{		
				pixeles[i+j*LADO]=hs.pixeles[(i+x)+(j+y)*hs.getAncho()];
			}
	}
	public void  animacionInvulnerable()
	{
		animacion ++;
		animacion=animacion%2;
		int c=col+animacion;
		x=(c+8)*LADO;
		y=(fila+8)*LADO;
		
		for(int j=0; j<LADO;j++)
			for(int i=0;i<LADO; i++)
			{		
				pixeles[i+j*LADO]=hs.pixeles[(i+x)+(j+y)*hs.getAncho()];
			}
	}
	
	
	public int getLado(){return LADO;}
	public int getAncho(){return ancho;}
	public int getAlto(){return alto;}
}