package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("AlgoEmpire");

        ContenedorEntrada contenedorEntrada = new ContenedorEntrada();
        Scene escenaInicial = new Scene(contenedorEntrada);
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal("unJugador", "otroJugador");
        Scene escenaJuego = new Scene(contenedorPrincipal);
        contenedorEntrada.setBotonJugar(primaryStage, escenaJuego);

        primaryStage.setScene(escenaInicial);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
