package Modelo;

public class Posicion {
	int posX;
	int posY;
	
	public Posicion(int newPosX, int newPosY) {
		this.posX = newPosX;
		this.posY = newPosY;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}

	public boolean dentroRango(Posicion otraPosicion, int rango) {
		int rangoX = this.posX - otraPosicion.getPosX();
		int rangoY = this.posY - otraPosicion.getPosY();
		boolean condicion1 = (rangoX <= rango) && (rangoX >= -rango);
		boolean condicion2 = (rangoY <= rango) && (rangoY >= -rango);
		return condicion1 && condicion2;
	}
}
