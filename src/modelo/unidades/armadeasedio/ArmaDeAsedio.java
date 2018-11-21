package modelo.unidades.armadeasedio;

import modelo.Ataque;
import modelo.Oro;
import modelo.Posicion;
import modelo.edificios.Edificio;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class ArmaDeAsedio extends Unidad implements Ataque {
	
	
	
	EstadoArmaAsedio estado = new EstadoArmaAsedioDesmontada();
	EstadoArmaAsedio proximoEstado;
	
	public ArmaDeAsedio(Oro oro) {
		vida = 150;
		oro.restarOro(200);
	}	

	public void montarArma() {
		estado.montarArma(this);
		
	}
	
	public void desmontarArma() { //Se desmonta y ya ese turno no puede hacer nada mas
		estado.desmontarArma(this);
	}
	
	public void avanzarTurno() {
		estado = proximoEstado;
	}
	
	
	
	public void montar() {
		estado = new EstadoArmaAsedioEnPausa();
		proximoEstado= new EstadoArmaAsedioMontada();
		
		
	}
	public void desmontar() {
		estado = new EstadoArmaAsedioEnPausa();
		proximoEstado = new EstadoArmaAsedioDesmontada();
		
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
