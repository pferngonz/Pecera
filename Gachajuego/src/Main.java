import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
public class Main {
    public static void main(String[] args) {
        
        while(true) {
        	new App().start(args);
        }
    }

    public static class App extends GraphicsProgram {
        @Override
        public void run() {
            setSize(1680, 1020);
            GImage boton = new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\boton2.png");
            GImage boton2 = new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\boton2.png");
            GImage botonpresionado = new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\botonpresionado.png");
            GImage botonpresionado2 = new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\botonpresionado.png");
            GImage pantalladeinicio=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\splashinicio.png");
            GImage pantalladeinicio2=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\fondo4.gif");
            GImage play=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\botonplay.png");
            GImage play2=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\botonplay2.1.png");
            GImage mon=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\mon.png");
            GImage fondoba=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\fondoba1.gif");
            GImage decidete=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\decidete.png");
            GImage ratios=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\listadrop.png");
            GImage botonratios=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\gemma.png");
            pantalladeinicio.setSize(1680, 1020);
            add (pantalladeinicio,0,0);
            waitForClick();
            remove(pantalladeinicio);
            Personajes pulls=new Personajes();
            Jugador persona=new Jugador();
            Juego combate=new Juego();
            GLabel contadorgemas1=new GLabel(Integer.toString(persona.getGemas()));
            GLabel labelrareza=new GLabel("algo");
            labelrareza.setColor(Color.yellow);
            Font AuxFont6=labelrareza.getFont();
            add(contadorgemas1,88,75);
            botonratios.setSize(200,200);
            contadorgemas1.setColor(Color.red);
            Font AuxFont=contadorgemas1.getFont();
            contadorgemas1.setFont(new Font(AuxFont.getFontName(),AuxFont.getStyle(),30));
            labelrareza.setFont(new Font(AuxFont6.getFontName(),AuxFont6.getStyle(),50));
            boton.setSize(200,200);
            botonpresionado.setSize(200,200);
            boton2.setSize(50,50);
            botonpresionado2.setSize(50,50);
            play.setSize(200,120);
            play2.setSize(200,120);
            mon.setSize(50,50);
            pantalladeinicio2.setSize(1680, 1020);
            decidete.setSize(1680, 1020);
            add(pantalladeinicio2,0,0);
            pantalladeinicio2.sendBackward();
            double botonx=(getWidth()-boton.getWidth())/2;
            double botony=getHeight()-boton.getHeight();
            double boton2x=(getWidth()-boton.getWidth())/2+boton.getWidth();
            double boton2y=getHeight()-boton.getHeight();
            double cartax=(getWidth()-pulls.getCosas()[pulls.getEleccion()].getWidth())/2;
            double cartay=(getHeight()-pulls.getCosas()[pulls.getEleccion()].getHeight())/2-120;
            add(boton, botonx,botony);
            add(boton2, boton2x,boton2y);
            add(play,1450,820);
            add (mon,40,40);
            add (botonratios,1500,40);
            combate.setTuvida(pulls);
            MouseAdapter pull=new MouseAdapter() {
	            	@Override
	            	public void mouseClicked(MouseEvent e) {
	            		// TODO Auto-generated method stub
	            		super.mouseClicked(e);
	            		add(pulls.getCosas()[pulls.getEleccion()],cartax,cartay);
	            		labelrareza.setLabel(pulls.getRareza()[pulls.getRangorareza()]);
						add(labelrareza,cartax+120,cartay+580);
	            	}
	            	@Override
	            	public void mouseExited(MouseEvent e) {
	            		// TODO Auto-generated method stub
	            		super.mouseExited(e);
	            		remove(pulls.getCosas()[pulls.getEleccion()]);
	            		remove(botonpresionado);
	                    add(boton, botonx,botony);
	                    remove(labelrareza);

	            	}
	            	@Override
	            	public void mousePressed(MouseEvent e) {
	            	// TODO Auto-generated method stub
	            	super.mousePressed(e);
	            	remove(boton);
	            	add(botonpresionado,botonx,botony);
	            	}
				};
				MouseAdapter reniciar=new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						super.mouseClicked(e);
						pulls.setEleccion(persona);
						System.out.println(pulls.getEleccion());
						
					}
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						super.mousePressed(e);
						remove(boton2);
						add(botonpresionado2,boton2x,boton2y);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						super.mouseExited(e);
						remove(botonpresionado2);
						add(boton2,boton2x,boton2y);
					}
				};
				MouseAdapter juego=new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						super.mouseClicked(e);
						boton.removeMouseListener(pull);
						boton2.removeMouseListener(reniciar);
						remove(boton);
						remove(boton2);
						remove(play);
						remove(mon);
						remove(pantalladeinicio2);
						remove(contadorgemas1);
						persona.setJuegoinsultos();
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						super.mouseEntered(e);
			            add(play2,1450,820);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						super.mouseExited(e);
						remove(play2);
					}
				};
				MouseAdapter rates=new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						super.mouseClicked(e);
						add(ratios,cartax-200,cartay);
						
					}
				};
				MouseAdapter ratesoff=new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						super.mouseClicked(e);
						remove(ratios);
						
					}
				};
				boton.addMouseListener(pull);
				boton2.addMouseListener(reniciar);
				play.addMouseListener(juego);
				botonratios.addMouseListener(rates);
				ratios.addMouseListener(ratesoff);
				boolean escierto=false;
				
				while(!escierto) {
					if(persona.getGemas()<0 || persona.getJuegoinsultos()) {
						boton.removeMouseListener(pull);
						boton2.removeMouseListener(reniciar);
						escierto=true;
					}
					else {
						contadorgemas1.setLabel(Integer.toString(persona.getGemas()));
					}
					System.out.println(pulls.getEleccionrareza());
				}
				if(persona.getJuegoinsultos()) {
					combate.setMivida(pulls);
					if (pulls.getCartaparacompetir()==21) {
						pulls.getCosas()[pulls.getCartaparacompetir()].setSize(400,555);
			            add(pulls.getCosas()[pulls.getCartaparacompetir()],200,330);
					}
		            else {
		            	add(pulls.getCosas()[pulls.getCartaparacompetir()],200,350);}		
					pulls.getCosas()[pulls.getCartaparacompetir()].sendToFront();
		            fondoba.setSize(1680, 1020);
		            add(fondoba,0,0);
		            fondoba.sendBackward();
		            if (pulls.getCartacontracompetir()==21) {
						pulls.getCosas()[pulls.getCartacontracompetir()].setSize(400,555);
			            add(pulls.getCosas()[pulls.getCartacontracompetir()],1100,330);

					}
		            else {
			            add(pulls.getCosas()[pulls.getCartacontracompetir()],1100,350);
		            }
		            GLabel start=new GLabel("CLICK TO START");
		            GLabel mivida=new GLabel(Integer.toString(combate.getMivida()));
		            GLabel tuvida=new GLabel(Integer.toString(combate.getTuvida()));
		            GLabel miinsulto=new GLabel("algo");
		            GLabel tuinsulto=new GLabel("algo2");
		            Random random=new Random();
		            add(start,530,200);
		            miinsulto.setColor(Color.yellow);
		            tuinsulto.setColor(Color.red);
		            start.setColor(Color.LIGHT_GRAY);
		            start.setFont(new Font(AuxFont.getFontName(),AuxFont.getStyle(),80));
		            waitForClick();
		            remove(start);
		            mivida.setColor(Color.yellow);
		            tuvida.setColor(Color.red);
		            Font AuxFont1=mivida.getFont();
		            Font AuxFont2=tuvida.getFont();
		            Font AuxFont3=miinsulto.getFont();
		            Font AuxFont4=tuinsulto.getFont();
		            mivida.setFont(new Font(AuxFont1.getFontName(),AuxFont.getStyle(),40));
		            tuvida.setFont(new Font(AuxFont2.getFontName(),AuxFont.getStyle(),40));
		            miinsulto.setFont(new Font(AuxFont3.getFontName(),AuxFont.getStyle(),40));
		            tuinsulto.setFont(new Font(AuxFont4.getFontName(),AuxFont.getStyle(),40));
		            add(mivida,230,390);
		            add(tuvida,1125,390);
		            while(combate.getMivida()>0 && combate.getTuvida()>0) {
		            	mivida.setLabel(Integer.toString(combate.getMivida()));
		            	tuvida.setLabel(Integer.toString(combate.getTuvida()));
		            	if(pulls.getRangorareza()==0) {
		            		int insulto=random.nextInt(2);
		            		miinsulto.setLabel(combate.getInsultosnormales()[0][insulto]);
		            		add(miinsulto,50,200);
		            		waitForClick();
		            		remove(miinsulto);
		            		miinsulto.setLabel("-"+Integer.toString(combate.getDañonormales()[0][insulto]));
		            		combate.quitartuvida(combate.getDañonormales()[0][insulto]);
		            		tuvida.setLabel(Integer.toString(combate.getTuvida()));
		            		add(miinsulto,50,200);
		            		waitForClick();
		            		remove(miinsulto);
		            	}
		            	else if(pulls.getRangorareza()==1) {
		            		int insulto=random.nextInt(3);
		            		miinsulto.setLabel(combate.getInsultosnormales()[1][insulto]);
		            		add(miinsulto,50,200);
		            		waitForClick();
		            		remove(miinsulto);
		            		miinsulto.setLabel("-"+Integer.toString(combate.getDañonormales()[1][insulto]));
		            		combate.quitartuvida(combate.getDañonormales()[1][insulto]);
		            		tuvida.setLabel(Integer.toString(combate.getTuvida()));
		            		add(miinsulto,50,200);
		            		waitForClick();
		            		remove(miinsulto);

		            	}
		            	else if(pulls.getRangorareza()==2) {
		            		if(pulls.getCartaparacompetir()==17) {
		            			int insulto=random.nextInt(4);
			            		miinsulto.setLabel(combate.getInsultospremium()[0][insulto]);
			            		add(miinsulto,50,200);
			            		waitForClick();
			            		remove(miinsulto);
			            		miinsulto.setLabel("-"+Integer.toString(combate.getDañopremium()[0][insulto]));
			            		combate.quitartuvida(combate.getDañopremium()[0][insulto]);
			            		tuvida.setLabel(Integer.toString(combate.getTuvida()));
			            		add(miinsulto,50,200);
			            		waitForClick();
			            		remove(miinsulto);
		            		}
		            		else if(pulls.getCartaparacompetir()==18) {
		            			int insulto=random.nextInt(4);
			            		miinsulto.setLabel(combate.getInsultospremium()[1][insulto]);
			            		add(miinsulto,50,200);
			            		waitForClick();
			            		remove(miinsulto);
			            		miinsulto.setLabel("-"+Integer.toString(combate.getDañopremium()[0][insulto]));
			            		combate.quitartuvida(combate.getDañopremium()[0][insulto]);
			            		tuvida.setLabel(Integer.toString(combate.getTuvida()));
			            		add(miinsulto,50,200);
			            		waitForClick();
			            		remove(miinsulto);
		            		}
		            		else if(pulls.getCartaparacompetir()==19) {
		            			int insulto=random.nextInt(4);
			            		miinsulto.setLabel(combate.getInsultospremium()[2][insulto]);
			            		add(miinsulto,50,200);
			            		waitForClick();
			            		remove(miinsulto);
			            		miinsulto.setLabel("-"+Integer.toString(combate.getDañopremium()[0][insulto]));
			            		combate.quitartuvida(combate.getDañopremium()[0][insulto]);
			            		tuvida.setLabel(Integer.toString(combate.getTuvida()));
			            		add(miinsulto,50,200);
			            		waitForClick();
			            		remove(miinsulto);
		            		}
		            		else if(pulls.getCartaparacompetir()==20) {
		            			int insulto=random.nextInt(4);
			            		miinsulto.setLabel(combate.getInsultospremium()[3][insulto]);
			            		add(miinsulto,50,200);
			            		waitForClick();
			            		remove(miinsulto);
			            		miinsulto.setLabel("-"+Integer.toString(combate.getDañopremium()[0][insulto]));
			            		combate.quitartuvida(combate.getDañopremium()[0][insulto]);
			            		tuvida.setLabel(Integer.toString(combate.getTuvida()));
			            		add(miinsulto,50,200);
			            		waitForClick();
			            		remove(miinsulto);
		            		}
		            	}
		            	else if(pulls.getRangorareza()==3) {
		            		int insulto=random.nextInt(8);
		            		miinsulto.setLabel(combate.getInsultospremium()[4][insulto]);
		            		add(miinsulto,50,200);
		            		waitForClick();
		            		remove(miinsulto);
		            		miinsulto.setLabel("-"+Integer.toString(combate.getDañopremium()[1][insulto]));
		            		combate.quitartuvida(combate.getDañopremium()[1][insulto]);
		            		tuvida.setLabel(Integer.toString(combate.getTuvida()));
		            		add(miinsulto,50,200);
		            		waitForClick();
		            		remove(miinsulto);
		            	}
		            	if(pulls.getRangorarezaenemigo()==0) {
		            		if(combate.getTuvida()<=0) {
		            			break;
		            		}
		            		else {
		            		int insulto=random.nextInt(2);
		            		tuinsulto.setLabel(combate.getInsultosnormales()[0][insulto]);
		            		add(tuinsulto,800,200);
		            		waitForClick();
		            		remove(miinsulto);
		            		tuinsulto.setLabel("-"+Integer.toString(combate.getDañonormales()[0][insulto]));
		            		combate.quitarmivida(combate.getDañonormales()[0][insulto]);
		            		mivida.setLabel(Integer.toString(combate.getMivida()));
		            		add(tuinsulto,800,200);
		            		waitForClick();
		            		remove(tuinsulto);
		            		}
		            	}
		            	else if(pulls.getRangorarezaenemigo()==1) {
		            		if(combate.getTuvida()<=0) {
		            			break;
		            		}
		            		else {
			            		int insulto=random.nextInt(3);
			            		tuinsulto.setLabel(combate.getInsultosnormales()[1][insulto]);
			            		add(tuinsulto,800,200);
			            		waitForClick();
			            		remove(miinsulto);
			            		tuinsulto.setLabel("-"+Integer.toString(combate.getDañonormales()[1][insulto]));
			            		combate.quitarmivida(combate.getDañonormales()[1][insulto]);
			            		mivida.setLabel(Integer.toString(combate.getMivida()));
			            		add(tuinsulto,800,200);
			            		waitForClick();
			            		remove(tuinsulto);
		            		}
		            	}
		            	else if(pulls.getRangorarezaenemigo()==2) {
		            		if(combate.getTuvida()<=0) {
		            			break;
		            		}
		            		else {
		            			
		            	if(pulls.getCartacontracompetir()==17) {
		            		int insulto=random.nextInt(4);
		            		tuinsulto.setLabel(combate.getInsultospremium()[0][insulto]);
		            		add(tuinsulto,500,200);
		            		waitForClick();
		            		remove(miinsulto);
		            		tuinsulto.setLabel("-"+Integer.toString(combate.getDañopremium()[0][insulto]));
		            		combate.quitarmivida(combate.getDañopremium()[0][insulto]);
		            		mivida.setLabel(Integer.toString(combate.getMivida()));
		            		add(tuinsulto,800,200);
		            		waitForClick();
		            		remove(tuinsulto);
		            	}
		            	else if(pulls.getCartacontracompetir()==18) {
		            		int insulto=random.nextInt(4);
		            		tuinsulto.setLabel(combate.getInsultospremium()[1][insulto]);
		            		add(tuinsulto,500,200);
		            		waitForClick();
		            		remove(miinsulto);
		            		tuinsulto.setLabel("-"+Integer.toString(combate.getDañopremium()[0][insulto]));
		            		combate.quitarmivida(combate.getDañopremium()[0][insulto]);
		            		mivida.setLabel(Integer.toString(combate.getMivida()));
		            		add(tuinsulto,800,200);
		            		waitForClick();
		            		remove(tuinsulto);
		            	}
		            	else if(pulls.getCartacontracompetir()==19) {
		            		int insulto=random.nextInt(4);
		            		tuinsulto.setLabel(combate.getInsultospremium()[2][insulto]);
		            		add(tuinsulto,500,200);
		            		waitForClick();
		            		remove(miinsulto);
		            		tuinsulto.setLabel("-"+Integer.toString(combate.getDañopremium()[0][insulto]));
		            		combate.quitarmivida(combate.getDañopremium()[0][insulto]);
		            		mivida.setLabel(Integer.toString(combate.getMivida()));
		            		add(tuinsulto,800,200);
		            		waitForClick();
		            		remove(tuinsulto);
		            	}
		            	else if(pulls.getCartacontracompetir()==20) {
		            		int insulto=random.nextInt(4);
		            		tuinsulto.setLabel(combate.getInsultospremium()[3][insulto]);
		            		add(tuinsulto,500,200);
		            		waitForClick();
		            		remove(miinsulto);
		            		tuinsulto.setLabel("-"+Integer.toString(combate.getDañopremium()[0][insulto]));
		            		combate.quitarmivida(combate.getDañopremium()[0][insulto]);
		            		mivida.setLabel(Integer.toString(combate.getMivida()));
		            		add(tuinsulto,800,200);
		            		waitForClick();
		            		remove(tuinsulto);
		            	}
		            		}
		            	}
		            	else if(pulls.getRangorarezaenemigo()==3) {
		            		if(combate.getTuvida()<=0) {
		            			break;
		            		}
		            		else {
		            		int insulto=random.nextInt(8);
		            		tuinsulto.setLabel(combate.getInsultospremium()[4][insulto]);
		            		add(tuinsulto,500,200);
		            		waitForClick();
		            		remove(miinsulto);
		            		tuinsulto.setLabel("-"+Integer.toString(combate.getDañopremium()[1][insulto]));
		            		combate.quitarmivida(combate.getDañopremium()[1][insulto]);
		            		mivida.setLabel(Integer.toString(combate.getMivida()));
		            		add(tuinsulto,800,200);
		            		waitForClick();
		            		remove(tuinsulto);
		            	}
		            	}
		            }
		            start.setLabel("GAME OVER");
		            add(start,600,200);
		            waitForClick();
				}
				else {
					add(decidete,0,0);
					waitForClick();
				}
				
				
        }

    }
}