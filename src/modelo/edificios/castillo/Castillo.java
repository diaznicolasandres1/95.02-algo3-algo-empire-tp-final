package modelo.edificios.castillo;

import modelo.excepciones.CastilloFueDestruidoException;
import modelo.excepciones.EdificioSiendoReparadoException;
import modelo.unidades.Atacable;
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
    public void finalizarTurno() {
        // Castillo no maneja turnos.
    }
	
	@Override
	public void terminoDeCrearse() {
        // Ya empieza construido.
	}

	public ArmaDeAsedio crearArmaDeAsedio() {
        return new ArmaDeAsedio(this.oro);
	}	
	
	public void atacarAlrededor(Mapa mapa) {
        ArrayList<Colocable> colocables = this.getColocablesAlrededor(mapa);
        this.atacarAColocables(colocables);
    }

    public void atacar(Atacable objetivo) {
        objetivo.recibirDanio(this);
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

    public void reducirVida(int danio) {
        this.vida -= danio;
        if (this.vida <= 0) {
            throw new CastilloFueDestruidoException();
        }
    }

    @Override
	public void recibirDanio(Castillo castillo) {
        // Castillo no recibe daño si lo ataca castillo
    }

    public ArrayList<Colocable> getColocablesAlrededor(Mapa mapa) {
        ArrayList<Colocable> colocables = this.posiciones.get(0).buscarColocablesEnRangoDe(mapa, RANGO_DE_ATAQUE);
        colocables.remove(this);
        return colocables;
    }

    public void atacarAColocables(ArrayList<Colocable> colocables) {
        for (Colocable colocable : colocables) {
            this.atacar((Atacable) colocable);
        }
    }
}
