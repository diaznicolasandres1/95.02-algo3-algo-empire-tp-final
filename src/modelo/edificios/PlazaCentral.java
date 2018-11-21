package modelo.edificios;

import modelo.Oro;
import modelo.unidades.aldeano.Aldeano;

import java.util.ArrayList;

public class PlazaCentral extends Edificio {

    Oro oro;
    EstadoPlazaCentral estado = new EstadoPlazaCentralEnConstruccion();

    public PlazaCentral(Oro oroInicio) {
        this.vidaMaxima = 450;
        this.reparacion = 25;
        this.vida = 450;
        this.tamanio = 4;
        this.oro = oroInicio;
        this.oro.restarOro(100);
        this.posiciones = new ArrayList<>();
    }

    public void repararse() {
        estado.repararse(this);
    }

    public void recibirDanioPlazaCentral(int valorDanio) {
        estado.recibirDanio(this, valorDanio);
    }

    public Aldeano crearAldeanoDesdePlaza() {
        return estado.crearAldeano(oro);
    }

    /**/
    public void terminoDeCrearse() {
        estado = new EstadoPlazaCentralCreada();
    }

    public void avanzarTurno() {
        estado.avanzarTurno(this);
    }

}
