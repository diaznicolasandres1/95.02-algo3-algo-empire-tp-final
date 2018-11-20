package modelo.unidades;

import modelo.edificios.Cuartel;
import modelo.edificios.Edificio;
import modelo.edificios.PlazaCentral;
import modelo.Oro;
import modelo.Posicion;
import modelo.mapa.Mapa;

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
    
    /*-----Cambio de estados-----*/	

    public void estarOcupado(int turnosOcupado) {
        estado = new EstadoAldeanoOcupado(turnosOcupado);
    }

    public void estarEnReparacion() {
        estado = new EstadoAldeanoReparando();
    }
    
    public void estarDisponible() {
        estado = new EstadoAldeanoDisponible();
    }
    
    /*-----El aldeano construye cuartel y plaza central-----*/	

    public Cuartel construirCuartel() {
        return estado.construirCuartel(this, 3, oro);
    }

    public PlazaCentral construirPlazaCentral() {
        return estado.construirPlazaCentral(this, 3, oro);
    }
    
    /*----------------------------------------------------*/	

 

    @Override
    public void avanzarTurno() {
        estado.recolectarOro(oro);
        estado.avanzarTurno(this);
    }


    @Override
    public void moverHacia(Posicion destino, Mapa mapa) {
        estado.moverUnidadDesdeHacia(this, mapa, destino, this.posicion, rangoMovimiento);
    }
}
