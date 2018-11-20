package modelo.unidades.armadeasedio;

import modelo.Ataque;
import modelo.Posicion;
import modelo.edificios.Edificio;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public interface EstadoArmaAsedio {

	

	void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento);

	void atacar(Edificio edificio);
	void atacar(Unidad unidad);


}
