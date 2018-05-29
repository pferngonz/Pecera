package com;

import java.util.Random;

import acm.graphics.GImage;

public class Betta extends Pez{
	private GImage Imagen;
	public GImage getImagen() {
		return Imagen;
	}
	public Betta(int genero){
		Random random=new Random();
		int genero2=random.nextInt(2);
		if(genero2==0) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/Bettamacho.png");
			this.Imagen.setSize(80,80);

		}
		if (genero2==1) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/Bettahembra.png");
			this.Imagen.setSize(80,80);

		}
	}

}
