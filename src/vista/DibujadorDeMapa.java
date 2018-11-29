package vista;

import controlador.BotonCasilleroEventHandler;
import javafx.scene.layout.GridPane;
import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.juego.Juego;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.aldeano.Aldeano;

public class DibujadorDeMapa {

    private GridPane tablero;
    private Juego juego;

    public DibujadorDeMapa(Juego juego, GridPane tablero){
        this.juego = juego;
        this.tablero = tablero;

    }

    public void dibujarMapaConCasilleroHandler(ContenedorPrincipal contenedor){
        Mapa mapa = this.juego.getMapa();
        int base = mapa.getBase();
        int altura = mapa.getAltura();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Colocable colocable = juego.getColocable(i+1,j+1);
                Boton botonCasillero = new Boton("", new BotonCasilleroEventHandler(this.juego, i + 1, j + 1,contenedor));

                if(colocable instanceof Aldeano){
                    botonCasillero = new Boton("A", new BotonCasilleroEventHandler(this.juego, i + 1, j + 1,contenedor));
                    botonCasillero.setStyle("-fx-background-color: green");

                }
                else if(colocable instanceof Castillo) {
                    botonCasillero = new Boton("C", new BotonCasilleroEventHandler(this.juego, i + 1, j + 1,contenedor));
                    botonCasillero.setStyle("-fx-background-color: blue");
                }
                else if(colocable instanceof PlazaCentral) {
                    botonCasillero = new Boton("P", new BotonCasilleroEventHandler(this.juego, i + 1, j + 1,contenedor));
                    botonCasillero.setStyle("-fx-background-color: red");
                }
                else if(colocable instanceof Cuartel) {
                    botonCasillero = new Boton("c", new BotonCasilleroEventHandler(this.juego, i + 1, j + 1,contenedor));
                    botonCasillero.setStyle("-fx-background-color: yellow");
                }
                this.tablero.add(botonCasillero, j, i, 1, 1);
                botonCasillero.setPrefSize(30, 30);
            }
        }
    }
}
