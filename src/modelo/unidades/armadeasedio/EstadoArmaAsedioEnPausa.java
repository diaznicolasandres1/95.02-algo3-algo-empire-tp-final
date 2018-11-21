package modelo.unidades.armadeasedio;

import modelo.Posicion;
import modelo.edificios.Edificio;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class EstadoArmaAsedioEnPausa implements EstadoArmaAsedio {

	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen,
			int rangoMovimiento) {
		throw new TenesQueEsperarAlProximoTurnoParaMoverElArmaException();

	}

	@Override
	public void atacar(Edificio edificio) {
		throw new TenesQueEsperarAlProximoTurnoParaAtacarException();

	}

	@Override
	public void atacar(Unidad unidad) {
		

	}

	@Override
	public void montarArma(ArmaDeAsedio armaDeAsedio) {
		throw new TenesQueEsperarAlProximoTurnoParaMontarArmaException();
		
	}

	@Override
	public void desmontarArma(ArmaDeAsedio armaDeAsedio) {
		throw new TenesQueEsperarAlProximoTurnoParaDesmontarArmaException();
		
	}



}
