package modelo.edificios;

import modelo.Oro;
import modelo.unidades.Arquero;
import modelo.unidades.Espadachin;

public class Cuartel extends Edificio {

    Oro oro;
	EstadoCuartel estado = new EstadoCuartelEnConstruccion();
	
	public Cuartel(Oro nuevoOro) {
		vidaMaxima = 250;
		vida = 250;
		reparacion = 50;
		tamanio = 4;
		oro = nuevoOro;
		oro.restarOro(50);		
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
		return estado.crearArquero(oro);
		
	}
	public Espadachin crearEspadachinDesdeCuartel() {
		return estado.crearEspadachin(oro);
	}
	

}
