package edificios;

import unidades.Aldeano;

public class PlazaCentral extends Edificio {
	
	
	 	/* Se le asigna estado creada para poder hacer los primeros test
	 	 * luego refactorizamos  y empieza en estado: EnConstruccion y vemos como hacer los turnos*/
		EstadoPlazaCentral estado = new EstadoPlazaCentralCreada();

		public PlazaCentral () {
			vida = 450;
			costo = 100;
		}
		
		public void repararse() {
			estado.repararse(this);
		}
		
		
		public void recibirDanio(int valorDanio) {
			estado.recibirDanio(this, valorDanio);
			
		}
		
		public Aldeano crearAldeanoDesdePlaza() {
			return estado.crearAldeano();
			
		}
		
		
}
