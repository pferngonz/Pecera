package com;

import acm.graphics.GImage;

public class Tiburon extends Pez{
	private GImage Imagen;
	public GImage getImagen() {
		return Imagen;
	}
	public Tiburon(int genero){
		if(genero==0) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/tiburonmacho.png");
			this.Imagen.setSize(80,80);

		}
		if (genero==1) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/tiburonhembra.png");
			this.Imagen.setSize(80,80);

		}
	}
}
