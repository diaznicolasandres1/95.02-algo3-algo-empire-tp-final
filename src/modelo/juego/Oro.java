package modelo.juego;


import modelo.excepciones.OroInsuficienteException;

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
			throw new OroInsuficienteException();
		}
		cantidadOro -= cantidadRestar;
	}


	public int getOro() {
		return this.cantidadOro;
	}
}
