package modelo.unidades.armadeasedio;

import modelo.Ataque;
import modelo.Oro;
import modelo.Posicion;
import modelo.edificios.Edificio;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;
import modelo.unidades.armadeasedio.excepciones.ArmaDeAsedioNoPuedeAtacarUnidadesException;

public class ArmaDeAsedio extends Unidad implements Ataque {
	
	
	
	EstadoArmaAsedio estado = new EstadoArmaAsedioDesmontada();
	
	
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
		estado.moverUnidadDesdeHacia(this, mapa, destino, this.posicion, rangoMovimiento);
	}

	@Override
	public void atacar(Edificio edificio) {
		estado.atacar(edificio);
		
	}

	@Override
	public void atacar(Unidad unidad) {
		throw new ArmaDeAsedioNoPuedeAtacarUnidadesException();
		
	}

}
