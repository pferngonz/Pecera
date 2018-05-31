package com;

import java.util.Random;

import acm.graphics.GImage;

public class Betta extends Pez{
	private GImage Imagen;
	public GImage getImagen() {
		return Imagen;
	}
	
	public Betta(int genero){
		if(genero==Genero.MACHO.getGenerovalor()) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/Bettamacho.png");
			this.Imagen.setSize(80,80);
			this.setGenero(true);

		}
		if (genero==Genero.HEMBRA.getGenerovalor()) {
			this.Imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/Bettahembra.png");
			this.Imagen.setSize(80,80);
			this.setGenero(false);


		}
	}

}
