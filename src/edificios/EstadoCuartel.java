package edificios;

import unidades.Arquero;
import unidades.Espadachin;

public interface EstadoCuartel extends EstadoEdificio {
	
	public  Espadachin crearEspadachin();
	public Arquero crearArquero();

}
