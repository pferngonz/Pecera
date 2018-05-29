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
			Guppy guppymacho=new Guppy(0);
			guppymacho.genero=true;
			Guppy guppyhembra=new Guppy(1);
			guppyhembra.genero=false;
			Betta bettamacho=new Betta(0);
			Betta bettahembra=new Betta(1);
			bettamacho.genero=true;
			bettahembra.genero=false;
			Tiburon tiburonmacho=new Tiburon(0);
			Tiburon tiburonhembra=new Tiburon(1);
			tiburonmacho.genero=true;
			tiburonhembra.genero=false;
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
			System.out.println(numeroguppys);
			System.out.println(numerobettas);
			System.out.println(numerotiburones);
			for (int i = 0; i < numeroguppys; i++) {
				int genero=random.nextInt(2);
				if(genero==0) {
					arrayguppyclase.add(guppymacho);
					System.out.println("guppymacho");
				}
				if(genero==1) {
					arrayguppyclase.add(guppyhembra);
					System.out.println("guppyhembra");
				}
			}
			for (int i = 0; i < numerobettas; i++) {
				int genero=random.nextInt(2);
				if(genero==0) {
					arraybettaclase.add(bettamacho);
					System.out.println("bettamacho");
				}
				if(genero==1) {
					arraybettaclase.add(bettahembra);
					System.out.println("bettahembra");
				}
			}
			for (int i = 0; i < numerotiburones; i++) {
				int genero=random.nextInt(2);
				if(genero==0) {
					arraytiburonclase.add(tiburonmacho);
					System.out.println("tiburonmacho");
				}
				if(genero==1) {
					arraytiburonclase.add(tiburonhembra);
					System.out.println("tiburonhembra");
				}
			}
			System.out.println(arrayguppy.size());
			System.out.println(arraybetta.size());
			System.out.println(arraytiburon.size());
			int [][] posicionpeces=new int[2][numeroguppys+numerobettas+numerotiburones];
			numeroigenero(guppymacho, guppyhembra, bettamacho, bettahembra, tiburonmacho, tiburonhembra, arrayguppy, arrayguppyclase, arraybetta, arraybettaclase, arraytiburon, arraytiburonclase, numeroguppys, numerobettas, numerotiburones);
			posicion(guppymacho, guppyhembra, bettamacho, bettahembra, tiburonmacho, tiburonhembra, arrayguppy, arrayguppyclase, arraybetta, arraybettaclase, arraytiburon, arraytiburonclase, numeroguppys, numerobettas, numerotiburones, posicionpeces);
			int contadorbettas=0;
			int contadortiburones=0;
			for (int i = 0; i < numeroguppys; i++) {
				add(arrayguppyclase.get(contadorbettas).getImagen(),posicionpeces[0][i],posicionpeces[1][i]);
			}
			for (int i = numeroguppys; i < numerobettas+numeroguppys; i++) {
				add(arraybettaclase.get(contadorbettas).getImagen(),posicionpeces[0][i],posicionpeces[1][i]);
				contadorbettas++;
			}
			for (int i = numeroguppys+numerobettas; i < numerobettas+numeroguppys+numerotiburones; i++) {
				add(arraytiburonclase.get(contadortiburones).getImagen(),posicionpeces[0][i],posicionpeces[1][i]);
				contadortiburones++;
			}
			for (int i = 0; i < numeroguppys; i++) {
				arrayguppyclase.get(i).setX(posicionpeces[0][i]);
				arrayguppyclase.get(i).setY(posicionpeces[1][i]);
			}
			boolean cierto=false;
			waitForClick();
			while(!cierto) {
				arrayguppyclase.get(0).mover(fondo,arrayguppyclase.get(0).getImagen());
			}
		}
		public static void numeroigenero(Guppy guppymacho, Guppy guppyhembra, Betta bettamacho, Betta bettahembra, Tiburon tiburonmacho, Tiburon tiburonhembra, ArrayList arrayguppy, ArrayList arrayguppyclase, ArrayList arraybetta, ArrayList arraybettaclase, ArrayList arraytiburon, ArrayList arraytiburonclase, int numeroguppys, int numerobettas, int numerotiburones) {
			
		}
		public static void posicion(Guppy guppymacho, Guppy guppyhembra, Betta bettamacho, Betta bettahembra, Tiburon tiburonmacho, Tiburon tiburonhembra, ArrayList arrayguppy, ArrayList arrayguppyclase, ArrayList arraybetta, ArrayList arraybettaclase, ArrayList arraytiburon, ArrayList arraytiburonclase, int numeroguppys, int numerobettas, int numerotiburones, int [][] posicionpeces) {
			Random random=new Random();
			int contadorguppys=0;
			int contadorbettas=0;
			int contadortiburones=0;
			while(contadorguppys!=numeroguppys) {
				int x=random.nextInt(800)+80;
				int y=random.nextInt(400)+80;
				int contadoriguales=0;
				System.out.println("guppy "+x+" y "+y);
				for (int i = 0; i < numeroguppys; i++) {
					if (x==posicionpeces[0][i] || x>=posicionpeces[0][i]+80 && x<=posicionpeces[0][i]-80) {
						contadoriguales++;
					}
					if (y==posicionpeces[1][i] || y>=posicionpeces[1][i]+80 && y<=posicionpeces[1][i]-80) {
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
				int x=random.nextInt(800)+80;
				int y=random.nextInt(400)+80;
				int contadoriguales=0;
				System.out.println("betta "+x+" y "+y);
				for (int i = 0; i < numerobettas+numeroguppys; i++) {
					if (x==posicionpeces[0][i] || x>=posicionpeces[0][i]+80 && x<=posicionpeces[0][i]-80) {
						contadoriguales++;
					}
					if (y==posicionpeces[1][i] || y>=posicionpeces[1][i]+80 && y<=posicionpeces[1][i]-80) {
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
				int x=random.nextInt(800)+80;
				int y=random.nextInt(400)+80;
				int contadoriguales=0;
				System.out.println("tiburon "+x+" y "+y);
				for (int i = 0; i < numerotiburones+numerobettas+numeroguppys; i++) {
					if (x==posicionpeces[0][i] && x>=posicionpeces[0][i]+80 && x<=posicionpeces[0][i]-80) {
						contadoriguales++;
					}
					if (y==posicionpeces[1][i] && y>=posicionpeces[1][i]+80 && y<=posicionpeces[1][i]-80) {
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
