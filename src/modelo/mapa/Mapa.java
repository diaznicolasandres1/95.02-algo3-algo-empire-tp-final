package modelo.mapa;

import edificios.Edificio;
import modelo.Posicion;
import unidades.Unidad;

import java.util.ArrayList;

public class Mapa {

    private ArrayList<Casillero> casilleros;
    private ArrayList<Fila> filas;
    private int base;
    private int altura;

    public Mapa(int base, int altura) {

        if (!this.esTamanioValido(base, altura)) {
            throw new TamanioInvalidoException();
        }

        casilleros = new ArrayList<>();
        filas = new ArrayList<>();
        this.base = base;
        this.altura = altura;
        this.agregarCasilleros();
        this.agregarFilas();
    }

    public void colocarUnidad(Unidad unidad, int fila, int columna) {

        Casillero casillero = this.buscarCasillero(fila, columna);
        Posicion posicion = new Posicion(columna, fila);
        casillero.colocarUnidad(unidad);
        unidad.setPosicion(posicion);
    }

    public void colocarEdificio(Edificio edificio, int tamanioEdificio, int fila, int columna) {

        ArrayList<Casillero> terreno = this.buscarCasillerosParaEdificio(tamanioEdificio, fila, columna);
        for (Casillero casillero : terreno) {
            casillero.colocarEdificio(edificio);
        }
    }

    public void moverUnidadDesdeHasta(Unidad unidad, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {

        Casillero casilleroOrigen = this.buscarCasillero(filaOrigen, columnaOrigen);
        Casillero casilleroDestino = this.buscarCasillero(filaDestino, columnaDestino);
        Posicion posicion = new Posicion(columnaDestino, filaOrigen);
        unidad.moverHacia(posicion);
        casilleroDestino.colocarUnidad(unidad);
        casilleroOrigen.desocupar();
    }

    private void agregarCasilleros() {

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Casillero casillero = new Casillero();
                casilleros.add(casillero);
            }
        }
    }

    private void agregarFilas() {
        for (int i = 1; i <= altura; i++) {
            ArrayList<Casillero> auxFila = new ArrayList<>();
            for (int j = (i - 1) * base; j < i * base; j++) {
                auxFila.add(casilleros.get(j));
            }
            Fila fila = new Fila();
            fila.agregarCasilleros(auxFila);
            filas.add(fila);
        }
    }

    private Casillero buscarCasillero(int numeroFila, int numeroColumna) {

        Fila fila = filas.get(numeroFila - 1);
        return fila.buscarCasillero(numeroColumna - 1);
    }

    private ArrayList<Casillero> buscarCasillerosParaEdificio(int tamanioEdificio, int filaInicio, int columnaInicio) {

        ArrayList<Casillero> terreno = new ArrayList<>();
        int cantidadFilasAUtilizar = tamanioEdificio / 2;

        for (int i = 0; i <= cantidadFilasAUtilizar; i++) {
            terreno.add(this.buscarCasillero(filaInicio + i, columnaInicio));
            terreno.add(this.buscarCasillero(filaInicio + i, columnaInicio + i));
        }
        return terreno;
    }

    private boolean esTamanioValido(int base, int altura) {

        return (base >= 12 && altura >= 12);
    }
}
