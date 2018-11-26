package modelo.juego;

import java.util.ArrayList;

import modelo.excepciones.LimiteDePoblacionAlcanzadoException;
import modelo.unidades.Unidad;

public class Poblacion {

    private ArrayList<Unidad> unidades;
    private static final int LIMITE_POBLACION = 50;

    public Poblacion() {
        this.unidades = new ArrayList<>();
    }

    public int getCantidad() {
        return this.unidades.size();
    }

    public void agregarUnidad(Unidad unidad) {
        if (!this.esCantidadDePoblacionValida())
            throw new LimiteDePoblacionAlcanzadoException();
        this.unidades.add(unidad);
    }

    public void removerUnidad(Unidad unidad) {
        this.unidades.remove(unidad);
    }

    private boolean esCantidadDePoblacionValida() {
        return this.unidades.size() < LIMITE_POBLACION;
    }

    public void avanzarTurno() {
        for (Unidad unidad : this.unidades) {
            unidad.avanzarTurno();
        }
    }

    public boolean perteneceUnidad(Unidad unidad) {
        return this.unidades.contains(unidad);
    }

}
