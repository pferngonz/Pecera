import java.util.Random;

import acm.graphics.GImage;

public class Personajes {
	private static GImage [] Cosas= new GImage [22];
	private int Eleccion=0;
	private String [] Rareza=new String[] {"Normal","Rara","SuperRara","Legendaria"};
	private int Rangorareza=0;
	private int Rangorarezaenemigo=0;
	private int Eleccionrareza=0;
	private int Cartaparacompetir=0;
	private int Cartacontracompetir=0;
	public int getEleccionrareza(){return Eleccionrareza;}
	public String[] getRareza() {return Rareza;};
	public GImage[] getCosas(){return Cosas;}
	public int getRangorareza() {return Rangorareza;}
	public int getRangorarezaenemigo() {return Rangorarezaenemigo;}
	public int getCartaparacompetir(){return Cartaparacompetir;}
	public int getCartacontracompetir(){return Cartacontracompetir;}
	public int getEleccion() {return Eleccion;}
	public void setEleccion(Jugador patata) {
		Random random=new Random();
		Eleccionrareza=random.nextInt(100);
		if(Eleccionrareza<=59) {
			int eleccioncarta=random.nextInt(10);
			Eleccion=eleccioncarta;
			Rangorareza=0;
		}
		else if(Eleccionrareza<=89) {
			int eleccioncarta=random.nextInt(7);
			if (eleccioncarta==0) {
				eleccioncarta=1;
				
			}
			eleccioncarta=eleccioncarta+9;
			Eleccion=eleccioncarta;
			Rangorareza=1;
		}
		else if(Eleccionrareza<=97) {
			int eleccioncarta=random.nextInt(4);
			if (eleccioncarta==0) {
				eleccioncarta=1;
			}
			eleccioncarta=eleccioncarta+16;
			Eleccion=eleccioncarta;
			Rangorareza=2;
		}
		else {
			int eleccioncarta=21;
			Eleccion=eleccioncarta;
			Rangorareza=3;
		}
		patata.SetGemas(5);
		Cartaparacompetir=Eleccion;
	}
	public Personajes(){
		Cosas[0]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\putin.png");
		Cosas[1]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\angelkim.png");
		Cosas[2]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\schrodinger.png");
		Cosas[3]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\barbanegra.png");
		Cosas[4]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\hawking.png");
		Cosas[5]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\martin.png");
		Cosas[6]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\gagarin.png");
		Cosas[7]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\kennedy.png");
		Cosas[8]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\socrates.png");
		Cosas[9]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\trump.png");
		Cosas[10]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\colon.png");
		Cosas[11]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\copernico.png");
		Cosas[12]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\atila.png");
		Cosas[13]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\cid.png");
		Cosas[14]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\napoleon.png");
		Cosas[15]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\caocao.png");
		Cosas[16]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\alejandro.png");
		Cosas[17]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\hitler.png");
		Cosas[20]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\lenin.png");
		Cosas[18]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\tutankamon.png");
		Cosas[19]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\lubu.png");
		Cosas[21]=new GImage("C:\\Users\\saiko\\OneDrive\\DAW\\Programacion\\UF1\\Gachaju\\Nueva carpeta\\pinzones.png");

		Random random=new Random();
		Eleccion=random.nextInt(22);
		if(Eleccion<=9) {
			Rangorareza=0;
		}
		else if(Eleccion<=16) {
			Rangorareza=1;
		}
		else if(Eleccion<=20) {
			Rangorareza=2;
		}
		else {
			Rangorareza=3;
		}
		Rangorarezaenemigo=Rangorareza;
		Cartaparacompetir=Eleccion;
		Cartacontracompetir=Eleccion;
		
	}
}