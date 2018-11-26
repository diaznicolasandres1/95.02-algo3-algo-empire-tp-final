package modelo.unidades.armadeasedio;

import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;
import modelo.excepciones.TenesQueEsperarAlProximoTurnoParaAtacarException;
import modelo.excepciones.TenesQueEsperarAlProximoTurnoParaDesmontarArmaException;
import modelo.excepciones.TenesQueEsperarAlProximoTurnoParaMontarArmaException;
import modelo.excepciones.TenesQueEsperarAlProximoTurnoParaMoverElArmaException;

public class EstadoArmaAsedioEnPausa implements EstadoArmaAsedio {

	private EstadoArmaAsedio proximoEstado;

	public EstadoArmaAsedioEnPausa(EstadoArmaAsedio proximoEstado) {
		this.proximoEstado = proximoEstado;
	}

	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen,
									  int distanciaDeMovimiento) {
		throw new TenesQueEsperarAlProximoTurnoParaMoverElArmaException();
	}

	@Override
	public void atacar(Colocable colocable, ArmaDeAsedio arma) {
		throw new TenesQueEsperarAlProximoTurnoParaAtacarException();

	}

	@Override
	public void montarArma(ArmaDeAsedio armaDeAsedio) {
		throw new TenesQueEsperarAlProximoTurnoParaMontarArmaException();
	}

	@Override
	public void desmontarArma(ArmaDeAsedio armaDeAsedio) {
		throw new TenesQueEsperarAlProximoTurnoParaDesmontarArmaException();
	}

	public EstadoArmaAsedio proximoEstado() {
		return proximoEstado;
	}
}
