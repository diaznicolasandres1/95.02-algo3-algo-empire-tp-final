package vista;

import controlador.CasilleroEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.juego.Juego;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;

public class DibujadorDeMapa {

    private final GridPane tablero;
    private final Juego juego;
    private final String jugadorUno;
    private final String jugadorDos;
    private static final String RUTA_PASTO = "file:src/vista/imagenes/pasto.png";
    private static final int TAMANIO_ANCHO_DE_BOTON = 35;
    private static final int TAMANIO_ALTO_DE_BOTON = 35;

    public DibujadorDeMapa(Juego juego, GridPane tablero, String jugadorUno, String jugadorDos) {
        this.juego = juego;
        this.tablero = tablero;
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
    }

    public void dibujarMapaConCasilleroHandler(ContenedorPrincipal contenedor) {
        Mapa mapa = this.juego.getMapa();
        int base = mapa.getBase();
        int altura = mapa.getAltura();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Colocable colocable = this.juego.getColocable(i + 1, j + 1);
                Button botonCasillero = new Button("");
                botonCasillero.setOnAction(new CasilleroEventHandler(this.juego, i + 1, j + 1, contenedor));
                this.dibujarColocable(colocable, botonCasillero);
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }

    public void dibujarColocable(Colocable colocable, Button botonCasillero) {

        if (colocable == null) {
            Image pasto = new Image(RUTA_PASTO, TAMANIO_ANCHO_DE_BOTON, TAMANIO_ALTO_DE_BOTON, true, true);
            botonCasillero.setGraphic(new ImageView(pasto));
            botonCasillero.setStyle("-fx-padding: 0");
            botonCasillero.setPrefSize(TAMANIO_ANCHO_DE_BOTON, TAMANIO_ALTO_DE_BOTON);
            return;
        }

        String nombreColocable = colocable.getNombreClase();

        if (this.jugadorUno.equals(this.juego.getNombreJugadorDuenioDe(colocable))) {
            Image imagen = new Image("file:src/vista/imagenes/" + nombreColocable + "_jugador_uno.jpg", TAMANIO_ANCHO_DE_BOTON, TAMANIO_ALTO_DE_BOTON, false, true);
            botonCasillero.setGraphic(new ImageView(imagen));
        } else {
            Image imagen = new Image("file:src/vista/imagenes/" + nombreColocable + "_jugador_dos.jpg", TAMANIO_ANCHO_DE_BOTON, TAMANIO_ALTO_DE_BOTON, false, true);
            botonCasillero.setGraphic(new ImageView(imagen));
        }
        botonCasillero.setStyle("-fx-padding: 0");
        botonCasillero.setPrefSize(TAMANIO_ANCHO_DE_BOTON, TAMANIO_ALTO_DE_BOTON);
    }
}
