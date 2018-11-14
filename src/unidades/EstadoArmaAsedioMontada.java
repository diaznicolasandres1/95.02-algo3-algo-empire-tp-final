package unidades;

public class EstadoArmaAsedioMontada implements EstadoArmaAsedio{
	
	public void atacar() {
   //como esta montada se puede atacar, se implementa para la prox entrega
	}
	
	
	
	
	public void moverse() throws NoSePuedeMoverArmaAsedioMontadaException  {	
		
		throw new NoSePuedeMoverArmaAsedioMontadaException();
		
	}

}
