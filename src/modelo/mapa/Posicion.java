package modelo.mapa;

import modelo.excepciones.CoordenadasInvalidasException;
import modelo.excepciones.PosicionFueraDeRangoException;
import modelo.excepciones.DistanciaInvalidaException;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;

import java.util.ArrayList;

import static java.lang.Integer.max;
import static java.lang.Math.abs;

public class Posicion {

    private final int posX;
    private final int posY;

    public Posicion(int posX, int posY) {

        if (!this.sonCoordenadasValidas(posX, posY)) {
            throw new CoordenadasInvalidasException();
        }
        this.posX = posX;
        this.posY = posY;
    }

    public void moverUnidadHacia(Unidad unidad, Mapa mapa, Posicion destino, int distanciaMaxima) {
        if (!this.esDistanciaValida(distanciaMaxima)) {
            throw new DistanciaInvalidaException();
        }
        if (!this.estaDentroDeDistanciaMaxima(destino, distanciaMaxima)) {
            throw new PosicionFueraDeRangoException();
        }
        destino.moverUnidadConXeY(unidad, mapa, this.posX, this.posY);
    }

    public void descolocarColocable(Mapa mapa) {
        mapa.descolocarColocable(this.posY, this.posX);
    }

    public int calcularDistanciaA(Posicion posicion) {
        return posicion.calcularDistanciaConXeY(this.posX, this.posY);
    }

    public ArrayList<Colocable> buscarColocablesEnRangoDe(Mapa mapa, int rango) {
        return mapa.buscarColocablesEnRangoDe(this.posY, this.posX, rango);
    }

    public void colocarAlrededor(Mapa mapa, int tamanio, Unidad unidad) {
        mapa.colocarAlrededor(this.posY, this.posX, tamanio, unidad);
    }

    private boolean estaDentroDeDistanciaMaxima(Posicion otraPosicion, int distanciaMaxima) {
        return this.calcularDistanciaA(otraPosicion) <= distanciaMaxima;
    }

    private int calcularDistanciaConXeY(int posX, int posY) {
        return max(abs(posX - this.posX), abs(posY - this.posY));
    }

    private void moverUnidadConXeY(Unidad unidad, Mapa mapa, int xDeOrigen, int yDeOrigen) {
        mapa.moverUnidadDesdeHasta(unidad, yDeOrigen, xDeOrigen, this.posY, this.posX);
    }

    private boolean esDistanciaValida(int distancia) {
        return distancia > 0;
    }

    private boolean sonCoordenadasValidas(int posX, int posY) {
        return (posX >= 0 && posY >= 0);
    }

}

