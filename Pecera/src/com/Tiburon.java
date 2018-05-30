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
}
