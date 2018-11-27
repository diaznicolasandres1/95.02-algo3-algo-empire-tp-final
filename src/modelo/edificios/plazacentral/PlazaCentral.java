package modelo.edificios.plazacentral;

import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.aldeano.Aldeano;

import java.util.ArrayList;

public class PlazaCentral extends Edificio {

    private Oro oro;
    private EstadoPlazaCentral estado = new EstadoPlazaCentralEnConstruccion();

    public PlazaCentral(Oro oroInicio) {
        this.vidaMaxima = 450;
        this.reparacion = 25;
        this.vida = 450;
        this.tamanio = 4;
        this.oro = oroInicio;
        this.costo = 100;
        this.oro.restarOro(costo);
        this.posiciones = new ArrayList<>();
        this.unidadReparando = null;
    }

    public void repararse() {
        estado.repararse(this);
    }

    public void recibirDanio(int valorDanio) {
        estado.recibirDanio(this, valorDanio);
    }

    public Aldeano crearAldeanoDesdePlaza() {
        return estado.crearAldeano(oro);
    }

    @Override
    public void terminoDeCrearse() {
        estado = new EstadoPlazaCentralCreada();
    }

    @Override
    public void avanzarTurno() {
        estado.avanzarTurno(this);
    }
}
