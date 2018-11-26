package modelo.juego;

import java.util.ArrayList;
import modelo.edificios.Edificio;

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
        for (Edificio edificio : this.edificios) {
            edificio.avanzarTurno();
        }
    }

    public boolean perteneceEdificio(Edificio edificio) {
        return this.edificios.contains(edificio);
    }

    public void removerEdificio(Edificio edificio) {
        this.edificios.remove(edificio);
    }
}
