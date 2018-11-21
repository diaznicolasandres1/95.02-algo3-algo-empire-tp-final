package modelo.unidades.armadeasedio;

import modelo.Posicion;
import modelo.edificios.Edificio;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;
import modelo.unidades.armadeasedio.excepciones.TenesQueEsperarAlProximoTurnoParaAtacarException;
import modelo.unidades.armadeasedio.excepciones.TenesQueEsperarAlProximoTurnoParaDesmontarArmaException;
import modelo.unidades.armadeasedio.excepciones.TenesQueEsperarAlProximoTurnoParaMontarArmaException;
import modelo.unidades.armadeasedio.excepciones.TenesQueEsperarAlProximoTurnoParaMoverElArmaException;

public class EstadoArmaAsedioEnPausa implements EstadoArmaAsedio {
	EstadoArmaAsedio proximoEstado;
	
	public EstadoArmaAsedioEnPausa(EstadoArmaAsedio proximoEstado){
		this.proximoEstado = proximoEstado;
		
	}
		
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

	public EstadoArmaAsedio proximoEstado() {
		return proximoEstado;
	}



}
