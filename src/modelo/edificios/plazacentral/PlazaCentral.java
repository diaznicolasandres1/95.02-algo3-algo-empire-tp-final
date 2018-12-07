package modelo.edificios.plazacentral;

import modelo.excepciones.EdificioSiendoReparadoException;
import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.aldeano.Aldeano;

import java.util.ArrayList;

public class PlazaCentral extends Edificio {

    static final String NOMBRE_CLASE = "Plaza central";
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

    public void recibirDanio(int valorDanio) {
        this.estado.recibirDanio(this, valorDanio);
    }

    public Aldeano crearAldeanoDesdePlaza() {
        return this.estado.crearAldeano(this.oro);
    }

    @Override
    public void repararse(Aldeano aldeano) {
        if (this.aldeanoReparando == null) {
            this.aldeanoReparando = aldeano;
        }
        if (this.aldeanoReparando != aldeano) {
            throw new EdificioSiendoReparadoException();
        }
        this.estado.reparar(this);
    }

    @Override
    public void terminoDeCrearse() {
        this.estado = new EstadoPlazaCentralCreada();
    }

    @Override
    public void finalizarTurno() {
        this.estado.avanzarTurno(this);
    }

    @Override
    public String getNombreClase() {
        return NOMBRE_CLASE;
    }
    
    @Override
    public String getNombreEstado() {
        return this.estado.getNombreEstado();
    }
}
