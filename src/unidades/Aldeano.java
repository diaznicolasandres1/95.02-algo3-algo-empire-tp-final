package unidades;

import edificios.Cuartel;
import edificios.PlazaCentral;
import modelo.Oro;

public class Aldeano extends Unidad  {
	
	
	
	private EstadoAldeano estado = new EstadoAldeanoDisponible();
	

	
	public Aldeano() {
		vida = 50;
		costo = 25;
	}
	

	public void recolectarOro(Oro oro) {
		estado.recolectarOro(oro);
	}

	 public void estarOcupado(int turnosOcupado){
		 estado = new EstadoAldeanoOcupado(turnosOcupado);
	 }
	 public Cuartel construirCuartel() {

		 return estado.construirCuartel(this,3);
	 }
	 
	 public PlazaCentral construirPlazaCentral() {
		 return estado.construirPlazaCentral(this,3);
	 }

	 public void estarDisponible() {
		 
		 estado = new EstadoAldeanoDisponible();
	 }

	public void avanzarTurno() {		
		estado.avanzarTurno(this);
	}
	public void aldeanoSeLibero() {
		estado = new EstadoAldeanoDisponible();
		
	}
}
