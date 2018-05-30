package com;

import acm.graphics.GImage;

public class Pez extends animalmarino{
	private int X=0;
	private int Y=0;
	private boolean Genero;
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
		
	}
	public void comer(){
		
	}
	public void mover(GImage Imagen) {
		if(this.Genero) {
			Imagen.move(5, 0);
			this.setX(getX()+5);
		}
		else {
			Imagen.move(0, 5);
		}
	
	}
	public void posicion(int [][] posicion, int i) {
		this.X=posicion[0][i];
		this.Y=posicion[0][i];
	}
}
