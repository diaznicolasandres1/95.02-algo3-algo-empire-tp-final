package modelo.unidades.armadeasedio;

import modelo.Posicion;
import modelo.edificios.Edificio;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class EstadoArmaAsedioMontada implements EstadoArmaAsedio{


	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento) throws NoSePuedeMoverArmaAsedioMontadaException {
		throw new NoSePuedeMoverArmaAsedioMontadaException();
	}

	@Override
	public void atacar(Edificio edificio) {
		/*try: validar distancia*/
		edificio.recibirDanioConValor(75);
		/*catch lanzar excepcion fuera de rango*/
	}

	@Override
	public void atacar(Unidad unidad) {
		// TODO Auto-generated method stub
		
	}
}
