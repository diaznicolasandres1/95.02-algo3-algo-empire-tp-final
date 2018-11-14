package edificios;

import modelo.Oro;
import unidades.Aldeano;

public class PlazaCentral extends Edificio {
	
		
		 Oro oro;
		EstadoPlazaCentral estado = new EstadoPlazaCentralEnConstruccion();
	    private int tamanio;

		public PlazaCentral (Oro oroInicio) {
			vidaMaxima = 450;
			reparacion =25;
			vida = 450;			
			tamanio = 4;
			oro = oroInicio;
			oro.restarOro(100);
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
