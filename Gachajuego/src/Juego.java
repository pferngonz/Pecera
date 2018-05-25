
public class Juego {
	private int[] Vidaporclase=new int[] {15,30,45,99};
	private int Mivida=0;
	private int Tuvida=0;
	private String [][] Insultosnormales=new String[2][3];
	private int [][] Da�onormales=new int[2][3];
	private String [][] Insultospremium=new String[5][8];
	private int [][] Da�opremium=new int[2][8];
	public void setMivida(Personajes patata) {
		Mivida=Vidaporclase[patata.getRangorareza()];
	}
	public int getMivida() {return Mivida;}
	public void setTuvida(Personajes patata) {
		Tuvida=Vidaporclase[patata.getRangorareza()];
	}
	public void quitarmivida(int vida) {
		Mivida=Mivida-vida;
	}
	public void quitartuvida(int vida) {
		Tuvida=Tuvida-vida;
	}
	public String [][] getInsultosnormales(){return Insultosnormales;}
	public String [][] getInsultospremium(){return Insultospremium;}
	public int [][] getDa�onormales(){return Da�onormales;}
	public int [][] getDa�opremium(){return Da�opremium;}
	public int getTuvida() {return Tuvida;}
	public Juego() {
		Insultosnormales[0][0]="Tu madre huele a urinario p�blico";
		Insultosnormales[0][1]="Hasta Hachiko te abandonar�a";
		Insultosnormales[1][0]="Eres m�s feo que una nevera por detr�s";
		Insultosnormales[1][1]="El otro d�a te v� al tirar de la cadena";
		Insultosnormales[1][2]="Yo soy cola, t� pegamento";
		Da�onormales[0][0]=1;
		Da�onormales[0][1]=2;
		Da�onormales[1][0]=1;
		Da�onormales[1][1]=2;
		Da�onormales[1][2]=3;
		Insultospremium[0][0]="�Te apetece una ducha?";
		Insultospremium[0][1]="Voy a hacer unos preciosos botones contigo";
		Insultospremium[0][2]="Me he comprado un horno nuevo, �quieres probarlo?";
		Insultospremium[0][3]="Hay tres estados de la materia, pero yo solo conozco el gas";
		Insultospremium[1][0]="Te voy a momificar mientras aun estas con vida";
		Insultospremium[1][1]="Antes era un Fara�n, hasta que recib� una flecha en la cabeza";
		Insultospremium[1][2]="Har� que cientos de escarabajos devoren tu asquerosa carne";
		Insultospremium[1][3]="Te mandar� con An�bis al infierno";
		Insultospremium[2][0]="Te voy a dejar mas rojo que mi caballo";
		Insultospremium[2][1]="Clavar� tu cabeza en mi lanza y cabalgar� por toda China con ella";
		Insultospremium[2][2]="Tienes m�s pluma que Zhang He";
		Insultospremium[2][3]="Solo dejo un rastro de cad�veres, no me persigas";
		Insultospremium[3][0]="Echar� todo el peso de la revoluci�n sobre ti, literalmente";
		Insultospremium[3][1]="Viva el patriarcado...digo el proletariado";
		Insultospremium[3][2]="El capitalismo es de maricas estadounidenses";
		Insultospremium[3][3]="No me vaciles, que llamo a mi primo Trotski y te pegamos pavo";
		Insultospremium[4][0]="Los hermanos Pinzones eran unos mari...";
		Insultospremium[4][1]="Que se fueron con Col�n que era otro mari...";
		Insultospremium[4][2]="Y se fueron a Calcuta en busca de una pu...";
		Insultospremium[4][3]="Y conquistaron Camboya con la punta de la po...";
		Insultospremium[4][4]="Y a los indios motilones les cortaron los coj...";
		Insultospremium[4][5]="Y a las indias por coquetas les cortaron las tet...";
		Insultospremium[4][6]="Al piloto Pedro Angulo le quisieron dar por cu...";
		Insultospremium[4][7]="Y a su hermano Bobadilla le llenaron de ladi...";
		Da�opremium[0][0]=1;
		Da�opremium[0][1]=2;
		Da�opremium[0][2]=3;
		Da�opremium[0][3]=4;
		Da�opremium[1][0]=1;
		Da�opremium[1][1]=2;
		Da�opremium[1][2]=3;
		Da�opremium[1][3]=4;
		Da�opremium[1][4]=5;
		Da�opremium[1][5]=6;
		Da�opremium[1][6]=7;
		Da�opremium[1][7]=8;

	}
}
