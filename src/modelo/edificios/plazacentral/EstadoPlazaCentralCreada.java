package modelo.edificios.plazacentral;

import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.aldeano.Aldeano;

public class EstadoPlazaCentralCreada implements EstadoPlazaCentral{

    @Override
    public Aldeano crearAldeano(Oro oro) {
        return new Aldeano(oro);
    }

    @Override
    public void reparar(Edificio plaza) {
        plaza.incrementarVida();
    }

    @Override
    public void recibirDanio(Edificio plazaCentral, int danio) {
        plazaCentral.reducirVida(danio);
    }

    @Override
    public void avanzarTurno(Edificio plazaCentral) {
        // Plaza central creada no maneja turnos
    }
}
