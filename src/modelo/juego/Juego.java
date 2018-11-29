package modelo.juego;

import modelo.unidades.Atacante;
import modelo.unidades.Colocable;
import modelo.edificios.Edificio;
import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.unidades.Unidad;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;

import java.util.Random;

public class Juego {

    private Jugador jugadorActual;
    private Mapa mapa;
    private static final int BASE_MAPA = 25;
    private static final int ALTURA_MAPA = 25;

    public Juego(String nombre1, String nombre2) {

        this.mapa = new Mapa(BASE_MAPA, ALTURA_MAPA);
        Jugador unJugador = new Jugador(nombre1, this.mapa, 1, 1, 1, 6);
        Jugador otroJugador = new Jugador(nombre2, this.mapa, ALTURA_MAPA - 3, BASE_MAPA - 3, ALTURA_MAPA - 1, BASE_MAPA - 6);
        unJugador.setOponente(otroJugador);
        otroJugador.setOponente(unJugador);
        if (new Random().nextBoolean()) {
            this.jugadorActual = unJugador;
        } else {
            this.jugadorActual = otroJugador;
        }
    }

    /*-----Metodos getter-----*/

    public String getNombreJugadorActual() {
        return this.jugadorActual.getNombre();
    }

    public Colocable getColocable(int fila, int columna) {
        return this.mapa.buscarColocableEn(fila, columna);
    }

    /*-----Metodos de Edificios-----*/

    public void crearAldeano(PlazaCentral plaza) {
        jugadorActual.crearAldeano(plaza);
    }

    public void crearEspadachin(Cuartel cuartel) {
        jugadorActual.crearEspadachin(cuartel);
    }

    public void crearArquero(Cuartel cuartel) {
        this.jugadorActual.crearArquero(cuartel);
    }

    public void crearArmaDeAsedio(Castillo castillo) {
        this.jugadorActual.crearArmaDeAsedio(castillo);
    }

/*-----Metodos de Aldeano-----*/

    public void construirCuartel(Aldeano aldeano, int fila, int columna) {
        this.jugadorActual.construirCuartel(aldeano, fila, columna);
    }

    public void construirPlazaCentral(Aldeano aldeano, int fila, int columna) {
        this.jugadorActual.construirPlazaCentral(aldeano, fila, columna);
    }
    
    public void repararEdificio(Aldeano aldeano, Edificio edificio) {
        this.jugadorActual.repararEdificio(aldeano, edificio);
    }

    /*-----Metodos de Atacante-----*/

    public void atacar(Atacante atacante, Colocable objetivo) {
        this.jugadorActual.atacar(atacante, objetivo);
    }


    /*-----Metodos Otros-----*/

    public void moverUnidadHacia(Unidad unidad, int fila, int columna) {
        this.jugadorActual.moverUnidadHacia(unidad, fila, columna);
    }

    public void cambiarTurno() {
        this.jugadorActual = this.jugadorActual.avanzarTurno();
    }

    public void montarArma(ArmaDeAsedio arma){
        this.jugadorActual.montarArma(arma);
    }

    public void desmontarArma(ArmaDeAsedio arma){
        this.jugadorActual.desmontarArma(arma);
    }

    public Mapa getMapa() {
        return this.mapa;
    }
}
