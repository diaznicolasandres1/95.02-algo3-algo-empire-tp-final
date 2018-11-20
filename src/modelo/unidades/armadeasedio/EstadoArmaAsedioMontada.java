package modelo.unidades.armadeasedio;

import modelo.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class EstadoArmaAsedioMontada implements EstadoArmaAsedio{

	@Override
	public void atacar() {
		//TODO proxima entrega
	}

	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento) throws NoSePuedeMoverArmaAsedioMontadaException {
		throw new NoSePuedeMoverArmaAsedioMontadaException();
	}
}
