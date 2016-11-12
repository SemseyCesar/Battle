package Logica;

import java.util.Random;

import prueba.Log;
import prueba.mapa.Mapa;

public abstract class TanqueEnemigo extends Tanque
{
	Random aleatorio=new Random();
	protected boolean puedeDisparar=true;
	protected int pos;
	protected int puntos;
	public int getPuntos(){return puntos;}	
	
	
	public TanqueEnemigo (Mapa map, Log log, int pos)
	{
		super(map,log);
		disparosVivo=0;
		this.pos=pos;
	}
	
	
	
	protected void cambioDir() 
	{
		int R= aleatorio.nextInt(4);
		if((R==0))
			{dirX=1;dirY=0;setSprite("DERECHA"); }
		else
			if(R==1)
				{dirX=-1;dirY=0; setSprite("IZQUIERDA");}
			else 
				if (R==2)
					{dirX=0;dirY=1;setSprite("ABAJO");}
				else
					{dirX=0;dirY=-1;setSprite("ARRIBA");}
		
	}
	
	public void Impacto(Disparo disparo) 
	{
		resist--;
		if (resist<1)
		{	
			this.destruir();
		}
	}

	public synchronized void destruir()
	{
		log.enemigoDestruido(puntos);
		super.destruir();
	}
	public void disparar()
	{
	if(disparosVivo<1)
	{
		
		int salidaX=X;int salidaY=Y;
		if(dirY==-1)
			{salidaX=X+6;;}//disparo arriba
			else
				if(dirY==1)
				{salidaX=X+6;salidaY=Y+15;}//disparo abajo
				else
					if(dirX==1)
					{salidaX=X+15;salidaY=Y+6;}//diparo derecha
					else
						if(dirX==-1)
						{salidaY=Y+6;}//disparo izquierda
		disparosVivo++;
		Disparo disparo= new Disparo(salidaX,salidaY,dirX,dirY,map,this,log);
		disparo.start();
		log.getGameObjets().addFirst(disparo);
	}
	
	}

	public void run() 
	{

		while(vive)
		{
			int Ran=aleatorio.nextInt(4);
			if(Ran==1)
			{
			cambioDir();
			this.disparar();
			}
			mover(dirX*2,dirY*2);
			sprite.animacion();
			try {
				sleep(150/this.getVelMov());
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
}
