package edificios;

import modelo.Oro;
import unidades.Aldeano;

public interface EstadoPlazaCentral extends EstadoEdificio{
	
	public Aldeano crearAldeano(Oro oro);

}
