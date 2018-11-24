package modelo.unidades.armadeasedio;

import modelo.unidades.Atacante;
import modelo.excepciones.ColocableFueraDeRangoDeAtaqueException;
import modelo.juego.Oro;
import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;

public class ArmaDeAsedio extends Unidad implements Atacante {

	private static final int DISTANCIA_MAXIMA_ATAQUE = 5;
	private EstadoArmaAsedio estado = new EstadoArmaAsedioDesmontada();

	public ArmaDeAsedio(Oro oro) {
		vida = 150;
		oro.restarOro(200);
	}

	public void montarArma() {
		estado.montarArma(this);
		estado = new EstadoArmaAsedioEnPausa(new EstadoArmaAsedioMontada());

	}

	public void desmontarArma() {
		estado.desmontarArma(this);
		estado = new EstadoArmaAsedioEnPausa(new EstadoArmaAsedioDesmontada());
	}

	public void avanzarTurno() {
		estado = estado.proximoEstado();
	}

	@Override
	public void moverHacia(Posicion destino, Mapa mapa) {
		estado.moverUnidadDesdeHacia(this, mapa, destino, this.posicion, distanciaDeMovimiento);
	}

	@Override
	public void atacar(Colocable colocable) {
		if (colocable.calcularDistanciaA(this.posicion) > DISTANCIA_MAXIMA_ATAQUE) {
			throw new ColocableFueraDeRangoDeAtaqueException();
		}
		estado.atacar(colocable, this);
		estado = new EstadoArmaAsedioEnPausa(estado);
	}
}
