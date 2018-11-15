package unidades;

import modelo.Posicion;

public class EstadoArmaAsedioMontada implements EstadoArmaAsedio{

	@Override
	public void atacar() {
		//TODO proxima entrega
	}

	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Posicion origen, Posicion destino, int rangoMovimiento) throws NoSePuedeMoverArmaAsedioMontadaException {
		throw new NoSePuedeMoverArmaAsedioMontadaException();
	}
}
