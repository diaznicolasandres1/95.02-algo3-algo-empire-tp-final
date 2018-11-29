package modelo.unidades;

import modelo.excepciones.UnidadFueDestruidaException;
import modelo.excepciones.UnidadNoPuedeSerAtacadaPorArmaDeAsedioException;
import modelo.mapa.Posicion;
import modelo.edificios.castillo.Castillo;
import modelo.mapa.Mapa;
import modelo.unidades.armadeasedio.ArmaDeAsedio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

public abstract class Unidad implements Colocable {

    private static final int DANIO_DE_ARQUERO = 15;
    private static final int DANIO_DE_ESPADACHIN = 25;
    private static final int DANIO_DE_CASTILLO = 20;
    protected int vida;
    protected int costo;
    protected Posicion posicion;
    protected int distanciaDeMovimiento = 2;

    public int getVida() {
        return vida;
    }

    public void recibirDanio(Espadachin espadachin) {
        this.reducirVida(DANIO_DE_ESPADACHIN);
    }

    public void recibirDanio(Arquero arquero) {
        this.reducirVida(DANIO_DE_ARQUERO);
    }

    public void recibirDanio(Castillo castillo) {
        this.reducirVida(DANIO_DE_CASTILLO);
    }

    public void recibirDanio(ArmaDeAsedio armaDeAsedio) {
        throw new UnidadNoPuedeSerAtacadaPorArmaDeAsedioException();
    }

    public void reducirVida(int danio) {
        this.vida -= danio;
        if (this.vida <= 0) {
            this.matar();
        }
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void colocarseEn(Mapa mapa, int fila, int columna) {
        mapa.colocarUnidad(this, fila, columna);
    }

    @Override
    public void descolocarseDe(Mapa mapa) {
        this.posicion.descolocarColocable(mapa);
    }

    @Override
    public int calcularDistanciaA(Posicion posicion) {
        return posicion.calcularDistanciaA(this.posicion);
    }

    public abstract void avanzarTurno();

    public abstract void moverHacia(Posicion destino, Mapa mapa);

    public void matar() {
        throw new UnidadFueDestruidaException();
    }

}
