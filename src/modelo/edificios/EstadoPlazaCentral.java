package modelo.edificios;

import modelo.Oro;
import modelo.unidades.Aldeano;

public interface EstadoPlazaCentral extends EstadoEdificio{

	Aldeano crearAldeano(Oro oro);

}
