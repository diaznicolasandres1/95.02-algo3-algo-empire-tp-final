package modelo.unidades.aldeano;

import modelo.edificios.Edificio;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.excepciones.UnidadFueDestruidaException;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.excepciones.AldeanoEstaOcupadoException;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class EstadoAldeanoOcupado implements EstadoAldeano{

    private int turnos;

    public EstadoAldeanoOcupado(int turnosOcupado) {
        this.turnos = turnosOcupado;
    }

    public void recolectarOro(Oro oro) {
        // En turno ocupado aldeano no recolecta oro
    }

    @Override
    public void avanzarTurno(Aldeano aldeano) {
        this.turnos -= 1;
        if (this.turnos < 1) {
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
    public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int distanciaMaxima) {
        throw new AldeanoEstaOcupadoException();
    }

    @Override
    public void matar() {
        throw new UnidadFueDestruidaException();
    }

}