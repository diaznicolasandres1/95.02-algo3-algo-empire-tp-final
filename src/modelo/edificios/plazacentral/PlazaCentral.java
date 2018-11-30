package modelo.edificios.plazacentral;

import modelo.excepciones.EdificioSiendoReparadoException;
import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.aldeano.Aldeano;

import java.util.ArrayList;

public class PlazaCentral extends Edificio {

    private EstadoPlazaCentral estado = new EstadoPlazaCentralEnConstruccion();

    public PlazaCentral(Oro oroInicio) {
        this.vidaMaxima = 450;
        this.reparacion = 25;
        this.vida = 450;
        this.tamanio = 4;
        this.oro = oroInicio;
        this.costo = 100;
        this.oro.restarOro(this.costo);
        this.posiciones = new ArrayList<>();
        this.aldeanoReparando = null;
    }

    @Override
    public void repararse(Aldeano aldeano) {
        if (this.aldeanoReparando == null) {
            this.aldeanoReparando = aldeano;
        }
        if (this.aldeanoReparando != aldeano) {
            throw new EdificioSiendoReparadoException();
        }
        estado.reparar(this);
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
