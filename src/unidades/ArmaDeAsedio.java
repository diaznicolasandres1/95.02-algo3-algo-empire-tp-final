package unidades;

import modelo.Oro;

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
		
	public void moverse() {
		estado.moverse();
		
	}

}
