package Unidades;

import Modelo.Oro;

public class Aldeano extends Unidad {
	
	
	
	private EstadoAldeano estado = new EstadoAldeanoDisponible();
	
	public Aldeano() {
		vida = 50;
		costo = 25;
	}
	

	public void recolectarOro(Oro oro) {
		estado.recolectarOro(oro);
	}
	 @Override
	 public void estarOcupado() {
		 estado = new EstadoAldeanoOcupado();
	 }
	 
	 @Override
	 public void estarDisponible() {
		 estado = new EstadoAldeanoDisponible();
	 }

}
