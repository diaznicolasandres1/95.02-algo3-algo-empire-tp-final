package modelo.mapa;

import edificios.Edificio;
import unidades.Unidad;

import java.util.ArrayList;

public class Fila {

    private ArrayList<Casillero> casilleros;

    public Fila() {
        casilleros = new ArrayList<>();
    }

    public void agregarCasilleros(ArrayList<Casillero> casilleros) {

        this.casilleros.addAll(casilleros);
    }

    public Casillero buscarCasillero(int numeroColumna) {
        return casilleros.get(numeroColumna);
    }

    public void colocarUnidad(Unidad unidad, int columna) {
        casilleros.get(columna - 1).colocarUnidad(unidad);
    }

    public void colocarEdificio(Edificio edificio, int columna) {
        casilleros.get(columna - 1).colocarEdificio(edificio);
    }
}
