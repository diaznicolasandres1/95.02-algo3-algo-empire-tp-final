package modelo.unidades.armadeasedio;

import modelo.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class EstadoArmaAsedioDesmontada implements EstadoArmaAsedio{

	@Override
	public void atacar() throws NoSePuedeAtacarArmaAsedioDesmontadaException {
		throw new NoSePuedeAtacarArmaAsedioDesmontadaException();
	}

	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento) {
		origen.moverUnidadHacia(unidad, mapa, destino, rangoMovimiento);
	}
}
