package edificios;

import modelo.Oro;
import unidades.Aldeano;

public class PlazaCentral extends Edificio {
	
		
		 Oro oro;
		EstadoPlazaCentral estado = new EstadoPlazaCentralEnConstruccion();
	    private int tamanio;

		public PlazaCentral (Oro oroInicio) {
			vida = 450;
			costo = 100;
			tamanio = 4;
			oro = oroInicio;
			oro.restarOro(costo);
		}
		
		public void repararse() {
			estado.repararse(this);
		}		
		
		public void recibirDanio(int valorDanio) {
			estado.recibirDanio(this, valorDanio);
			
		}
		
		public Aldeano crearAldeanoDesdePlaza() {
			return estado.crearAldeano(oro);
			
		}
		
		/**/
		
		public void terminoDeCrearse() {
			estado = new EstadoPlazaCentralCreada();
		}
		
		public void avanzarTurno() {
			estado.avanzarTurno(this);
		}
		
}
