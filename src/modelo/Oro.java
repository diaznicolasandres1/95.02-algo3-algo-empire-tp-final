package modelo;


public class Oro { 
	private int cantidadOro;
	
	public Oro(int cantidadInicial) {
		this.cantidadOro = cantidadInicial;
	}
	
	public void sumarOro(int cantidadSumar){
		cantidadOro += cantidadSumar;
	}
	
	public void restarOro(int cantidadRestar) {
		if (cantidadRestar > cantidadOro) {
			throw new NoTenesOroSuficienteException();
		}
		cantidadOro -= cantidadRestar;
	}


	public int getOro() {
		return this.cantidadOro;
	}
}
