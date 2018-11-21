package modelo;

import java.util.ArrayList;
import modelo.edificios.Edificio;
import modelo.edificios.UnidadFueDestruidaException;

public class Estructuras {

	private ArrayList<Edificio> edificios;
	
	public Estructuras() {
		this.edificios = new ArrayList<>();
	}

	public int getCantidad() {
		return this.edificios.size();
	}

	public void agregarEdificio(Edificio edificio) {
		this.edificios.add(edificio);
	}

	public void avanzarTurno() {
		ArrayList<Edificio> removibles = new ArrayList<>();
		for (Edificio edificio : this.edificios) {
			try {
				edificio.recibirDanio(0);
			}catch(UnidadFueDestruidaException e) {
				removibles.add(edificio);
			}finally {
				edificio.avanzarTurno();
			}
		}
		for (Edificio edificio : removibles) {
			this.edificios.remove(edificio);
		}
	}
	
	public boolean perteneceEdificio(Edificio edificio) {
		return this.edificios.contains(edificio);
	}
	
}
