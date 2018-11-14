package edificios;

import modelo.mapa.Mapa;

public abstract class Edificio {
	
	protected int vida;
	protected int costo;
	protected int tamanio;

	public int getVida() {
		return vida;
	}
	
	public void recibirDanioConValor(int danio)   {
        if (vida <= 0) {
            throw new UnidadFueDestruidaException();
        }
        vida -= danio;
    }
	
	public void repararseASimismo(int varlorARepararse, int vidaMaxima) {
		vida += varlorARepararse;
		if (vida >= vidaMaxima) {
			vida = vidaMaxima;
		}
	}

	public void colocarseEn(Mapa mapa, int fila, int columna) {
		mapa.colocarEdificio(this, tamanio, fila, columna);
	}
	
	

}
