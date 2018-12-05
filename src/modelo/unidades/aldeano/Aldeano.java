package modelo.unidades.aldeano;

import modelo.edificios.Edificio;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.excepciones.ConstruccionFueraDeRangoException;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class Aldeano extends Unidad {

    private Oro oro;
    private EstadoAldeano estado = new EstadoAldeanoDisponible();
    private static final int RANGO_CONTRUCCION = 1;

    public Aldeano(Oro oroNuevo) {
        this.vida = 50;
        this.oro = oroNuevo;
        this.costo = 25;
        this.oro.restarOro(this.costo);
    }

    public void repararEdificio(Edificio edificio) {
        if (edificio.calcularDistanciaA(this.posicion) > RANGO_CONTRUCCION) {
            throw new ConstruccionFueraDeRangoException();
        }
        this.estado.repararEdificio(this, edificio);
    }

    public void estarOcupado(int turnosOcupado) {
        this.estado = new EstadoAldeanoOcupado(turnosOcupado);
    }

    public void estarEnReparacion() {
        this.estado = new EstadoAldeanoReparando();
    }
    
    public void estarDisponible() {
        this.estado = new EstadoAldeanoDisponible();
    }

    public Cuartel construirCuartel() {
        return this.estado.construirCuartel(this, 3, this.oro);
    }

    public PlazaCentral construirPlazaCentral() {
        return this.estado.construirPlazaCentral(this, 3, this.oro);
    }

    @Override
    public void finalizarTurno() {
        this.estado.recolectarOro(this.oro);
        this.estado.avanzarTurno(this);
    }

    @Override
    public void moverHacia(Posicion destino, Mapa mapa) {
        this.estado.moverUnidadDesdeHacia(this, mapa, destino, this.posicion, DISTANCIA_DE_MOVIMIENTO);
        this.estarOcupado(1);
    }

    @Override
    public void matar() {
        this.estado.matar();
    }

    public void colocarEdificio(Edificio edificio, Mapa mapa, int fila, int columna) {
        edificio.colocarseEn(mapa, fila, columna);
        if (edificio.calcularDistanciaA(this.posicion) > RANGO_CONTRUCCION) {
            this.estarDisponible();
            edificio.descolocarseDe(mapa);
            throw new ConstruccionFueraDeRangoException();
        }
    }

}
