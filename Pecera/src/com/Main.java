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
			ArrayList<Guppy> arrayguppy=new ArrayList<Guppy>();	
			ArrayList<Betta> arraybetta=new ArrayList<Betta>();
			Tiburon tiburon=new Tiburon();
			Random random=new Random();
			int numeroguppys=random.nextInt(3)+1;
			int numerobettas=random.nextInt(3)+1;
			System.out.println(numeroguppys);
			System.out.println(numerobettas);
			int [][] posicionpeces=new int[2][numeroguppys+numerobettas+1];
			for (int i = 0; i < numeroguppys; i++) {
				int genero=random.nextInt(2);
				arrayguppy.add(new Guppy(genero));
				if(genero==0) {
					arrayguppy.get(i).setGenero(true);
					System.out.println("Guppy macho");
				}
				else {
					arrayguppy.get(i).setGenero(false);
					System.out.println("Guppy hembra");
				}
				
			}
			for (int i = 0; i < numerobettas; i++) {
				int genero2=random.nextInt(2);
				System.out.println(genero2);
				arraybetta.add(new Betta(genero2));
				if(genero2==0) {
					arraybetta.get(i).setGenero(true);
					System.out.println("betta macho");
				}
				else {
					arraybetta.get(i).setGenero(false);
					System.out.println("betta hembra");
				}
				
			}
			posicion(numeroguppys, numerobettas, tiburon, arrayguppy,  arraybetta, posicionpeces);
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
			 boolean vives = true;
	            while (vives) {
	                for (Guppy miguppy : arrayguppy) {
	                	int velocidad=random.nextInt(5)+1;
	                	miguppy.setVelocidad(velocidad);
	                	miguppy.mover(miguppy.getImagen(), getHeight(), getWidth());
	                	pause(miguppy.getVelocidad());
	                	
	                }
	                for (Betta mibetta : arraybetta) {
	                	mibetta.mover(mibetta.getImagen(), getHeight(), getWidth());
	                	pause(5);
	                	
					}
	                
	                tiburon.mover(tiburon.getImagen(), getHeight(), getWidth());
	                tiburon.getImagen().pause(3);
	                int colision=colision(arrayguppy, arraybetta, tiburon);
                	if(colision!=500) {
                		remove(arrayguppy.get(colision).getImagen());
                		arrayguppy.remove(colision);
                		colision=500;
                	}
	            }
	        
			
			
		}
		public static int colision(ArrayList<Guppy> arrayguppy, ArrayList<Betta> arraybetta, Tiburon tiburon) {
			int colision=500;
			for (int i = 0; i < arrayguppy.size(); i++) {
				for (int j = 0; j < arrayguppy.size(); j++) {
					if(i!=j) {
						if(arrayguppy.get(i).getGenero()==true && arrayguppy.get(j).getGenero()==false && arrayguppy.get(i).getImagen().getBounds().intersects(arrayguppy.get(j).getImagen().getBounds())) {
							colision=j;
						}
					}
					if(i!=j) {
						if(arrayguppy.get(i).getGenero()==true && arrayguppy.get(j).getGenero()==false && arrayguppy.get(i).getImagen().getBounds().intersects(arrayguppy.get(j).getImagen().getBounds())) {
							colision=j;
						}
					}
				}
			}
			for (int i = 0; i < 1; i++) {
				for (int j = 0; j < arrayguppy.size(); j++) {
					if(tiburon.getImagen().getBounds().intersects(arrayguppy.get(j).getImagen().getBounds())) {
						colision=j;
					}
					for (int z = 0; z < arraybetta.size(); z++) {
						if(tiburon.getImagen().getBounds().intersects(arraybetta.get(z).getImagen().getBounds())) {
							colision=j;
						}
					}
				}
			}
			return colision;
		}
		public static void posicion(int numeroguppys, int numerobettas, Tiburon tiburon, ArrayList arrayguppy, ArrayList arraybetta , int [][] posicionpeces) {
			Random random=new Random();
			int contadorguppys=0;
			int contadorbettas=0;
			int contadortiburones=0;
			while(contadorguppys!=numeroguppys) {
				int x=random.nextInt(800)+80;
				int y=random.nextInt(400)+80;
				int contadoriguales=0;
				System.out.println("guppy "+contadorguppys+" "+x+" y "+y);
				for (int i = 0; i < numeroguppys; i++) {
					if (x>posicionpeces[0][i] && x<posicionpeces[0][i]+100 || x<posicionpeces[0][i] && x>posicionpeces[0][i]-100) {
						contadoriguales++;
					}
					if (y>posicionpeces[1][i] && y<posicionpeces[1][i]+100 || y<posicionpeces[1][i] && y>posicionpeces[1][i]-100) {
						contadoriguales++;
					}
				}
				if (contadoriguales==0) {
					posicionpeces[0][contadorguppys]=x;
					posicionpeces[1][contadorguppys]=y;
					System.out.println("Guppy "+contadorguppys+" se queda con "+x+" y "+y);
					contadorguppys++;
				}
			}
			while(contadorbettas!=numerobettas) {
				int x=random.nextInt(800)+80;
				int y=random.nextInt(400)+80;
				int contadoriguales=0;
				System.out.println("betta "+contadorbettas+" "+x+" y "+y);
				for (int i = 0; i < numeroguppys+numerobettas; i++) {
					if (x>posicionpeces[0][i] && x<posicionpeces[0][i]+100 || x<posicionpeces[0][i] && x>posicionpeces[0][i]-100) {
						contadoriguales++;
					}
					if (y>posicionpeces[1][i] && y<posicionpeces[1][i]+100 || y<posicionpeces[1][i] && y>posicionpeces[1][i]-100) {
						contadoriguales++;
					}
				}
				if (contadoriguales==0) {
					posicionpeces[0][contadorbettas+contadorguppys]=x;
					posicionpeces[1][contadorbettas+contadorguppys]=y;
					System.out.println("Betta "+contadorbettas+" se queda con "+x+" y "+y);
					contadorbettas++;
				}
			}
			while(contadortiburones!=1) {
				int x=random.nextInt(800)+80;
				int y=random.nextInt(400)+80;
				int contadoriguales=0;
				System.out.println("tiburon "+x+" y "+y);
				for (int i = 0; i < numeroguppys+numerobettas+1; i++) {
					if (x>posicionpeces[0][i] && x<posicionpeces[0][i]+100 || x<posicionpeces[0][i] && x>posicionpeces[0][i]-100) {
						contadoriguales++;
					}
					if (y>posicionpeces[1][i] && y<posicionpeces[1][i]+100 || y<posicionpeces[1][i] && y>posicionpeces[1][i]-100) {
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
