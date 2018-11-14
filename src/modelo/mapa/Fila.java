package modelo.mapa;

import java.util.ArrayList;

public class Fila {

    private ArrayList<Casillero> casilleros;

    public Fila() {
        casilleros = new ArrayList<>();
    }

    public void agregarCasilleros(ArrayList<Casillero> casilleros) {

        for (int i = 0; i < casilleros.size(); i++) {
            this.casilleros.add(casilleros.get(i));
        }
    }

    public Casillero buscarCasillero(int numeroColumna) {
        return casilleros.get(numeroColumna);
    }
}
