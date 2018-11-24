package modelo.edificios;

import modelo.edificios.castillo.Castillo;
import modelo.mapa.Posicion;
import modelo.excepciones.EdificioTieneVidaMaximaException;
import modelo.excepciones.UnidadFueDestruidaException;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

import java.util.ArrayList;

public abstract class Edificio implements Colocable {

    protected static final int DANIO_DE_ESPADACHIN = 15;
    protected static final int DANIO_DE_ARQUERO = 10;
    protected static final int DANIO_DE_CASTILLO = 20;
    protected static final int DANIO_ARMA_DE_ASEDIO = 75;
	protected int vidaMaxima;
	protected int vida;
	protected int costo;
	protected int tamanio;
	protected int reparacion;
    protected ArrayList<Posicion> posiciones;

	public int getVida() {
		return vida;
	}
	
	public void recibirDanio(Espadachin espadachin) {
        this.reducirVida(DANIO_DE_ESPADACHIN);
	}
	
	public void recibirDanio(Arquero arquero) {
        this.reducirVida(DANIO_DE_ARQUERO);
    }

    public void recibirDanio(ArmaDeAsedio armaAsedio) {
        this.reducirVida(DANIO_ARMA_DE_ASEDIO);
    }

    public void recibirDanio(Castillo castillo) {
        this.reducirVida(DANIO_DE_CASTILLO);
    }

    public void reducirVida(int danio) {
        vida -= danio;
        if (vida <= 0) {
            throw new UnidadFueDestruidaException();
        }
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
        for (Posicion posicion : this.posiciones) {
            posicion.descolocarColocable(mapa);
        }
    }

    @Override
    public void colocarseEn(Mapa mapa, int fila, int columna) {
        mapa.colocarEdificio(this, this.tamanio, fila, columna);
    }

    public void agregarPosicion(Posicion posicion) {
        this.posiciones.add(posicion);
    }

    @Override
    public int calcularDistanciaA(Posicion posicion) {
        int distanciaMinima = Integer.MAX_VALUE;
        for (Posicion unaPosicion : this.posiciones) {
            distanciaMinima = Integer.min(distanciaMinima, posicion.calcularDistanciaA(unaPosicion));
        }
        return distanciaMinima;
    }

	@Override
	public void avanzarTurno() {}

	public abstract void terminoDeCrearse();
}
