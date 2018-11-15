package edificios;

import modelo.Oro;
import unidades.Arquero;
import unidades.Espadachin;

public interface EstadoCuartel extends EstadoEdificio {

    Espadachin crearEspadachin(Oro oro);

    Arquero crearArquero(Oro oro);
}
