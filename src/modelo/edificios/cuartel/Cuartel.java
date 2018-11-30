package modelo.edificios.cuartel;

import modelo.excepciones.EdificioSiendoReparadoException;
import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

import java.util.ArrayList;

public class Cuartel extends Edificio {

    private EstadoCuartel estado = new EstadoCuartelEnConstruccion();

    public Cuartel(Oro nuevoOro) {
        this.vidaMaxima = 250;
        this.vida = 250;
        this.reparacion = 50;
        this.tamanio = 4;
        this.oro = nuevoOro;
        this.costo = 50;
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

    @Override
    public void terminoDeCrearse() {
        estado = new EstadoCuartelConstruido();
    }

    @Override
    public void avanzarTurno() {
        estado.avanzarTurno(this);
    }

    public Arquero crearArqueroDesdeCuartel() {
        return estado.crearArquero(oro);
    }

    public Espadachin crearEspadachinDesdeCuartel() {
        return estado.crearEspadachin(oro);
    }
}
