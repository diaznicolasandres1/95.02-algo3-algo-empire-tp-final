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
	public void atacar(Edificio edificio,Espadachin espadachin) {
		/*try: validar distancia*/
		edificio.recibirDanio(espadachin);
		/*catch lanzar excepcion fuera de rango*/
		
	}

	@Override
	public void atacar(Unidad unidad,Espadachin espadachin) {
		/*try: validar distancia*/
		unidad.recibirDanio(espadachin);
		/*catch lanzar excepcion fuera de rango*/
		
	}

}
