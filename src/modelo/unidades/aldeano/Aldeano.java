package modelo.unidades.aldeano;

import modelo.edificios.Edificio;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class Aldeano extends Unidad {

    private Oro oro;
    private EstadoAldeano estado = new EstadoAldeanoDisponible();

    public Aldeano(Oro oroNuevo) {
        this.vida = 50;
        this.oro = oroNuevo;
        this.costo = 25;
        oro.restarOro(costo);
    }

    public void repararEdificio(Edificio edificio) {
        estado.repararEdificio(this, edificio);
    }

    public void estarOcupado(int turnosOcupado) {
        estado = new EstadoAldeanoOcupado(turnosOcupado);
    }

    public void estarEnReparacion() {
        estado = new EstadoAldeanoReparando();
    }
    
    public void estarDisponible() {
        estado = new EstadoAldeanoDisponible();
    }

    public Cuartel construirCuartel() {
        return estado.construirCuartel(this, 3, oro);
    }

    public PlazaCentral construirPlazaCentral() {
        return estado.construirPlazaCentral(this, 3, oro);
    }

    @Override
    public void avanzarTurno() {
        estado.recolectarOro(oro);
        estado.avanzarTurno(this);
    }

    @Override
    public void moverHacia(Posicion destino, Mapa mapa) {
        estado.moverUnidadDesdeHacia(this, mapa, destino, this.posicion, distanciaDeMovimiento);
        this.estarOcupado(1);
    }

    @Override
    public void matar() {
        estado.matar();
    }
}
