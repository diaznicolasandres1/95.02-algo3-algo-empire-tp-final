package modelo;

import java.util.ArrayList;
import modelo.unidades.Unidad;


public class Poblacion {
	private ArrayList<Unidad> unidades;
	private int limitePoblacion = 50;
	
	public Poblacion() {
		this.unidades = new ArrayList<>();
	}

	public int getCantidad() {
		return this.unidades.size();
	}
	
	public void agregarUnidad(Unidad unidad) {
		if(!this.verificarLimitePoblacion())
			throw new LimiteDePoblacionAlcanzadoException();
		this.unidades.add(unidad);
	}
	
	private boolean verificarLimitePoblacion() {
		return this.unidades.size() < limitePoblacion;
	}
	
	public void avanzarTurno() {
		for (Unidad unidad : this.unidades) {
			if (unidad == null)
				this.unidades.remove(unidad);
			else
				unidad.avanzarTurno();
		}
	}
	
	public boolean PerteneceUnidad(Unidad unidad) {
		return this.unidades.contains(unidad);
	}
	
	
}
