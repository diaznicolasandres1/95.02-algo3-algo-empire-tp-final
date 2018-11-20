package modelo;

import modelo.edificios.Edificio;
import modelo.unidades.Unidad;

public interface Ataque {
	
	public void atacar(Edificio Edificio);
	public void atacar(Unidad Unidad);

}
