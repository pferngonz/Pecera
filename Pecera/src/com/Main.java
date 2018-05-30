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
			int yustemamon=0;
			GImage fondo=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/fondo.gif");
			setSize(1280,720);
			fondo.setSize(1280,720);
			add(fondo, 0, 0);
			ArrayList<Guppy> arrayguppy=new ArrayList<Guppy>();	
			ArrayList<Betta> arraybetta=new ArrayList<Betta>();
			Tiburon tiburon=new Tiburon();
			Random random=new Random();
			int numeroguppys=random.nextInt(2)+2;
			int numerobettas=random.nextInt(2)+2;
			System.out.println(numeroguppys);
			System.out.println(numerobettas);
			int [][] posicionpeces=new int[2][numeroguppys+numerobettas+1];
			for (int i = 0; i < numeroguppys; i++) {
				int genero=random.nextInt(2);
				arrayguppy.add(new Guppy(genero));
				if(genero==0) {
					System.out.println("Guppy macho");
				}
				else {
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
				int velocidad=random.nextInt(5)+1;
            	arrayguppy.get(i).setVelocidad(velocidad);
			}
			for (int i = arrayguppy.size(); i < arrayguppy.size()+arraybetta.size(); i++) {
				add(arraybetta.get(contadorbettas).getImagen(),posicionpeces[0][i],posicionpeces[1][i]);
				arraybetta.get(contadorbettas).setX(posicionpeces[0][i]);
				arraybetta.get(contadorbettas).setY(posicionpeces[1][i]);
				int velocidad=random.nextInt(5)+1;
            	arraybetta.get(contadorbettas).setVelocidad(velocidad);
				contadorbettas++;
			}
			for (int i = arrayguppy.size()+arraybetta.size(); i < arrayguppy.size()+arraybetta.size()+1; i++) {
				add(tiburon.getImagen(),posicionpeces[0][i],posicionpeces[1][i]);
				tiburon.setX(posicionpeces[0][i]);
				tiburon.setY(posicionpeces[1][i]);
			}
			int contadorguppys=numeroguppys;
			boolean cierto=false;
			waitForClick();
			String [] turnopeces=new String[5];
			 boolean vives = true;
			 int colision;
	            while (vives) {
	                for(int i=0; i< arrayguppy.size();i++) {
	                	if(arrayguppy.get(i)!=null) {
	                	arrayguppy.get(i).mover(arrayguppy.get(i).getImagen(), getHeight(), getWidth());
	                	pause(arrayguppy.get(i).getVelocidad());
	                	if(contadorguppys!=1) {
	                		arrayguppy.get(i).comer(turnopeces, 0);
		                	colision=colision(arrayguppy, arraybetta, tiburon, turnopeces);
		                	if(colision!=500 && turnopeces[3].equals("X") && arrayguppy.get(i).getVecespreñao()==1) {
		                		arrayguppy.get(i).setVecespreñao();
		                		int genero=random.nextInt(2);
		                		arrayguppy.get(i).reproducirse();
		                		arrayguppy.add(new Guppy(genero));
		                		contadorguppys++;
		                		arrayguppy.get(arrayguppy.size()-1).setX(arrayguppy.get(i).getXH());
		                		arrayguppy.get(arrayguppy.size()-1).setY(arrayguppy.get(i).getYH());
		                		add(arrayguppy.get(arrayguppy.size()-1).getImagen(),arrayguppy.get(arrayguppy.size()-1).getX(),arrayguppy.get(arrayguppy.size()-1).getY());
		                		remove(arrayguppy.get(colision).getImagen());
		                		arrayguppy.remove(colision);
		                	}
		                	else if(colision!=500 && turnopeces[0].equals("X")) {
		                		remove(arrayguppy.get(colision).getImagen());
		                		arrayguppy.remove(colision);
		                		contadorguppys--;
		                	}
		                	else if(colision!=500 && turnopeces[1].equals("X")) {
		                		remove(arraybetta.get(colision).getImagen());
		                		arraybetta.remove(colision);
		                		contadorbettas--;
		                	}
		                	turnopeces[0]="";
		                	turnopeces[1]="";
		                	turnopeces[3]="";
	                	}
	                }
	                }
	                for (int i=0;i<arraybetta.size();i++) {
	                	if(arraybetta.get(i)!=null) {
	                	arraybetta.get(i).mover(arraybetta.get(i).getImagen(), getHeight(), getWidth());
	                	pause(arraybetta.get(i).getVelocidad());
	                	if(contadorbettas!=1) {
	                		arraybetta.get(i).comer(turnopeces, 1);
		                	colision=colision(arrayguppy, arraybetta, tiburon, turnopeces);
		                	if(colision!=500 && turnopeces[4].equals("X") && arraybetta.get(i).getVecespreñao()==1) {
		                		arraybetta.get(i).setVecespreñao();
		                		int genero=random.nextInt(2);
		                		arraybetta.get(i).reproducirse();
		                		arraybetta.add(new Betta(genero));
		                		contadorbettas++;
		                		arraybetta.get(arraybetta.size()-1).setX(arraybetta.get(i).getXH());
		                		arraybetta.get(arraybetta.size()-1).setY(arraybetta.get(i).getYH());
		                		add(arraybetta.get(arraybetta.size()-1).getImagen(),arraybetta.get(arraybetta.size()-1).getX(),arraybetta.get(arraybetta.size()-1).getY());
		                		remove(arraybetta.get(colision).getImagen());
		                		arraybetta.remove(colision);
		                	}
		                	else if(colision!=500 && turnopeces[0].equals("X")) {
		                		remove(arrayguppy.get(colision).getImagen());
		                		arrayguppy.remove(colision);
		                	}
		                	else if(colision!=500 && turnopeces[1].equals("X")) {
		                		remove(arraybetta.get(colision).getImagen());
		                		arraybetta.remove(colision);
		                	}
		                	turnopeces[0]="";
		                	turnopeces[1]="";
		                	turnopeces[4]="";
	                	}
	                	
					}
	                }
	                
	                tiburon.mover(tiburon.getImagen(), getHeight(), getWidth());
	                tiburon.getImagen().pause(15);
	            }
	        
			
			
		}
		public static int colision(ArrayList<Guppy> arrayguppy, ArrayList<Betta> arraybetta, Tiburon tiburon, String [] turnopeces) {
			int colision=500;
			if(turnopeces[0].equals("X")) {
				int contadorderrores=0;
				int contadorderroresembarazados=0;
			for (int i = 0; i < arrayguppy.size(); i++) {
				for (int j = 0; j < arrayguppy.size(); j++) {
					if(i!=j) {
						if(arrayguppy.get(i).getGenero()==true && arrayguppy.get(j).getGenero()==true && arrayguppy.get(i).getImagen().getBounds().intersects(arrayguppy.get(j).getImagen().getBounds())) {
							colision=j;
							contadorderrores++;
							break;
						}
					
					
						if(arrayguppy.get(i).getVecespreñao()!=0 && arrayguppy.get(i).getGenero()==true && arrayguppy.get(j).getGenero()==false && arrayguppy.get(i).getImagen().getBounds().intersects(arrayguppy.get(j).getImagen().getBounds())) {
							colision=j;
							arrayguppy.get(j).setVecespreñao();
							contadorderroresembarazados++;
							break;
						}
					}
				}
			}
			if(contadorderrores==0 && contadorderroresembarazados==0) {
			for (int i = 0; i < arrayguppy.size(); i++) {
				for (int j = 0; j < arraybetta.size(); j++) {
					if(arrayguppy.get(i).getGenero()==true && arraybetta.get(j).getGenero()==true && arrayguppy.get(i).getImagen().getBounds().intersects(arraybetta.get(j).getImagen().getBounds())) {
						colision=j;
						contadorderrores++;
						break;
					}
				}
			}
			if(contadorderrores!=0 && contadorderroresembarazados==0) {
				turnopeces[0]="";
				turnopeces[1]="X";
				return colision;
			}
			}
			else if(contadorderrores!=0 && contadorderroresembarazados==0){
				turnopeces[0]="X";
				return colision;
			}
			else if(contadorderroresembarazados!=0) {
				turnopeces[3]="X";
				return colision;
			}
			
			}
			else if(turnopeces[1].equals("X")) {
				int contadorderrores=0;
				int contadorderroresembarazados=0;
				for (int i = 0; i <arraybetta.size(); i++) {
					for (int j = 0; j < arraybetta.size(); j++) {
						if(i!=j) {
							if(arraybetta.get(i).getGenero()==true && arraybetta.get(j).getGenero()==true && arraybetta.get(i).getImagen().getBounds().intersects(arraybetta.get(j).getImagen().getBounds())) {
								colision=j;
								contadorderrores++;
								break;
							}
							if(arraybetta.get(i).getGenero()==true && arraybetta.get(j).getGenero()==false && arraybetta.get(i).getImagen().getBounds().intersects(arraybetta.get(j).getImagen().getBounds())) {
								colision=j;
								arraybetta.get(j).setVecespreñao();
								contadorderroresembarazados++;
								break;
							}
						}
					}
				}
					if(contadorderrores==0 && contadorderroresembarazados==0) {
						for (int i = 0; i < arraybetta.size(); i++) {
							for (int j = 0; j < arrayguppy.size(); j++) {
								if(arraybetta.get(i).getGenero()==true && arrayguppy.get(j).getGenero()==true && arraybetta.get(i).getImagen().getBounds().intersects(arrayguppy.get(j).getImagen().getBounds())) {
									colision=j;
									contadorderrores++;
									break;
								}
							}
						}
						if(contadorderrores!=0 && contadorderroresembarazados==0) {
							turnopeces[0]="X";
							turnopeces[1]="";
							return colision;
						}
					}
					else if(contadorderrores!=0 && contadorderroresembarazados==0){
						turnopeces[1]="X";
						return colision;
					}
					else if(contadorderrores==0 && contadorderroresembarazados!=0) {
						turnopeces[4]="X";
						return colision;
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
