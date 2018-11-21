package modelo;

import java.util.ArrayList;
import modelo.unidades.Unidad;
import modelo.unidades.UnidadEstaMuertaException;


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
		ArrayList<Unidad> removibles = new ArrayList<>();
		for (Unidad unidad : this.unidades) {
			try {
				unidad.recibirDanio(0);
			}catch(UnidadEstaMuertaException e) {
				removibles.add(unidad);
			}finally {
				unidad.avanzarTurno();
			}
		}
		for (Unidad unidad : removibles) {
			this.unidades.remove(unidad);
		}
	}
	
	public boolean perteneceUnidad(Unidad unidad) {
		return this.unidades.contains(unidad);
	}
	
	
}
