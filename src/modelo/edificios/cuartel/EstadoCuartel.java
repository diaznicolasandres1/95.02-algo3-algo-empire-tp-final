package modelo.edificios.cuartel;

import modelo.juego.Oro;
import modelo.edificios.EstadoEdificio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

public interface EstadoCuartel extends EstadoEdificio {

    Espadachin crearEspadachin(Oro oro);
    Arquero crearArquero(Oro oro);
}
