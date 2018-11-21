package modelo.unidades.armadeasedio;

import modelo.Posicion;
import modelo.edificios.Edificio;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;
import modelo.unidades.armadeasedio.excepciones.NoSePuedeMoverArmaAsedioMontadaException;

public class EstadoArmaAsedioMontada implements EstadoArmaAsedio{

	
	
	
	@Override
	public EstadoArmaAsedio proximoEstado() {
		return null;
	}
	
	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento) throws NoSePuedeMoverArmaAsedioMontadaException {
		throw new NoSePuedeMoverArmaAsedioMontadaException();
	}

	@Override
	public void atacar(Edificio edificio) {
		/*try: validar distancia*/
		edificio.recibirDanio(75);
		/*catch lanzar excepcion fuera de rango*/
	}
	
	@Override
	public void desmontarArma(ArmaDeAsedio armaDeAsedio) {
		
	}


	@Override
	public void atacar(Unidad unidad) {
		
	}

	@Override
	public void montarArma(ArmaDeAsedio armaDeAsedio) {
		// TODO Auto-generated method stub
		
	}

	
	


}
