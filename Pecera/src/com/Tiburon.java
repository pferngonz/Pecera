package com;

import java.util.Random;

import acm.graphics.GImage;

public class Tiburon extends Pez{
	private GImage Imagen;
	private boolean Genero;
	public boolean getGenero() {
		return Genero;
	}
	public GImage getImagen() {
		return Imagen;
	}
	public Tiburon(){
		Random random=new Random();
		int genero=random.nextInt(2);
		if(genero==0) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/tiburonmacho.png");
			this.Imagen.setSize(80,80);
			this.Genero=true;

		}
		if (genero==1) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/tiburonhembra.png");
			this.Imagen.setSize(80,80);
			this.Genero=false;

		}
	}
	@Override
	public void mover(GImage Imagen, int heigth, int width) {
		Random random=new Random();
		int movimento=random.nextInt(2);
		if(movimento==0  && Imagen.getX()<=width-Imagen.getWidth()+80) {
				Imagen.move(30, 0);
				this.setX(getX()+30);
			}
			else if(movimento==0 && Imagen.getX()>=width-Imagen.getWidth()) {
				Imagen.setLocation(0,Imagen.getY());
			}
			if(movimento==1 && Imagen.getY()<=heigth-Imagen.getHeight()+80){
				Imagen.move(0, 30);
				this.setY(getY()+30);
			}
			else if(movimento==1 &&Imagen.getY()>=heigth-Imagen.getHeight()) {
				Imagen.setLocation(Imagen.getX(),0);
			}
	}
	
}
