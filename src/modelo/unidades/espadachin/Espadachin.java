package modelo.unidades.espadachin;

import modelo.Ataque;
import modelo.Oro;
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
		estado.atacar(edificio);
		this.estarOcupado();
		
	}

	@Override
	public void atacar(Unidad unidad) {
		estado.atacar(unidad);
		this.estarOcupado();
		
	}
	

	public void estarDisponible() {
		 estado = new EstadoEspadachinDisponible();		
	}
	
	public void estarOcupado() {
		 estado = new EstadoEspadachinOcupado();		
}
}