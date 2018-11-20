package modelo.unidades;

import modelo.Ataque;
import modelo.Oro;
import modelo.edificios.Edificio;

public class Arquero extends Unidad implements Ataque {
	
	public Arquero(Oro oro) {
		vida = 75;
		oro.restarOro(75);
	}

	@Override
	public void atacar(Edificio edificio) {
		edificio.recibirDanioConValor(10);
		
	}

	@Override
	public void atacar(Unidad unidad) {
		unidad.recibirDanio(10);
		
	}
}
