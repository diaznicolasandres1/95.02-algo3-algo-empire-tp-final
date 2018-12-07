package modelo.edificios.cuartel;

import modelo.excepciones.EdificioSiendoReparadoException;
import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

import java.util.ArrayList;

public class Cuartel extends Edificio {

    private static final String NOMBRE_CLASE = "Cuartel";
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

    public void recibirDanio(int valorDanio) {
        this.estado.recibirDanio(this, valorDanio);
    }

    public Arquero crearArqueroDesdeCuartel() {
        return this.estado.crearArquero(this.oro);
    }

    public Espadachin crearEspadachinDesdeCuartel() {
        return this.estado.crearEspadachin(this.oro);
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
        this.estado = new EstadoCuartelConstruido();
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
