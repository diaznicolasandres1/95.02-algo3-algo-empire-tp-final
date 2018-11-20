package modelo.mapa;

import modelo.Posicion;
import modelo.edificios.Edificio;
import modelo.unidades.Unidad;

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
        unidad.setPosicion(new Posicion(columna, fila));
    }

    public void colocarEdificio(Edificio edificio, int tamanioEdificio, int filaInicio, int columnaInicio) {

        int cantidadFilasAUtilizar = tamanioEdificio / 2;
        for (int i = 0; i < cantidadFilasAUtilizar; i++) {
            this.buscarFila(filaInicio + i).colocar(edificio, columnaInicio);
            this.buscarFila(filaInicio + i).colocar(edificio, columnaInicio + 1);
        }
    }

    public void moverUnidadDesdeHasta(Unidad unidad, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {

        Casillero casilleroOrigen = this.buscarCasillero(filaOrigen, columnaOrigen);
        Casillero casilleroDestino = this.buscarCasillero(filaDestino, columnaDestino);
        casilleroDestino.colocar(unidad);
        unidad.setPosicion(new Posicion(columnaDestino, filaDestino));
        casilleroOrigen.desocupar();
    }

    public void descolocarUnidad(int fila, int columna) {
        this.buscarFila(fila).descolocar(columna);
    }

    public void descolocarEdificio(int tamanioEdificio, int filaInicio, int columnaInicio) {

        int cantidadFilasOcupadas = tamanioEdificio / 2;
        for (int i = 0; i < cantidadFilasOcupadas; i++) {
            this.buscarFila(filaInicio + i).descolocar(columnaInicio);
            this.buscarFila(filaInicio + i).descolocar(columnaInicio + 1);
        }
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
