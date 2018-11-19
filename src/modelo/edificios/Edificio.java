package modelo.edificios;

import modelo.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;

public abstract class Edificio implements Colocable {

	protected int vidaMaxima;
	protected int vida;
	protected int costo;
	protected int tamanio;
	protected int reparacion;
    protected Posicion posicionInicio;

	public int getVida() {
		return vida;
	}
	
	public void recibirDanioConValor(int danio)   {
        if (vida <= 0) {
            throw new UnidadFueDestruidaException();
        }
        vida -= danio;
    }

    public void repararseAsimismo() {

        if (vida == vidaMaxima) {
			throw new EdificioTieneVidaMaximaException();
		}
		vida += reparacion;
		if (vida >= vidaMaxima) {
			vida = vidaMaxima;
		}
	}

    @Override
    public void descolocarseDe(Mapa mapa) {
        this.posicionInicio.descolocarEdificioDe(mapa, this.tamanio);
    }

    @Override
    public void colocarseEn(Mapa mapa, int fila, int columna) {
        mapa.colocarEdificio(this, tamanio, fila, columna);
        this.setPosicionInicio(new Posicion(columna, fila));
    }

    private void setPosicionInicio(Posicion posicion) {
        this.posicionInicio = posicion;
    }

	protected abstract void terminoDeCrearse();
	
	@Override
	public void avanzarTurno() {}
}
