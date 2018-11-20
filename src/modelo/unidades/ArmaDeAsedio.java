package modelo.unidades;

import modelo.Oro;
import modelo.Posicion;
import modelo.mapa.Mapa;

public class ArmaDeAsedio extends Unidad {
	
	EstadoArmaAsedio estado = new EstadoArmaAsedioDesmontada();
	
	public ArmaDeAsedio(Oro oro) {
		vida = 150;
		oro.restarOro(200);
	}	

	public void montarArma() {
		estado = new EstadoArmaAsedioMontada();
	}
	
	public void desmontarArma() {
		estado = new EstadoArmaAsedioDesmontada();
	}
	
	public void atacar() {
		estado.atacar();
	}

	@Override
	public void moverHacia(Posicion destino, Mapa mapa) {
		estado.moverUnidadDesdeHacia(this, mapa, destino, this.posicion, rangoMovimiento);
	}

}
