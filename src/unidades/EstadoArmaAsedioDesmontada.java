package unidades;

public class EstadoArmaAsedioDesmontada implements EstadoArmaAsedio{
	
	public void atacar() {
		throw new NoSePuedeAtacarArmaAsedioDesmontadaException();
	}
	
	public void moverse() {
	
	}

}
