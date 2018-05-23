
public class Juego {
	private int[] Vidaporclase=new int[] {15,30,45,99};
	private int Mivida=0;
	private int Tuvida=0;
	private String [][] Insultosnormales=new String[2][3];
	private int [][] Dañonormales=new int[2][3];
	private String [][] Insultospremium=new String[5][8];
	private int [][] Dañopremium=new int[2][8];
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
	public int [][] getDañonormales(){return Dañonormales;}
	public int [][] getDañopremium(){return Dañopremium;}
	public int getTuvida() {return Tuvida;}
	public Juego() {
		Insultosnormales[0][0]="Tu madre huele a urinario público";
		Insultosnormales[0][1]="Hasta Hachiko te abandonaría";
		Insultosnormales[1][0]="Eres más feo que una nevera por detrás";
		Insultosnormales[1][1]="El otro día te ví al tirar de la cadena";
		Insultosnormales[1][2]="Yo soy cola, tú pegamento";
		Dañonormales[0][0]=1;
		Dañonormales[0][1]=2;
		Dañonormales[1][0]=1;
		Dañonormales[1][1]=2;
		Dañonormales[1][2]=3;
		Insultospremium[0][0]="¿Te apetece una ducha?";
		Insultospremium[0][1]="Voy a hacer unos preciosos botones contigo";
		Insultospremium[0][2]="Me he comprado un horno nuevo, ¿quieres probarlo?";
		Insultospremium[0][3]="Hay tres estados de la materia, pero yo solo conozco el gas";
		Insultospremium[1][0]="Te voy a momificar mientras aun estas con vida";
		Insultospremium[1][1]="Antes era un Faraón, hasta que recibí una flecha en la cabeza";
		Insultospremium[1][2]="Haré que cientos de escarabajos devoren tu asquerosa carne";
		Insultospremium[1][3]="Te mandaré con Anúbis al infierno";
		Insultospremium[2][0]="Te voy a dejar mas rojo que mi caballo";
		Insultospremium[2][1]="Clavaré tu cabeza en mi lanza y cabalgaré por toda China con ella";
		Insultospremium[2][2]="Tienes más pluma que Zhang He";
		Insultospremium[2][3]="Solo dejo un rastro de cadáveres, no me persigas";
		Insultospremium[3][0]="Echaré todo el peso de la revolución sobre ti, literalmente";
		Insultospremium[3][1]="Viva el patriarcado...digo el proletariado";
		Insultospremium[3][2]="El capitalismo es de maricas estadounidenses";
		Insultospremium[3][3]="No me vaciles, que llamo a mi primo Trotski y te pegamos pavo";
		Insultospremium[4][0]="Los hermanos Pinzones eran unos mari...";
		Insultospremium[4][1]="Que se fueron con Colón que era otro mari...";
		Insultospremium[4][2]="Y se fueron a Calcuta en busca de una pu...";
		Insultospremium[4][3]="Y conquistaron Camboya con la punta de la po...";
		Insultospremium[4][4]="Y a los indios motilones les cortaron los coj...";
		Insultospremium[4][5]="Y a las indias por coquetas les cortaron las tet...";
		Insultospremium[4][6]="Al piloto Pedro Angulo le quisieron dar por cu...";
		Insultospremium[4][7]="Y a su hermano Bobadilla le llenaron de ladi...";
		Dañopremium[0][0]=1;
		Dañopremium[0][1]=2;
		Dañopremium[0][2]=3;
		Dañopremium[0][3]=4;
		Dañopremium[1][0]=1;
		Dañopremium[1][1]=2;
		Dañopremium[1][2]=3;
		Dañopremium[1][3]=4;
		Dañopremium[1][4]=5;
		Dañopremium[1][5]=6;
		Dañopremium[1][6]=7;
		Dañopremium[1][7]=8;

	}
}
