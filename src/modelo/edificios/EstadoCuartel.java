package modelo.edificios;

import modelo.Oro;
import modelo.unidades.Espadachin;
import modelo.unidades.arquero.Arquero;

public interface EstadoCuartel extends EstadoEdificio {

    Espadachin crearEspadachin(Oro oro);

    Arquero crearArquero(Oro oro);
}
