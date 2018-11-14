package modelo.mapa;

import edificios.Edificio;
import unidades.Unidad;

public class Casillero {

    private Unidad unidad;
    private Edificio edificio;

    public void colocarUnidad(Unidad unidad) {

        if (this.estaOcupado()) {
            throw new CasilleroOcupadoException();
        }
        this.unidad = unidad;
    }

    public void colocarEdificio(Edificio edificio) {

        if (this.estaOcupado()) {
            throw new CasilleroOcupadoException();
        }
        this.edificio = edificio;
    }

    public void desocupar() {
        this.unidad = null;
        this.edificio = null;
    }

    public boolean estaOcupado() {
        return (this.unidad != null || this.edificio != null);
    }

}
