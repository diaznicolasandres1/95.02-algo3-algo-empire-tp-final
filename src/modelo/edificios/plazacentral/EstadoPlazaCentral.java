package modelo.edificios.plazacentral;

import modelo.Oro;
import modelo.edificios.EstadoEdificio;
import modelo.unidades.aldeano.Aldeano;

public interface EstadoPlazaCentral extends EstadoEdificio{

	Aldeano crearAldeano(Oro oro);

}
