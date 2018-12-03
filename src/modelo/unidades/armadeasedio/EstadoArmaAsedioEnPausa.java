package modelo.unidades.armadeasedio;

import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;

import modelo.excepciones.NoSePuedeAtacarConArmaDeAsedioEnPausaException;
import modelo.excepciones.NoSePuedeDesmontarArmaDeAsedioEnPausaException;
import modelo.excepciones.NoSePuedeMontarArmaDeAsedioEnPausaException;
import modelo.excepciones.NoSePuedeMoverArmaDeAsedioEnPausaException;

public class EstadoArmaAsedioEnPausa implements EstadoArmaAsedio {

	private EstadoArmaAsedio proximoEstado;

	public EstadoArmaAsedioEnPausa(EstadoArmaAsedio proximoEstado) {
		this.proximoEstado = proximoEstado;
	}

	@Override
	public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen,
									  int distanciaDeMovimiento) {
		throw new NoSePuedeMoverArmaDeAsedioEnPausaException();
	}

	@Override
	public void atacar(Colocable colocable, ArmaDeAsedio arma) {
		throw new NoSePuedeAtacarConArmaDeAsedioEnPausaException();

	}

	@Override
	public void montarArma(ArmaDeAsedio armaDeAsedio) {
		throw new NoSePuedeMontarArmaDeAsedioEnPausaException();
	}

	@Override
	public void desmontarArma(ArmaDeAsedio armaDeAsedio) {
		throw new NoSePuedeDesmontarArmaDeAsedioEnPausaException();
	}

	public EstadoArmaAsedio proximoEstado() {
        return this.proximoEstado;
	}
}
