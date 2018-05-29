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
			ArrayList<Guppy> arrayguppy=new ArrayList<Guppy>();
			ArrayList<Betta> arraybetta=new ArrayList<Betta>();
			arrayguppy.add(guppymacho);
			arrayguppy.add(guppyhembra);
			arraybetta.add(bettamacho);
			arraybetta.add(bettahembra);
			Tiburon tiburon=new Tiburon();
			System.out.println(arrayguppy.size());
			System.out.println(arraybetta.size());
			int [][] posicionpeces=new int[2][5];
			posicion(guppymacho, guppyhembra, bettamacho, bettahembra, tiburon, arrayguppy,  arraybetta, posicionpeces);
			int contadorbettas=0;
			for (int i = 0; i < arrayguppy.size(); i++) {
				add(arrayguppy.get(i).getImagen(),posicionpeces[0][i],posicionpeces[1][i]);
				arrayguppy.get(i).setX(posicionpeces[0][i]);
				arrayguppy.get(i).setY(posicionpeces[1][i]);
			}
			for (int i = arrayguppy.size(); i < arrayguppy.size()+arraybetta.size(); i++) {
				add(arraybetta.get(contadorbettas).getImagen(),posicionpeces[0][i],posicionpeces[1][i]);
				arraybetta.get(contadorbettas).setX(posicionpeces[0][i]);
				arraybetta.get(contadorbettas).setY(posicionpeces[1][i]);
				contadorbettas++;
			}
			for (int i = arrayguppy.size()+arraybetta.size(); i < arrayguppy.size()+arraybetta.size()+1; i++) {
				add(tiburon.getImagen(),posicionpeces[0][i],posicionpeces[1][i]);
				tiburon.setX(posicionpeces[0][i]);
				tiburon.setY(posicionpeces[1][i]);
			}
			boolean cierto=false;
			waitForClick();
		}
		public static void posicion(Guppy guppymacho, Guppy guppyhembra, Betta bettamacho, Betta bettahembra, Tiburon tiburon, ArrayList arrayguppy, ArrayList arraybetta , int [][] posicionpeces) {
			Random random=new Random();
			int contadorguppys=0;
			int contadorbettas=0;
			int contadortiburones=0;
			while(contadorguppys!=2) {
				int x=random.nextInt(800)+80;
				int y=random.nextInt(400)+80;
				int contadoriguales=0;
				System.out.println("guppy "+x+" y "+y);
				for (int i = 0; i < 2; i++) {
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
			while(contadorbettas!=2) {
				int x=random.nextInt(800)+80;
				int y=random.nextInt(400)+80;
				int contadoriguales=0;
				System.out.println("betta "+x+" y "+y);
				for (int i = 0; i < 4; i++) {
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
			while(contadortiburones!=1) {
				int x=random.nextInt(800)+80;
				int y=random.nextInt(400)+80;
				int contadoriguales=0;
				System.out.println("tiburon "+x+" y "+y);
				for (int i = 0; i < 5; i++) {
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
