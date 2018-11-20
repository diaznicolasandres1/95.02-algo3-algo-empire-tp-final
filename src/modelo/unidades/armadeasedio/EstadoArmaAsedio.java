package modelo.unidades.armadeasedio;

import modelo.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public interface EstadoArmaAsedio{

	void atacar();

	void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento);

}
