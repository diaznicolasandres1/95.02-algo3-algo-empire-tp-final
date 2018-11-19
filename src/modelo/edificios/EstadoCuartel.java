package modelo.edificios;

import modelo.Oro;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;

public interface EstadoCuartel extends EstadoEdificio {

    Espadachin crearEspadachin(Oro oro);

    Arquero crearArquero(Oro oro);
}
