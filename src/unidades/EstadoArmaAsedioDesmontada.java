package unidades;

import modelo.Posicion;

public class EstadoArmaAsedioDesmontada implements EstadoArmaAsedio{

	@Override
	public void atacar() throws NoSePuedeAtacarArmaAsedioDesmontadaException {
		throw new NoSePuedeAtacarArmaAsedioDesmontadaException();
	}

	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Posicion origen, Posicion destino, int rangoMovimiento) {
		origen.moverUnidadHacia(unidad, destino, rangoMovimiento);
	}
}
