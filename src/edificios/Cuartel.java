package edificios;

import unidades.Aldeano;
import unidades.Arquero;
import unidades.Espadachin;

public class Cuartel extends Edificio {
	
	EstadoCuartel estado = new EstadoCuartelEnConstruccion();
	
	public Cuartel() {
		vida =250;
		costo = 50;
		tamanio = 4;
		
	}
	
	public void repararse() {
		estado.repararse(this);
	}	
	
	public void recibirDanio(int valorDanio) {
		estado.recibirDanio(this, valorDanio);
		
	}
	public void terminoDeCrearse() {
		estado = new EstadoCuartelConstruido();
	}
	
	public void avanzarTurno() {
		estado.avanzarTurno(this);
	}
	
	public Arquero crearArqueroDesdeCuartel() {
		return estado.crearArquero();
		
	}
	public Espadachin crearEspadachinDesdeCuartel() {
		return estado.crearEspadachin();
	}
	

}
