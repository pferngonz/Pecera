package com;

import java.util.ArrayList;
import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;

public class Main {
	public static void main(String[] args) {
		new App().start(args);
	}
	public static class App extends GraphicsProgram{
		@Override
		public void run() {
			GImage fondo=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/fondo.gif");
			setSize(1280,720);
			fondo.setSize(1280,720);
			add(fondo, 0, 0);
			Guppy guppymacho=new Guppy();
			guppymacho.genero=true;
			guppymacho.imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/pezmacho.png");
			Guppy guppyhembra=new Guppy();
			guppyhembra.genero=false;
			guppyhembra.imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/pezhembra.png");
			Betta bettamacho=new Betta();
			Betta bettahembra=new Betta();
			bettamacho.genero=true;
			bettamacho.imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/Bettamacho.png");
			bettahembra.genero=false;
			bettahembra.imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/Bettahembra.png");
			Tiburon tiburonmacho=new Tiburon();
			Tiburon tiburonhembra=new Tiburon();
			tiburonmacho.genero=true;
			tiburonmacho.imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/tiburonmacho.png");
			tiburonhembra.genero=false;
			tiburonhembra.imagen=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/tiburonhembra.png");
			guppymacho.imagen.setSize(80,80);
			guppyhembra.imagen.setSize(80,80);
			bettamacho.imagen.setSize(80,80);
			bettahembra.imagen.setSize(80,80);
			tiburonmacho.imagen.setSize(80,80);
			tiburonhembra.imagen.setSize(80,80);
			ArrayList<GImage> arrayguppy=new ArrayList<GImage>();
			ArrayList<Guppy> arrayguppyclase=new ArrayList<Guppy>();
			ArrayList<GImage> arraybetta=new ArrayList<GImage>();
			ArrayList<Betta> arraybettaclase=new ArrayList<Betta>();
			ArrayList<GImage> arraytiburon=new ArrayList<GImage>();
			ArrayList<Tiburon> arraytiburonclase=new ArrayList<Tiburon>();
			Random random=new Random();
			int numeroguppys=random.nextInt(7)+1;
			int numerobettas=random.nextInt(3)+1;
			int numerotiburones=random.nextInt(1)+1;
			int [][] posicionpeces=new int[2][numeroguppys+numerobettas+numerotiburones];
			numeroigenero(guppymacho, guppyhembra, bettamacho, bettahembra, tiburonmacho, tiburonhembra, arrayguppy, arrayguppyclase, arraybetta, arraybettaclase, arraytiburon, arraytiburonclase, numeroguppys, numerobettas, numerotiburones);
			posicion(guppymacho, guppyhembra, bettamacho, bettahembra, tiburonmacho, tiburonhembra, arrayguppy, arrayguppyclase, arraybetta, arraybettaclase, arraytiburon, arraytiburonclase, numeroguppys, numerobettas, numerotiburones, posicionpeces);
			for (int i = 0; i < numeroguppys; i++) {
				add(arrayguppy.get(i),posicionpeces[0][i],posicionpeces[1][i]);
			}
			int contadorbettas=0;
			int contadortiburones=0;
			for (int i = numeroguppys; i < numerobettas+numeroguppys; i++) {
				add(arraybetta.get(contadorbettas),posicionpeces[0][i],posicionpeces[1][i]);
				contadorbettas++;
			}
			for (int i = numeroguppys+numerobettas; i < numerobettas+numeroguppys+numerotiburones; i++) {
				add(arraytiburon.get(contadortiburones),posicionpeces[0][i],posicionpeces[1][i]);
				contadortiburones++;
			}
		}
		public static void numeroigenero(Guppy guppymacho, Guppy guppyhembra, Betta bettamacho, Betta bettahembra, Tiburon tiburonmacho, Tiburon tiburonhembra, ArrayList arrayguppy, ArrayList arrayguppyclase, ArrayList arraybetta, ArrayList arraybettaclase, ArrayList arraytiburon, ArrayList arraytiburonclase, int numeroguppys, int numerobettas, int numerotiburones) {
			Random random=new Random();
			System.out.println(numeroguppys);
			System.out.println(numerobettas);
			System.out.println(numerotiburones);
			for (int i = 0; i < numeroguppys; i++) {
				int genero=random.nextInt(2);
				if(genero==0) {
					arrayguppy.add(guppymacho.imagen);
					arrayguppyclase.add(guppymacho);
					System.out.println("guppymacho");
				}
				if(genero==1) {
					arrayguppy.add(guppyhembra.imagen);
					arrayguppyclase.add(guppyhembra);
					System.out.println("guppyhembra");
				}
			}
			for (int i = 0; i < numerobettas; i++) {
				int genero=random.nextInt(2);
				if(genero==0) {
					arraybetta.add(bettamacho.imagen);
					arraybettaclase.add(bettamacho);
					System.out.println("bettamacho");
				}
				if(genero==1) {
					arraybetta.add(bettahembra.imagen);
					arraybettaclase.add(bettahembra);
					System.out.println("bettahembra");
				}
			}
			for (int i = 0; i < numerotiburones; i++) {
				int genero=random.nextInt(2);
				if(genero==0) {
					arraytiburon.add(tiburonmacho.imagen);
					arraytiburonclase.add(tiburonmacho);
					System.out.println("tiburonmacho");
				}
				if(genero==1) {
					arraybetta.add(tiburonhembra.imagen);
					arraybettaclase.add(tiburonhembra);
					System.out.println("tiburonhembra");
				}
			}
		}
		public static void posicion(Guppy guppymacho, Guppy guppyhembra, Betta bettamacho, Betta bettahembra, Tiburon tiburonmacho, Tiburon tiburonhembra, ArrayList arrayguppy, ArrayList arrayguppyclase, ArrayList arraybetta, ArrayList arraybettaclase, ArrayList arraytiburon, ArrayList arraytiburonclase, int numeroguppys, int numerobettas, int numerotiburones, int [][] posicionpeces) {
			Random random=new Random();
			int contadorguppys=0;
			int contadorbettas=0;
			int contadortiburones=0;
			while(contadorguppys!=numeroguppys) {
				int x=random.nextInt(1100)+80;
				int y=random.nextInt(600)+80;
				int contadoriguales=0;
				System.out.println("guppy "+x+" y "+y);
				for (int i = 0; i < numeroguppys; i++) {
					if (x==posicionpeces[0][i]) {
						contadoriguales++;
					}
					if (y==posicionpeces[1][i]) {
						contadoriguales++;
					}
				}
				if (contadoriguales==0) {
					posicionpeces[0][contadorguppys]=x;
					posicionpeces[1][contadorguppys]=y;
					contadorguppys++;
				}
			}
			while(contadorbettas!=numerobettas) {
				int x=random.nextInt(1100)+80;
				int y=random.nextInt(600)+80;
				int contadoriguales=0;
				System.out.println("betta "+x+" y "+y);
				for (int i = 0; i < numerobettas+numeroguppys; i++) {
					if (x==posicionpeces[0][i]) {
						contadoriguales++;
					}
					if (y==posicionpeces[1][i]) {
						contadoriguales++;
					}
				}
				if (contadoriguales==0) {
					posicionpeces[0][contadorbettas+contadorguppys]=x;
					posicionpeces[1][contadorbettas+contadorguppys]=y;
					contadorbettas++;
				}
			}
			while(contadortiburones!=numerotiburones) {
				int x=random.nextInt(1100)+80;
				int y=random.nextInt(600)+80;
				int contadoriguales=0;
				System.out.println("tiburon "+x+" y "+y);
				for (int i = 0; i < numerotiburones+numerobettas+numeroguppys; i++) {
					if (x==posicionpeces[0][i]) {
						contadoriguales++;
					}
					if (y==posicionpeces[1][i]) {
						contadoriguales++;
					}
				}
				if (contadoriguales==0) {
					posicionpeces[0][contadorbettas+contadorguppys+contadortiburones]=x;
					posicionpeces[1][contadorbettas+contadorguppys+contadortiburones]=y;
					contadortiburones++;
				}
			}
		}
	}
}
