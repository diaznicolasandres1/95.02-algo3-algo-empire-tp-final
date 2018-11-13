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
	
	
	//Es un boolean si se puede mover o no ya que los movimientos se manejan por afuera del modelo	
	public boolean mePuedoMover() {
		return estado.mePuedoMover();
		
	}

}
