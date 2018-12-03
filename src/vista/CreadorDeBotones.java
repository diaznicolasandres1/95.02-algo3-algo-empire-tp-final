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
        Button construirCuartel = new Button("Construir Cuartel");
        construirCuartel.setOnAction(cuartelEventHandler);
        botones.add(construirCuartel);

        BotonConstruirPlazaCentralInicioEventHandler plazaCentralEventHandler = new BotonConstruirPlazaCentralInicioEventHandler(juego, aldeano, contenedor);
        Button construirPlaza = new Boton("Constuir Plaza Central", plazaCentralEventHandler);
        botones.add(construirPlaza);

        BotonRepararEdificioInicioEventHandler repararEdificioInicioEventHandler = new BotonRepararEdificioInicioEventHandler(juego, aldeano, contenedor);
        Button repararEdificio = new Boton("Reparar edificio", repararEdificioInicioEventHandler);
        botones.add(repararEdificio);

        BotonMoverUnidadHaciaInicioEventHandler moverHandler = new BotonMoverUnidadHaciaInicioEventHandler(juego, aldeano, contenedor);
        Button moverAldeano = new Boton("Mover unidad", moverHandler);
        botones.add(moverAldeano);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(Cuartel cuartel, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        BotonCrearArqueroEventHandler arqueroHandler = new BotonCrearArqueroEventHandler(juego, cuartel, contenedor);
        Button crearArquero = new Button("Crear arquero");
        crearArquero.setOnAction(arqueroHandler);
        botones.add(crearArquero);

        BotonCrearEspadachinEventHandler espadachinEventHandler = new BotonCrearEspadachinEventHandler(juego, cuartel, contenedor);
        Button crearEspadachin = new Button("Crear espadachin");
        crearEspadachin.setOnAction(espadachinEventHandler);
        botones.add(crearEspadachin);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(ArmaDeAsedio armaDeAsedio, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        BotonMontarArmaEventHandler montarArmaEventHandler = new BotonMontarArmaEventHandler(juego, armaDeAsedio, contenedor);
        Button montarArma = new Button("Montar arma de asedio");
        montarArma.setOnAction(montarArmaEventHandler);
        botones.add(montarArma);

        BotonDesmontarArmaEventHandler desmontarArmaEventHandler = new BotonDesmontarArmaEventHandler(juego, armaDeAsedio, contenedor);
        Button desmontarArma = new Button("Desmontar arma de asedio");
        desmontarArma.setOnAction(desmontarArmaEventHandler);
        botones.add(desmontarArma);

        BotonAtacarInicioEventHandler atacarInicioEventHandler = new BotonAtacarInicioEventHandler(juego, armaDeAsedio, contenedor);
        Button atacar = new Button("Atacar");
        atacar.setOnAction(atacarInicioEventHandler);
        botones.add(atacar);

        BotonMoverUnidadHaciaInicioEventHandler moverHandler = new BotonMoverUnidadHaciaInicioEventHandler(juego, armaDeAsedio, contenedor);
        Button moverArma = new Button("Mover unidad");
        moverArma.setOnAction(moverHandler);
        botones.add(moverArma);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(PlazaCentral plaza, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        BotonCrearAldeanoEventHandler crearAldeanoEventHandler = new BotonCrearAldeanoEventHandler(juego, plaza, contenedor);
        Button crearAldeano = new Button("Crear Aldeano");
        crearAldeano.setOnAction(crearAldeanoEventHandler);
        botones.add(crearAldeano);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(Atacante atacante, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        BotonAtacarInicioEventHandler atacarInicioEventHandler = new BotonAtacarInicioEventHandler(juego, atacante, contenedor);
        Button atacar = new Button("Atacar");
        atacar.setOnAction(atacarInicioEventHandler);
        botones.add(atacar);

        BotonMoverUnidadHaciaInicioEventHandler moverHandler = new BotonMoverUnidadHaciaInicioEventHandler(juego, (Unidad) atacante, contenedor);
        Button moverEspadachin = new Button("Mover unidad");
        moverEspadachin.setOnAction(moverHandler);
        botones.add(moverEspadachin);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(Castillo castillo, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        BotonCrearArmaDeAsedioEventHandler armaDeAsedioEventHandler = new BotonCrearArmaDeAsedioEventHandler(juego, castillo, contenedor);
        Button crearArmaDeAsedio = new Button("Crear arma de asedio");
        crearArmaDeAsedio.setOnAction(armaDeAsedioEventHandler);
        botones.add(crearArmaDeAsedio);

        return botones;
    }
}
