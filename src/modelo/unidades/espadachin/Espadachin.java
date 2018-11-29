package modelo.unidades.espadachin;

import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Atacante;
import modelo.excepciones.ColocableFueraDeRangoDeAtaqueException;
import modelo.juego.Oro;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;

public class Espadachin extends Unidad implements Atacante {

    private EstadoEspadachin estado = new EstadoEspadachinDisponible();
    private static final int RANGO_DE_ATAQUE = 1;

    public Espadachin(Oro oro) {
        this.vida = 100;
        this.costo = 50;
        oro.restarOro(costo);
    }

    @Override
    public void atacar(Colocable colocable) {
        if (colocable.calcularDistanciaA(this.posicion) > RANGO_DE_ATAQUE) {
            throw new ColocableFueraDeRangoDeAtaqueException();
        }
        estado.atacar(colocable, this);
        this.estarOcupado();
    }

    @Override
    public void moverHacia(Posicion destino, Mapa mapa) {
        estado.moverEspadachinDesdeHacia(this, this.posicion, destino, mapa, this.distanciaDeMovimiento);
        this.estarOcupado();
    }

    public void avanzarTurno() {
        estado.avanzarTurno(this);
    }

    public void estarDisponible() {
        estado = new EstadoEspadachinDisponible();
    }

    public void estarOcupado() {
        estado = new EstadoEspadachinOcupado();
    }

}