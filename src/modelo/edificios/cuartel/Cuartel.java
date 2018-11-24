package modelo.edificios.cuartel;

import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

import java.util.ArrayList;

public class Cuartel extends Edificio {

    private Oro oro;
    private EstadoCuartel estado = new EstadoCuartelEnConstruccion();
	
	public Cuartel(Oro nuevoOro) {
		this.vidaMaxima = 250;
		this.vida = 250;
		this.reparacion = 50;
		this.tamanio = 4;
		this.oro = nuevoOro;
        this.costo = 50;
        this.oro.restarOro(costo);
		this.posiciones = new ArrayList<>();
	}
	
	public void repararse() {
		estado.repararse(this);
	}

    public void recibirDanio(int valorDanio) {
		estado.recibirDanio(this, valorDanio);
	}

    public void terminoDeCrearse() {
		estado = new EstadoCuartelConstruido();
	}
	
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
