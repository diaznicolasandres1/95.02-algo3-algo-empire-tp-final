package vista;

import controlador.BotonMoverUnidadHaciaInicioEventHandler;
import controlador.botonesaldeano.BotonConstruirCuartelInicioEventHandler;
import controlador.botonesaldeano.BotonConstruirPlazaCentralInicioEventHandler;
import controlador.botonesaldeano.BotonRepararEdificioInicioEventHandler;
import controlador.botonesarmadeasedio.BotonDesmontarArmaEventHandler;
import controlador.botonesarmadeasedio.BotonMontarArmaEventHandler;
import controlador.botonesataque.BotonAtacarInicioEventHandler;
import controlador.botonesdeedificios.BotonCrearAldeanoEventHandler;
import controlador.botonesdeedificios.BotonCrearArmaDeAsedioEventHandler;
import controlador.botonesdeedificios.BotonCrearArqueroEventHandler;
import controlador.botonesdeedificios.BotonCrearEspadachinEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.edificios.castillo.Castillo;
import modelo.edificios.cuartel.Cuartel;
import modelo.edificios.plazacentral.PlazaCentral;
import modelo.juego.Juego;
import modelo.unidades.Atacante;
import modelo.unidades.Unidad;
import modelo.unidades.aldeano.Aldeano;
import modelo.unidades.armadeasedio.ArmaDeAsedio;

import java.util.ArrayList;

public class CreadorDeBotones {

    public ArrayList<Button> crearBotonesPara(Aldeano aldeano, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        BotonConstruirCuartelInicioEventHandler cuartelEventHandler = new BotonConstruirCuartelInicioEventHandler(juego, aldeano, contenedor);
        Button construirCuartel = new Button("Construir Cuartel: 50 oro");
        Image martillo = new Image("file:src/vista/imagenes/martillo.png", 18, 18, true, true);
        construirCuartel.setGraphic(new ImageView(martillo));
        construirCuartel.setOnAction(cuartelEventHandler);
        botones.add(construirCuartel);

        BotonConstruirPlazaCentralInicioEventHandler plazaCentralEventHandler = new BotonConstruirPlazaCentralInicioEventHandler(aldeano, contenedor);
        Button construirPlaza = new Button("Constuir Plaza Central: 100 oro");
        construirPlaza.setGraphic(new ImageView(martillo));
        construirPlaza.setOnAction(plazaCentralEventHandler);
        botones.add(construirPlaza);

        BotonRepararEdificioInicioEventHandler repararEdificioInicioEventHandler = new BotonRepararEdificioInicioEventHandler(aldeano, contenedor);
        Button repararEdificio = new Button("Reparar edificio");
        Image llave = new Image("file:src/vista/imagenes/llave_inglesa.png", 18, 18, true, true);
        repararEdificio.setGraphic(new ImageView(llave));
        repararEdificio.setOnAction(repararEdificioInicioEventHandler);
        botones.add(repararEdificio);

        BotonMoverUnidadHaciaInicioEventHandler moverHandler = new BotonMoverUnidadHaciaInicioEventHandler(aldeano, contenedor);
        Button moverAldeano = new Button("Mover unidad");
        Image flecha = new Image("file:src/vista/imagenes/flecha.png", 18, 18, true, true);
        moverAldeano.setGraphic(new ImageView(flecha));
        moverAldeano.setOnAction(moverHandler);
        botones.add(moverAldeano);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(Cuartel cuartel, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        BotonCrearArqueroEventHandler arqueroHandler = new BotonCrearArqueroEventHandler(juego, cuartel, contenedor);
        Button crearArquero = new Button("Crear arquero: 75 oro");
        crearArquero.setOnAction(arqueroHandler);
        botones.add(crearArquero);

        BotonCrearEspadachinEventHandler espadachinEventHandler = new BotonCrearEspadachinEventHandler(juego, cuartel, contenedor);
        Button crearEspadachin = new Button("Crear espadachin: 50 oro");
        crearEspadachin.setOnAction(espadachinEventHandler);
        botones.add(crearEspadachin);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(ArmaDeAsedio armaDeAsedio, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        BotonMontarArmaEventHandler montarArmaEventHandler = new BotonMontarArmaEventHandler(juego, armaDeAsedio, contenedor);
        Button montarArma = new Button("Montar arma de asedio");
        Image montar = new Image("file:src/vista/imagenes/montar.png", 18, 18, true, true);
        montarArma.setGraphic(new ImageView(montar));
        montarArma.setOnAction(montarArmaEventHandler);
        botones.add(montarArma);

        BotonDesmontarArmaEventHandler desmontarArmaEventHandler = new BotonDesmontarArmaEventHandler(juego, armaDeAsedio, contenedor);
        Button desmontarArma = new Button("Desmontar arma de asedio");
        Image desmontar = new Image("file:src/vista/imagenes/desmontar.png", 18, 18, true, true);
        montarArma.setGraphic(new ImageView(desmontar));
        desmontarArma.setOnAction(desmontarArmaEventHandler);
        botones.add(desmontarArma);

        BotonAtacarInicioEventHandler atacarInicioEventHandler = new BotonAtacarInicioEventHandler(armaDeAsedio, contenedor);
        Button atacar = new Button("Atacar");
        atacar.setOnAction(atacarInicioEventHandler);
        Image espadas = new Image("file:src/vista/imagenes/espadas.png", 18, 18, true ,true);
        atacar.setGraphic(new ImageView(espadas));
        botones.add(atacar);

        BotonMoverUnidadHaciaInicioEventHandler moverHandler = new BotonMoverUnidadHaciaInicioEventHandler(armaDeAsedio, contenedor);
        Button moverArma = new Button("Mover unidad");
        Image flecha = new Image("file:src/vista/imagenes/flecha.png", 18, 18, true, true);
        moverArma.setGraphic(new ImageView(flecha));
        moverArma.setOnAction(moverHandler);
        botones.add(moverArma);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(PlazaCentral plaza, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        BotonCrearAldeanoEventHandler crearAldeanoEventHandler = new BotonCrearAldeanoEventHandler(juego, plaza, contenedor);
        Button crearAldeano = new Button("Crear Aldeano: 25 oro");
        crearAldeano.setOnAction(crearAldeanoEventHandler);
        botones.add(crearAldeano);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(Atacante atacante, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        BotonAtacarInicioEventHandler atacarInicioEventHandler = new BotonAtacarInicioEventHandler(atacante, contenedor);
        Button atacar = new Button("Atacar");
        atacar.setOnAction(atacarInicioEventHandler);
        Image espadas = new Image("file:src/vista/imagenes/espadas.png", 18, 18, true, true);
        atacar.setGraphic(new ImageView(espadas));
        botones.add(atacar);

        BotonMoverUnidadHaciaInicioEventHandler moverHandler = new BotonMoverUnidadHaciaInicioEventHandler((Unidad) atacante, contenedor);
        Button moverEspadachin = new Button("Mover unidad");
        Image imagen = new Image("file:src/vista/imagenes/flecha.png", 18, 18, true, true);
        moverEspadachin.setGraphic(new ImageView(imagen));
        moverEspadachin.setOnAction(moverHandler);
        botones.add(moverEspadachin);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(Castillo castillo, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        BotonCrearArmaDeAsedioEventHandler armaDeAsedioEventHandler = new BotonCrearArmaDeAsedioEventHandler(juego, castillo, contenedor);
        Button crearArmaDeAsedio = new Button("Crear arma de asedio: 200 oro");
        crearArmaDeAsedio.setOnAction(armaDeAsedioEventHandler);
        botones.add(crearArmaDeAsedio);

        return botones;
    }
}
