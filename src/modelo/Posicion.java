package modelo;

public class Posicion {
	private int posX;
	private int posY;
	
	public Posicion(int newPosX, int newPosY) {
		this.posX = newPosX;
		this.posY = newPosY;
	}

	public boolean estaDentroDelRangoDe(Posicion posicion, int rango) {
		return compararDistancias(this.posX, this.posY, rango);
	}
	
	private boolean compararDistancias(int posX, int posY, int rango) {
		int rangoX = this.posX - posX;
		int rangoY = this.posY - posY;
		boolean condicion1 = (rangoX <= rango) && (rangoX >= -rango);
		boolean condicion2 = (rangoY <= rango) && (rangoY >= -rango);
		return condicion1 && condicion2;
	}
}

