package modelo.juego;

import modelo.excepciones.OroInsuficienteException;

public class Oro {

    private int cantidadOro;

    public Oro(int cantidadInicial) {
        this.cantidadOro = cantidadInicial;
    }

    public void sumarOro(int cantidadSumar) {
        this.cantidadOro += cantidadSumar;
    }

    public void restarOro(int cantidadRestar) {
        if (cantidadRestar > this.cantidadOro) {
            throw new OroInsuficienteException();
        }
        this.cantidadOro -= cantidadRestar;
    }

    public int getOro() {
        return this.cantidadOro;
    }
}
