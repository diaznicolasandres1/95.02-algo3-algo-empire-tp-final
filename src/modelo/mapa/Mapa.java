package modelo.mapa;

import modelo.edificios.Edificio;
import modelo.excepciones.CasilleroOcupadoException;
import modelo.excepciones.NoHayLugarSuficenteParaColocarEdificioException;
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
    private static final int BASE_MINIMA = 12;
    private static final int ALTURA_MINIMA = 12;

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

        double filasAUtilizar = sqrt(tamanioEdificio);
        double columnasAUtilizar = sqrt(tamanioEdificio);

        for (int i = 0; i < filasAUtilizar; i++) {
            for (int j = 0; j < columnasAUtilizar; j++) {
                try {
                    this.buscarFila(filaInicio + i).colocar(edificio, columnaInicio + j);
                } catch (CasilleroOcupadoException | IndexOutOfBoundsException e) {
                    this.descolocarEdificioParcialmenteColocadoEn(filaInicio, columnaInicio, i, j, tamanioEdificio);
                    throw new NoHayLugarSuficenteParaColocarEdificioException();
                }
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

    public void colocarAlrededor(int fila, int columna, int tamanioColocable, Unidad unidad) {

        int auxFila = fila - 1;
        int auxColumna = columna - 1;
        double filas = sqrt(tamanioColocable);
        double columnas = sqrt(tamanioColocable);
        boolean estaColocado = false;

        for (int i = 0; i < columnas + 2 && !estaColocado; i++) {
            for (int j = 0; j < filas + 2 && !estaColocado; j++) {
                try {
                    this.colocarUnidad(unidad, auxFila + i, auxColumna + j);
                    estaColocado = true;
                } catch (IndexOutOfBoundsException | CasilleroOcupadoException ignored) {
                }
            }
        }
    }
    
    public Colocable buscarColocableEn(int fila, int columna) {
        return this.buscarFila(fila).buscarColocableEn(columna);
    }

    public int getBase() {
        return this.base;
    }

    public int getAltura() {
        return this.altura;
    }

    private void agregarCasilleros() {

        for (int i = 0; i < this.altura; i++) {
            for (int j = 0; j < this.base; j++) {
                Casillero casillero = new Casillero();
                this.casilleros.add(casillero);
            }
        }
    }

    private void agregarFilas() {
        for (int i = 1; i <= this.altura; i++) {
            ArrayList<Casillero> casillerosEnFila = new ArrayList<>();
            for (int j = (i - 1) * this.base; j < i * this.base; j++) {
                casillerosEnFila.add(this.casilleros.get(j));
            }
            Fila fila = new Fila();
            fila.agregarCasilleros(casillerosEnFila);
            this.filas.add(fila);
        }
    }

    private Casillero buscarCasillero(int numeroFila, int numeroColumna) {

        Fila fila = this.buscarFila(numeroFila);
        return fila.buscarCasillero(numeroColumna);
    }

    private Fila buscarFila(int numeroFila) {
        return this.filas.get(numeroFila - 1);
    }

    private boolean esTamanioValido(int base, int altura) {
        return (base >= BASE_MINIMA && altura >= ALTURA_MINIMA);
    }

    private void descolocarEdificioParcialmenteColocadoEn(int filaInicio, int columnaInicio, int filasUtilizadas, int columnasUtilizadas, int tamanioEdificio) {

        double auxColumnasUtilizadas = columnasUtilizadas;
        if (filasUtilizadas >= 1) {
            auxColumnasUtilizadas = sqrt(tamanioEdificio) - 1;
        }

        descolocar:
        for (int i = 0; i <= filasUtilizadas; i++) {
            for (int j = 0; j <= auxColumnasUtilizadas; j++) {
                if (i == filasUtilizadas && j == columnasUtilizadas) {
                    break descolocar;
                }
                this.descolocarColocable(filaInicio + i, columnaInicio + j);
            }
        }
    }
}
