package vista;

import controlador.IniciarMoverUnidadEventHandler;
import controlador.botonesaldeano.IniciarConstruccionCuartelEventHandler;
import controlador.botonesaldeano.IniciarConstruccionPlazaCentralEventHandler;
import controlador.botonesaldeano.IniciarReparacionEdificioEventHandler;
import controlador.botonesarmadeasedio.DesmontarArmaEventHandler;
import controlador.botonesarmadeasedio.MontarArmaEventHandler;
import controlador.botonesataque.IniciarAtaqueEventHandler;
import controlador.botonesdeedificios.CrearAldeanoEventHandler;
import controlador.botonesdeedificios.CrearArmaDeAsedioEventHandler;
import controlador.botonesdeedificios.CrearArqueroEventHandler;
import controlador.botonesdeedificios.CrearEspadachinEventHandler;
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

    private static final String RUTA_MARTILLO = "file:src/vista/imagenes/martillo.png";
    private static final String RUTA_LLAVE_INGLESA = "file:src/vista/imagenes/llave_inglesa.png";
    private static final String RUTA_FLECHA = "file:src/vista/imagenes/flecha.png";
    private static final String RUTA_MONTAR = "file:src/vista/imagenes/montar.png";
    private static final String RUTA_DESMONTAR = "file:src/vista/imagenes/desmontar.png";
    private static final String RUTA_ESPADAS = "file:src/vista/imagenes/espadas.png";
    private static final String RUTA_ALDEANO = "file:src/vista/imagenes/aldeano.png";
    private static final String RUTA_ARMA_DE_ASEDIO = "file:src/vista/imagenes/arma_de_asedio.jpeg";
    private static final String RUTA_ARQUERO = "file:src/vista/imagenes/arquero.jpg";
    private static final String RUTA_ESPADACHIN = "file:src/vista/imagenes/espadachin.png";

    public ArrayList<Button> crearBotonesPara(Aldeano aldeano, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        IniciarConstruccionCuartelEventHandler cuartelEventHandler = new IniciarConstruccionCuartelEventHandler(juego, aldeano, contenedor);
        Button construirCuartel = new Button("Construir Cuartel: 50 oro");
        Image martillo = new Image(RUTA_MARTILLO, 18, 18, true, true);
        construirCuartel.setGraphic(new ImageView(martillo));
        construirCuartel.setOnAction(cuartelEventHandler);
        botones.add(construirCuartel);

        IniciarConstruccionPlazaCentralEventHandler plazaCentralEventHandler = new IniciarConstruccionPlazaCentralEventHandler(aldeano, contenedor);
        Button construirPlaza = new Button("Constuir Plaza Central: 100 oro");
        construirPlaza.setGraphic(new ImageView(martillo));
        construirPlaza.setOnAction(plazaCentralEventHandler);
        botones.add(construirPlaza);

        IniciarReparacionEdificioEventHandler repararEdificioInicioEventHandler = new IniciarReparacionEdificioEventHandler(aldeano, contenedor);
        Button repararEdificio = new Button("Reparar edificio");
        Image llave = new Image(RUTA_LLAVE_INGLESA, 18, 18, true, true);
        repararEdificio.setGraphic(new ImageView(llave));
        repararEdificio.setOnAction(repararEdificioInicioEventHandler);
        botones.add(repararEdificio);

        IniciarMoverUnidadEventHandler moverHandler = new IniciarMoverUnidadEventHandler(aldeano, contenedor);
        Button moverAldeano = new Button("Mover unidad");
        Image flecha = new Image(RUTA_FLECHA, 18, 18, true, true);
        moverAldeano.setGraphic(new ImageView(flecha));
        moverAldeano.setOnAction(moverHandler);
        botones.add(moverAldeano);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(Cuartel cuartel, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        CrearArqueroEventHandler arqueroHandler = new CrearArqueroEventHandler(juego, cuartel, contenedor);
        Button crearArquero = new Button("Crear arquero: 75 oro");
        Image arquero = new Image(RUTA_ARQUERO, 18, 18, true, true);
        crearArquero.setGraphic(new ImageView(arquero));
        crearArquero.setOnAction(arqueroHandler);
        botones.add(crearArquero);

        CrearEspadachinEventHandler espadachinEventHandler = new CrearEspadachinEventHandler(juego, cuartel, contenedor);
        Button crearEspadachin = new Button("Crear espadachin: 50 oro");
        Image espadachin = new Image(RUTA_ESPADACHIN, 18, 18, true, true);
        crearEspadachin.setGraphic(new ImageView(espadachin));
        crearEspadachin.setOnAction(espadachinEventHandler);
        botones.add(crearEspadachin);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(ArmaDeAsedio armaDeAsedio, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        MontarArmaEventHandler montarArmaEventHandler = new MontarArmaEventHandler(juego, armaDeAsedio, contenedor);
        Button montarArma = new Button("Montar arma de asedio");
        Image montar = new Image(RUTA_MONTAR, 18, 18, true, true);
        montarArma.setGraphic(new ImageView(montar));
        montarArma.setOnAction(montarArmaEventHandler);
        botones.add(montarArma);

        DesmontarArmaEventHandler desmontarArmaEventHandler = new DesmontarArmaEventHandler(juego, armaDeAsedio, contenedor);
        Button desmontarArma = new Button("Desmontar arma de asedio");
        Image desmontar = new Image(RUTA_DESMONTAR, 18, 18, true, true);
        desmontarArma.setGraphic(new ImageView(desmontar));
        desmontarArma.setOnAction(desmontarArmaEventHandler);
        botones.add(desmontarArma);

        IniciarAtaqueEventHandler atacarInicioEventHandler = new IniciarAtaqueEventHandler(armaDeAsedio, contenedor);
        Button atacar = new Button("Atacar");
        atacar.setOnAction(atacarInicioEventHandler);
        Image espadas = new Image(RUTA_ESPADAS, 18, 18, true, true);
        atacar.setGraphic(new ImageView(espadas));
        botones.add(atacar);

        IniciarMoverUnidadEventHandler moverHandler = new IniciarMoverUnidadEventHandler(armaDeAsedio, contenedor);
        Button moverArma = new Button("Mover unidad");
        Image flecha = new Image(RUTA_FLECHA, 18, 18, true, true);
        moverArma.setGraphic(new ImageView(flecha));
        moverArma.setOnAction(moverHandler);
        botones.add(moverArma);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(PlazaCentral plaza, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        CrearAldeanoEventHandler crearAldeanoEventHandler = new CrearAldeanoEventHandler(juego, plaza, contenedor);
        Button crearAldeano = new Button("Crear Aldeano: 25 oro");
        Image imgAldeano = new Image(RUTA_ALDEANO, 18, 18, true, true);
        crearAldeano.setGraphic(new ImageView(imgAldeano));
        crearAldeano.setOnAction(crearAldeanoEventHandler);
        botones.add(crearAldeano);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(Atacante atacante, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        IniciarAtaqueEventHandler atacarInicioEventHandler = new IniciarAtaqueEventHandler(atacante, contenedor);
        Button atacar = new Button("Atacar");
        atacar.setOnAction(atacarInicioEventHandler);
        Image espadas = new Image(RUTA_ESPADAS, 18, 18, true, true);
        atacar.setGraphic(new ImageView(espadas));
        botones.add(atacar);

        IniciarMoverUnidadEventHandler moverHandler = new IniciarMoverUnidadEventHandler((Unidad) atacante, contenedor);
        Button mover = new Button("Mover unidad");
        Image imgMover = new Image(RUTA_FLECHA, 18, 18, true, true);
        mover.setGraphic(new ImageView(imgMover));
        mover.setOnAction(moverHandler);
        botones.add(mover);

        return botones;
    }

    public ArrayList<Button> crearBotonesPara(Castillo castillo, Juego juego, ContenedorPrincipal contenedor) {

        ArrayList<Button> botones = new ArrayList<>();

        CrearArmaDeAsedioEventHandler armaDeAsedioEventHandler = new CrearArmaDeAsedioEventHandler(juego, castillo, contenedor);
        Button crearArmaDeAsedio = new Button("Crear arma de asedio: 200 oro");
        Image imgArma = new Image(RUTA_ARMA_DE_ASEDIO, 18, 18, true, true);
        crearArmaDeAsedio.setGraphic(new ImageView(imgArma));
        crearArmaDeAsedio.setOnAction(armaDeAsedioEventHandler);
        botones.add(crearArmaDeAsedio);

        return botones;
    }
}
