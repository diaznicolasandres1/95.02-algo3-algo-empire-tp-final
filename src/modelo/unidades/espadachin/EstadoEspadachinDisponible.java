package modelo.unidades.espadachin;

import modelo.edificios.Edificio;
import modelo.unidades.Unidad;
import modelo.unidades.arquero.EstadoArquero;

public class EstadoEspadachinDisponible implements EstadoEspadachin {

	@Override
	public void avanzarTurno(Espadachin espadachin) {
		espadachin.estarDisponible();		
	}

	@Override
	public void atacar(Edificio edificio) {
		/*try: validar distancia*/
		edificio.recibirDanioConValor(15);
		/*catch lanzar excepcion fuera de rango*/
		
	}

	@Override
	public void atacar(Unidad unidad) {
		/*try: validar distancia*/
		unidad.recibirDanio(25);
		/*catch lanzar excepcion fuera de rango*/
		
	}

}
