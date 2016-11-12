package Logica.nivel;

import prueba.graficos.Sprite;

public abstract class Nivel 
{
	int resist;
	int velMov;
	int velDisp;
	int dispSim;
	public abstract Nivel subirNivel();
	public abstract Sprite sprite(String direccion);
	public int getResistencia(){return resist;}
	public int getVelMov(){return velMov;}
	public int getVelDisp(){return velDisp;}
	public int getDispSim(){return dispSim;}
	public boolean destruyeAcero(){return false;}
}