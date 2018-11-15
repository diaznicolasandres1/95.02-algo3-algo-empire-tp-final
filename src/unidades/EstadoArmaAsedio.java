package unidades;

import modelo.Posicion;

public interface EstadoArmaAsedio{

	void atacar();

	void moverUnidadDesdeHacia(Unidad unidad, Posicion origen, Posicion destino, int rangoMovimiento);

}
