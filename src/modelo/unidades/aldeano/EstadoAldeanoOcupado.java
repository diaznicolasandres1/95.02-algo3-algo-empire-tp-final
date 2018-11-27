package modelo.unidades.aldeano;

import modelo.edificios.Edificio;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.excepciones.AldeanoEstaOcupadoException;
import modelo.excepciones.UnidadEstaMuertaException;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class EstadoAldeanoOcupado implements EstadoAldeano{

    private int turnos;

    public EstadoAldeanoOcupado(int turnosOcupado) {
        this.turnos = turnosOcupado;
    }

    public void recolectarOro(Oro oro) {
        //En turno ocupado no recolecta oro
    }

    @Override
    public void avanzarTurno(Aldeano aldeano) {
        turnos -= 1;
        if (turnos < 1) {
            aldeano.estarDisponible();
        }
    }

    @Override
    public PlazaCentral construirPlazaCentral(Aldeano aldeano, int turnosOcupado, Oro oro) {
        throw new AldeanoEstaOcupadoException();
    }

    @Override
    public Cuartel construirCuartel(Aldeano aldeano, int turnosOcupado, Oro oro) {
        throw new AldeanoEstaOcupadoException();
    }

    @Override
    public void repararEdificio(Aldeano aldeano, Edificio edificio) {
        throw new AldeanoEstaOcupadoException();

    }

    @Override
    public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento) {
        throw new AldeanoEstaOcupadoException();
    }

    @Override
    public void unidadMuerta(){
        throw new UnidadEstaMuertaException();
    }
}