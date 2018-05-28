package com;

import acm.graphics.GImage;

public class Betta extends Pez{
	private GImage Imagen;
	public GImage getImagen() {
		return Imagen;
	}
	public Betta(int genero){
		if(genero==0) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/Bettamacho.png");
			this.Imagen.setSize(80,80);

		}
		if (genero==1) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/Bettahembra.png");
			this.Imagen.setSize(80,80);

		}
	}

}
