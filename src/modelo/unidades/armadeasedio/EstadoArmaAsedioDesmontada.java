package modelo.unidades.armadeasedio;

import modelo.Posicion;
import modelo.edificios.Edificio;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;
import modelo.unidades.armadeasedio.excepciones.ElArmaYaEstaDesmontadaException;
import modelo.unidades.armadeasedio.excepciones.NoSePuedeAtacarArmaAsedioDesmontadaException;

public class EstadoArmaAsedioDesmontada implements EstadoArmaAsedio{

	
	
	public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento) {
		origen.moverUnidadHacia(unidad, mapa, destino, rangoMovimiento);
	}


	@Override
	public void atacar(Edificio edificio,ArmaDeAsedio arma) {
		throw new NoSePuedeAtacarArmaAsedioDesmontadaException();
		
	}

	@Override
	public void montarArma(ArmaDeAsedio armaDeAsedio) {
		
	}


	@Override
	public void desmontarArma(ArmaDeAsedio armaDeAsedio) {
		throw new ElArmaYaEstaDesmontadaException();
		
	}
	
	@Override
	public void atacar(Unidad unidad,ArmaDeAsedio arma) {
		
		
	}



	@Override
	public EstadoArmaAsedio proximoEstado() {
		
		return null;
	}

}
