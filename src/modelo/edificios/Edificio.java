package modelo.edificios;

import modelo.edificios.castillo.Castillo;
import modelo.excepciones.EdificioFueDestruidoException;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.excepciones.EdificioTieneVidaMaximaException;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;
import modelo.unidades.aldeano.Aldeano;

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
    protected Oro oro;
    protected ArrayList<Posicion> posiciones;
    protected Aldeano aldeanoReparando;

	public int getVida() {
        return this.vida;
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
        this.vida -= danio;
        if (this.vida <= 0) {
            throw new EdificioFueDestruidoException();
        }
    }

    public void incrementarVida() {
        this.vida += this.reparacion;
        if (this.vida > this.vidaMaxima) {
            this.vida = this.vidaMaxima;
            this.liberarAldeano();
            throw new EdificioTieneVidaMaximaException();
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
    public abstract void avanzarTurno();

	public abstract void terminoDeCrearse();

    public abstract void repararse(Aldeano aldeano);
	
	public void colocarAlrededor(Mapa mapa, Unidad unidad) {
		this.posiciones.get(0).colocarAlrededor(mapa, this.tamanio, unidad);
	}

    public void liberarAldeano() {
        this.aldeanoReparando = null;
    }
}
