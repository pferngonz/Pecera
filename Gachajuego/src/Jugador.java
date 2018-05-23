
public class Jugador {
	private int Gemas=50;
	private boolean Juegoinsultos=false;
	public void SetGemas(int gemas) {
		Gemas=Gemas-gemas;
	}
	public int getGemas() {return Gemas;}
	public void setJuegoinsultos() {
		Juegoinsultos=true;
	}
	public boolean getJuegoinsultos() {
		return Juegoinsultos;
	}
}
