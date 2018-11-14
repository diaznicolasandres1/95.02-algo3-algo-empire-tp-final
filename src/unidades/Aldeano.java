package unidades;

import edificios.Cuartel;
import edificios.PlazaCentral;
import modelo.Oro;

public class Aldeano extends Unidad  {
	
	Oro oro ;
	
	private EstadoAldeano estado = new EstadoAldeanoDisponible();
	

	
	public Aldeano(Oro oroNuevo) {
		vida = 50;		
		oro = oroNuevo;
		oro.restarOro(25);
	}
	

	

	 public void estarOcupado(int turnosOcupado){
		 estado = new EstadoAldeanoOcupado(turnosOcupado);
	 }
	 
	 public Cuartel construirCuartel() {

		 return estado.construirCuartel(this,3,oro);
	 }
	 
	 public PlazaCentral construirPlazaCentral() {
		 return estado.construirPlazaCentral(this,3,oro);
	 }

	 public void estarDisponible() {
		 
		 estado = new EstadoAldeanoDisponible();
	 }

	public void avanzarTurno() {
		estado.recolectarOro(oro);
		estado.avanzarTurno(this);
	}
	public void aldeanoSeLibero() {
		estado = new EstadoAldeanoDisponible();
		
	}
}
