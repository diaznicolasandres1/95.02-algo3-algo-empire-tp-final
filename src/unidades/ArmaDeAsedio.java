package unidades;

public class ArmaDeAsedio extends Unidad {
	
	EstadoArmaAsedio estado = new EstadoArmaAsedioDesmontada();
	
	public ArmaDeAsedio() {
		vida = 150;
		costo = 200;
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
