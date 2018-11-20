package modelo.unidades;

import modelo.Posicion;
import modelo.mapa.Mapa;

public interface EstadoArmaAsedio{

	void atacar();

	void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento);

}
