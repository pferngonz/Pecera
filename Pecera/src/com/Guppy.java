package com;

import acm.graphics.GImage;

public class Guppy extends Pez {
	private GImage Imagen;
	public GImage getImagen() {
		return Imagen;
	}
	public Guppy(int genero){
		
		if(genero==0) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/pezmacho.png");
			this.Imagen.setSize(80,80);
		}
		if (genero==1) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/pezhembra.png");
			this.Imagen.setSize(80,80);

		}
	}
}