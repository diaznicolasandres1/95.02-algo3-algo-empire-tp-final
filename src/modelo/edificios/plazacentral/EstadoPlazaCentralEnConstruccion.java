package modelo.edificios.plazacentral;

import modelo.excepciones.PlazaCentralEnConstruccionException;
import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.aldeano.Aldeano;

public class EstadoPlazaCentralEnConstruccion implements EstadoPlazaCentral {

    private static final String NOMBRE_ESTADO = "En construccion";
    private int turnos = 3;

    @Override
    public void avanzarTurno(Edificio plaza) {
        this.turnos -= 1;
        if (this.turnos < 1) {
            plaza.terminoDeCrearse();
        }
    }

    @Override
    public void reparar(Edificio plaza) {
        throw new PlazaCentralEnConstruccionException();
    }

    @Override
    public void recibirDanio(Edificio plazaCentral, int danio) {
        throw new PlazaCentralEnConstruccionException();

    }

    @Override
    public Aldeano crearAldeano(Oro oro) {
        throw new PlazaCentralEnConstruccionException();

    }

    @Override
    public String getNombreEstado() {
        return NOMBRE_ESTADO;
    }
}
