package modelo.unidades.arquero;

import modelo.Ataque;
import modelo.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;

public class Arquero extends Unidad implements Ataque {
	
	EstadoArquero estado = new EstadoArqueroDisponible();
	
	public Arquero(Oro oro) {
		vida = 75;
		oro.restarOro(75);
	}

	
	public void avanzarTurno() {
		estado.avanzarTurno(this);
		
	}

	@Override
	public void atacar(Edificio edificio) {		
		if(edificio.calcularDistanciaA(this.posicion) > 3) {
			throw new RangoDeAtaqueInvalidoException();			
		}		 
		estado.atacar(edificio);
		this.estarOcupado();
		
	}

	@Override
	public void atacar(Unidad unidad) {
		if(unidad.calcularDistanciaA(this.posicion) > 3) {
			throw new RangoDeAtaqueInvalidoException();			
		}	
		estado.atacar(unidad);
		this.estarOcupado();
		
	}
	
	public void estarDisponible() {
		 estado = new EstadoArqueroDisponible();		
	}
	
	public void estarOcupado() {
		 estado = new EstadoArqueroOcupado();		
	}


}
