package modelo.juego;

import java.util.ArrayList;

import modelo.excepciones.LimiteDePoblacionAlcanzadoException;
import modelo.unidades.Colocable;

public class Poblacion {

    private ArrayList<Colocable> unidades;
    private static final int LIMITE_POBLACION = 50;

    public Poblacion() {
        this.unidades = new ArrayList<>();
    }

    public int getCantidad() {
        return this.unidades.size();
    }

    public void agregarUnidad(Colocable unidad) {
        if (!this.esCantidadDePoblacionValida())
            throw new LimiteDePoblacionAlcanzadoException();
        this.unidades.add(unidad);
    }

    public void removerUnidad(Colocable unidad) {
        this.unidades.remove(unidad);
    }

    private boolean esCantidadDePoblacionValida() {
        return this.unidades.size() < LIMITE_POBLACION;
    }

    public void avanzarTurno() {
        for (Colocable unidad : this.unidades) {
            unidad.avanzarTurno();
        }
    }

    public boolean perteneceUnidad(Colocable unidad) {
        return this.unidades.contains(unidad);
    }

}
