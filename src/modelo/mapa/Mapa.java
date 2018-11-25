package modelo.mapa;

import modelo.edificios.Edificio;
import modelo.excepciones.TamanioInvalidoException;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;

import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class Mapa {

    private ArrayList<Casillero> casilleros;
    private ArrayList<Fila> filas;
    private int base;
    private int altura;

    public Mapa(int base, int altura) {

        if (!this.esTamanioValido(base, altura)) {
            throw new TamanioInvalidoException();
        }

        this.casilleros = new ArrayList<>();
        this.filas = new ArrayList<>();
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

        double cantidadFilasAUtilizar = sqrt(tamanioEdificio);
        double cantidadColumnasAUtilizar = sqrt(tamanioEdificio);

        for (int i = 0; i < cantidadFilasAUtilizar; i++) {
            for (int j = 0; j < cantidadColumnasAUtilizar; j++) {
                this.buscarFila(filaInicio + i).colocar(edificio, columnaInicio + j);
                edificio.agregarPosicion(new Posicion(columnaInicio + j, filaInicio + i));
            }
        }
    }

    public void moverUnidadDesdeHasta(Unidad unidad, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {

        Casillero casilleroOrigen = this.buscarCasillero(filaOrigen, columnaOrigen);
        Casillero casilleroDestino = this.buscarCasillero(filaDestino, columnaDestino);
        casilleroDestino.colocar(unidad);
        unidad.setPosicion(new Posicion(columnaDestino, filaDestino));
        casilleroOrigen.desocupar();
    }

    public void descolocarColocable(int fila, int columna) {
        this.buscarFila(fila).descolocar(columna);
    }

    // Ugly code as f*ck incoming, no me juzguen D:
    public ArrayList<Colocable> buscarColocablesEnRangoDe(int fila, int columna, int rango) {

        int auxFila = fila - rango;
        int auxColumna = columna - rango;
        ArrayList<Colocable> colocablesEnRango = new ArrayList<>();

        for (int i = 0; i < 6 + (rango * 2); i++) {
            for (int j = 0; j < 5 + (rango * 2); j++) {
                Colocable colocable;
                try {
                    colocable = this.buscarColocableEn(auxFila + i, auxColumna + j);
                    if (colocable == null) {
                        continue;
                    } else if (colocablesEnRango.contains(colocable)) {
                        continue;
                    }
                } catch (IndexOutOfBoundsException fueraDelRangoDelMapa) {
                    continue;
                }
                colocablesEnRango.add(colocable);
            }
        }
        return colocablesEnRango;
    }

    public void colocarAlrededor(int fila, int columna, int tamanio, Unidad unidad) {

        int auxFila = fila - 1;
        int auxColumna = columna - 1;
        double altura = sqrt(tamanio);
        double base = sqrt(tamanio);
        
        for (int i = 0; i < base + 2; i++) {
            for (int j = 0; j < altura + 2; j++) {
                try {
                    if(this.buscarColocableEn(auxFila + i, auxColumna + j) == null) {
                        this.buscarCasillero(auxFila + i, auxColumna + j).colocar(unidad);
                        unidad.setPosicion(new Posicion (columna + j, fila + i));
                        return;
                    }
                } catch (IndexOutOfBoundsException fueraDelRangoDelMapa) {
                    continue;
                }
            }
        }
    }
    
    public Colocable buscarColocableEn(int fila, int columna) {
        return this.buscarFila(fila).buscarColocableEn(columna);
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
