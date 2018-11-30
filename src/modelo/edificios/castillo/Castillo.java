package modelo.edificios.castillo;

import modelo.excepciones.EdificioSiendoReparadoException;
import modelo.unidades.Atacante;
import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;

import java.util.ArrayList;

public class Castillo extends Edificio implements Atacante {

    private static final int RANGO_DE_ATAQUE = 5;
	
	public Castillo(Oro oro) {
		this.vidaMaxima = 1000;
		this.vida = 1000;
		this.reparacion = 15;
		this.tamanio = 16;
        this.oro = oro;
		this.posiciones = new ArrayList<>();
        this.aldeanoReparando = null;
    }

    @Override
    public void avanzarTurno() {
        // Castillo no maneja turnos.
    }
	
	@Override
	public void terminoDeCrearse() {
        // Ya empieza construido.
	}

	public ArmaDeAsedio crearArmaDeAsedio() {
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(oro) ;
		return armaDeAsedio;	
	}	
	
	public void atacarAlrededor(Mapa mapa) {
        ArrayList<Colocable> colocables = this.buscarColocablesEnRango(mapa);
        this.atacarAColocables(colocables);
    }

    public void atacar(Colocable colocable) {
        colocable.recibirDanio(this);
    }

    @Override
    public void repararse(Aldeano aldeano) {
        if (this.aldeanoReparando == null) {
            this.aldeanoReparando = aldeano;
        }
        if (this.aldeanoReparando != aldeano) {
            throw new EdificioSiendoReparadoException();
        }
        this.incrementarVida();
    }

    @Override
	public void recibirDanio(Castillo castillo) {
        // Castillo no recibe daño si lo ataca castillo
    }

    private ArrayList<Colocable> buscarColocablesEnRango(Mapa mapa) {
        return this.posiciones.get(0).buscarColocablesEnRangoDe(mapa, RANGO_DE_ATAQUE);
    }

    private void atacarAColocables(ArrayList<Colocable> colocables) {
        for (Colocable colocable : colocables) {
            this.atacar(colocable);
        }
    }
}
