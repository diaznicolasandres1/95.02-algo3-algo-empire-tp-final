package modelo;


public class Oro { 
	private int cantidadOro;
	
	public Oro(int cantidadInicial) {
		this.cantidadOro = cantidadInicial;
	}
	
	public void sumarOro(int cantidadSumar){
		cantidadOro += cantidadSumar;
	}

	public int getOro() {
		return this.cantidadOro;
	}
}
