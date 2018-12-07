package modelo.unidades.aldeano;

import modelo.edificios.Edificio;
import modelo.excepciones.EdificioTieneVidaMaximaException;
import modelo.excepciones.EdificioSiendoReparadoException;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.excepciones.UnidadFueDestruidaException;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.excepciones.AldeanoEstaOcupadoException;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class EstadoAldeanoReparando implements EstadoAldeano {

    private static final String NOMBRE_ESTADO = "Reparando";
    private Edificio edificio;

    @Override
    public void repararEdificio(Aldeano aldeano, Edificio edificio) {
        this.edificio = edificio;
        try {
            edificio.repararse(aldeano);
        } catch (EdificioTieneVidaMaximaException | EdificioSiendoReparadoException e) {
            aldeano.estarDisponible();
            throw e;
        }
    }

    @Override
    public void avanzarTurno(Aldeano aldeano) {
        this.repararEdificio(aldeano, this.edificio);
    }

    @Override
    public Cuartel construirCuartel(Aldeano aldeano, int turnosOcupado, Oro oro) {
        throw new AldeanoEstaOcupadoException();
    }

    @Override
    public void recolectarOro(Oro oro) {
        // Si esta reparando no recolecta oro
    }

    @Override
    public PlazaCentral construirPlazaCentral(Aldeano aldeano, int turnosOcupado, Oro oro) {
        throw new AldeanoEstaOcupadoException();
    }

    @Override
    public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int distanciaMaxima) {
        throw new AldeanoEstaOcupadoException();
    }

    @Override
    public String getNombreEstado() {
        return NOMBRE_ESTADO;
    }
    
    @Override
    public void matar() {
        this.edificio.liberarAldeano();
        throw new UnidadFueDestruidaException();
    }

}
