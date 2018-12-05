package modelo.unidades.espadachin;

import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Atacable;
import modelo.unidades.Atacante;
import modelo.excepciones.ColocableFueraDeRangoDeAtaqueException;
import modelo.juego.Oro;
import modelo.unidades.Unidad;

public class Espadachin extends Unidad implements Atacante {

    private EstadoEspadachin estado = new EstadoEspadachinDisponible();
    private static final int RANGO_DE_ATAQUE = 1;

    public Espadachin(Oro oro) {
        this.vida = 100;
        this.costo = 50;
        oro.restarOro(this.costo);
    }

    @Override
    public void atacar(Atacable objetivo) {
        if (objetivo.calcularDistanciaA(this.posicion) > RANGO_DE_ATAQUE) {
            throw new ColocableFueraDeRangoDeAtaqueException();
        }
        this.estado.atacar(objetivo, this);
        this.estarOcupado();
    }

    @Override
    public void moverHacia(Posicion destino, Mapa mapa) {
        this.estado.moverEspadachinDesdeHacia(this, this.posicion, destino, mapa, DISTANCIA_DE_MOVIMIENTO);
        this.estarOcupado();
    }

    public void finalizarTurno() {
        this.estado.avanzarTurno(this);
    }

    public void estarDisponible() {
        this.estado = new EstadoEspadachinDisponible();
    }

    public void estarOcupado() {
        this.estado = new EstadoEspadachinOcupado();
    }

}