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

        this.buscarFila(fila).colocar(unidad, columna);
        Posicion posicion = new Posicion(columna, fila);
        unidad.setPosicion(posicion);
    }

    public void colocarEdificio(Edificio edificio, int tamanioEdificio, int fila, int columna) {

        int cantidadFilasAUtilizar = tamanioEdificio / 2;
        for (int i = 0; i <= cantidadFilasAUtilizar; i++) {
            this.buscarFila(fila + i).colocar(edificio, columna);
            this.buscarFila(fila + i).colocar(edificio, columna + i);
        }
    }

    public void moverUnidadDesdeHasta(Unidad unidad, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {

        Casillero casilleroOrigen = this.buscarCasillero(filaOrigen, columnaOrigen);
        Casillero casilleroDestino = this.buscarCasillero(filaDestino, columnaDestino);
        Posicion posicion = new Posicion(columnaDestino, filaOrigen);
        unidad.moverHacia(posicion);
        casilleroDestino.colocar(unidad);
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
            ArrayList<Casillero> casillerosEnFila = new ArrayList<>();
            for (int j = (i - 1) * base; j < i * base; j++) {
                casillerosEnFila.add(casilleros.get(j));
            }
            Fila fila = new Fila();
            fila.agregarCasilleros(casillerosEnFila);
            filas.add(fila);
        }
    }

    private Casillero buscarCasillero(int numeroFila, int numeroColumna) {

        Fila fila = this.buscarFila(numeroFila);
        return fila.buscarCasillero(numeroColumna);
    }

    private Fila buscarFila(int numeroFila) {
        return filas.get(numeroFila - 1);
    }

    private boolean esTamanioValido(int base, int altura) {

        return (base >= 12 && altura >= 12);
    }
}
