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
	public void atacar(Edificio edificio,Arquero arquero) {
		/*try: validar distancia*/
		edificio.recibirDanio(arquero);
		/*catch lanzar excepcion fuera de rango*/
		
	}

	@Override
	public void atacar(Unidad unidad,Arquero arquero) {
		/*try: validar distancia*/
		unidad.recibirDanio(arquero);
		/*catch lanzar excepcion fuera de rango*/
		
	}

}
