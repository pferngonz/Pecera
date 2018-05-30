package com;

import java.util.Random;

import acm.graphics.GImage;

public class Pez extends animalmarino{
	private int X=0;
	private int Y=0;
	private int XH=0;
	private int YH=0;
	private int Vecespreñao=1;
	public int getVecespreñao() {
		return Vecespreñao;
	}
	public void setVecespreñao() {
		this.Vecespreñao=this.Vecespreñao-1;
	}
	public int getXH() {
		return XH;
	}
	public void setXH(int X) {
		this.XH=X;
	}
	public int getYH() {
		return YH;
	}
	public void setYH(int Y) {
		this.YH=Y;
	}
	private boolean Genero;
	private int Velocidad;
	public int getVelocidad() {
		return Velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.Velocidad=velocidad;
	}
	public boolean getGenero() {
		return Genero;
	}
	public void setGenero(boolean genero) {
		this.Genero=genero;
	}
	public void setX(int posiciones) {
		this.X=posiciones;
	}
	public void setY(int posiciones) {
		this.Y=posiciones;
	}
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	public void reproducirse() {
		Random random=new Random();
		int X=random.nextInt(800)+80;
		int Y=random.nextInt(400)+80;
		this.setXH(X);
		this.setYH(Y);
	}
	public void comer(String [] turnopeces, int razapez){
		if(razapez==0) {
			turnopeces[0]="X";
		}
		else if(razapez==1) {
			turnopeces[1]="X";
		}
		else if(razapez==2) {
			turnopeces[2]="X";
		}
	}
	public void mover(GImage Imagen, int heigth, int width) {
			if(this.Genero && Imagen.getX()<=width-Imagen.getWidth()+80) {
				Imagen.move(5, 0);
				this.setX(getX()+5);
			}
			else if(this.Genero && Imagen.getX()>=width-Imagen.getWidth()) {
				Imagen.setLocation(0,Imagen.getY());
			}
			if(!this.Genero && Imagen.getY()<=heigth-Imagen.getHeight()+80){
				Imagen.move(0, 5);
			}
			else if(!this.Genero && Imagen.getY()>=heigth-Imagen.getHeight()) {
				Imagen.setLocation(Imagen.getX(),0);
			}
	}
	public void posicion(int [][] posicion, int i) {
		this.X=posicion[0][i];
		this.Y=posicion[0][i];
	}
}
