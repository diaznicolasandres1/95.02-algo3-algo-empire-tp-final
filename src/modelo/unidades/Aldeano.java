package modelo.unidades;

import modelo.edificios.Cuartel;
import modelo.edificios.Edificio;
import modelo.edificios.PlazaCentral;
import modelo.Oro;
import modelo.Posicion;

public class Aldeano extends Unidad {

    private Oro oro;
    private EstadoAldeano estado = new EstadoAldeanoDisponible();

    public Aldeano(Oro oroNuevo) {
        vida = 50;
        oro = oroNuevo;
        oro.restarOro(25);
    }

    public void aldeanoRepararEdificio(Edificio edificio) {
        estado.repararEdificio(this, edificio);
    }

    public void estarOcupado(int turnosOcupado) {
        estado = new EstadoAldeanoOcupado(turnosOcupado);
    }

    public void estarEnReparacion() {
        estado = new EstadoAldeanoReparando();
    }

    public Cuartel construirCuartel() {
        return estado.construirCuartel(this, 3, oro);
    }

    public PlazaCentral construirPlazaCentral() {
        return estado.construirPlazaCentral(this, 3, oro);
    }

    public void estarDisponible() {
        estado = new EstadoAldeanoDisponible();
    }

    @Override
    public void avanzarTurno() {
        estado.recolectarOro(oro);
        estado.avanzarTurno(this);
    }

    public void aldeanoSeLibero() {
        estado = new EstadoAldeanoDisponible();
    }

    @Override
    public void moverHacia(Posicion posicion) {
        estado.moverUnidadDesdeHacia(this, this.posicion, posicion, rangoMovimiento);
    }
}
