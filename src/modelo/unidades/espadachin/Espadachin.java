package modelo.unidades.espadachin;

import modelo.Ataque;
import modelo.Oro;
import modelo.RangoDeAtaqueInvalidoException;
import modelo.edificios.Edificio;
import modelo.unidades.Unidad;
import modelo.unidades.arquero.EstadoArqueroDisponible;
import modelo.unidades.arquero.EstadoArqueroOcupado;

public class Espadachin extends Unidad implements Ataque {

	EstadoEspadachin estado = new EstadoEspadachinDisponible();
	
	public Espadachin(Oro oro) {
		vida = 100;
		oro.restarOro(50);
	}

	@Override
	public void atacar(Edificio edificio) {
		if(edificio.calcularDistanciaA(this.posicion) > 1) {
			throw new RangoDeAtaqueInvalidoException();			
		}		
		estado.atacar(edificio,this);
		this.estarOcupado();
		
	}

	@Override
	public void atacar(Unidad unidad) {
		if(unidad.calcularDistanciaA(this.posicion) > 1) {
			throw new RangoDeAtaqueInvalidoException();			
		}		
		estado.atacar(unidad,this);
		this.estarOcupado();
		
	}
	
	public void avanzarTurno() {
		estado.avanzarTurno(this);
	}
	

	public void estarDisponible() {
		 estado = new EstadoEspadachinDisponible();		
	}
	
	public void estarOcupado() {
		 estado = new EstadoEspadachinOcupado();		
}
}