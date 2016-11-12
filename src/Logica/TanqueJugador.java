package Logica;

import Logica.nivel.*;
import prueba.Log;
import prueba.graficos.Sprite;
import prueba.mapa.Mapa;

public class TanqueJugador extends Tanque
{
	protected Nivel nivel;
	protected int canionX;
	protected int canionY;
	protected boolean invulnerable;
	
	public void setDirX(int x){dirX=x;canionX=x;}
	public void setDirY(int y){dirY=y;canionY=y;}
	public int getDirX(){return dirX;}
	public int getDirY(){return dirY;}
	public TanqueJugador(Mapa map, Log log)
	{
		super(map,log);
		X=16*4;
		Y=16*11;
		nivel= new Nivel1();
		sprite=Sprite.jugadorUP1;
		velMov=1;
		canionX=0;
		canionY=-1;
		disparosVivo=0;
		resist=1;
		invulnerable=false;
	}

	public int getDispSim() {return nivel.getDispSim();}
	public int getResist(){return nivel.getResistencia();}
	public int getVelMov(){return nivel.getVelMov();}
	public int getVelDisp(){return nivel.getVelDisp();}
	public void subirNivel()
	{
		nivel=nivel.subirNivel();
		resist=nivel.getResistencia();
	}
	public void setSprite(String direccion)
	{
		sprite=nivel.sprite(direccion);
	}
	
	
	public void disparar()
	{
	if(disparosVivo<getDispSim())
	{
		int salidaX=X;int salidaY=Y;
		if(canionY==-1)
			{salidaX=X+6;;}//disparo arriba
			else
				if(canionY==1)
				{salidaX=X+6;salidaY=Y+15;}//disparo abajo
				else
					if(canionX==1)
					{salidaX=X+15;salidaY=Y+6;}//diparo derecha
					else
						if(canionX==-1)
						{salidaY=Y+6;}//disparo izquierda
		disparosVivo++;
		Disparo disparo= new Disparo(salidaX,salidaY,canionX,canionY,map,this,log,nivel.destruyeAcero());
		disparo.start();
		log.getGameObjets().addFirst(disparo);
	}
	
	}
	
	public void Impacto(Disparo disparo) 
	{
		if(!invulnerable)
		{	
		resist--;
		
		if (resist<1)
		{
			log.jugadorDestruido();
			this.destruir();
		}
		}
	}
	
	public void invulnerable(boolean b)
	{
		invulnerable=b;
	}
	


	public void run() 
	{
		
		while(vive)
		{
		
			mover(dirX*2,dirY*2);
			if(invulnerable)
				sprite.animacionInvulnerable();
			else
				sprite.animacion();
			
			dirX=0;dirY=0;
			try {
				sleep(150/this.getVelMov());
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}