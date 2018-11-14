package edificios;

import modelo.mapa.Mapa;
import unidades.Colocable;

public abstract class Edificio implements Colocable {
	protected int vidaMaxima;
	protected int vida;
	protected int costo;
	protected int tamanio;
	protected int reparacion;
	

	public int getVida() {
		return vida;
	}
	
	public void recibirDanioConValor(int danio)   {
        if (vida <= 0) {
            throw new UnidadFueDestruidaException();
        }
        vida -= danio;
    }
	
	public void repararseASimismo() {
		if(vida == vidaMaxima) {
			throw new EdificioTieneVidaMaximaException();
		}
		vida += reparacion;
		if (vida >= vidaMaxima) {
			vida = vidaMaxima;
		}
	}

    @Override
    public void colocarseEn(Mapa mapa, int fila, int columna) {
        mapa.colocarEdificio(this, tamanio, fila, columna);
    }

	protected abstract void terminoDeCrearse();

	
	
	

}
