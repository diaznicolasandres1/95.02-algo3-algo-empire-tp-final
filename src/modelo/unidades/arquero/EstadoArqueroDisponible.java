package modelo.unidades.arquero;

import modelo.edificios.Edificio;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;

public class EstadoArqueroDisponible implements EstadoArquero {

	@Override
	public void avanzarTurno(Arquero arquero) {
		arquero.estarDisponible();
		
	}

	@Override
	public void atacar(Edificio edificio) {
		/*try: validar distancia*/
		edificio.recibirDanio(10);
		/*catch lanzar excepcion fuera de rango*/
		
	}

	@Override
	public void atacar(Unidad unidad) {
		/*try: validar distancia*/
		unidad.recibirDanio(10);
		/*catch lanzar excepcion fuera de rango*/
		
	}

}
