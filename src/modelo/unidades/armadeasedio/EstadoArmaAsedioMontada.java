package modelo.unidades.armadeasedio;

import modelo.excepciones.ArmaDeAsedioYaSeEncuentraMontadaException;
import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Atacable;
import modelo.unidades.Unidad;
import modelo.excepciones.NoSePuedeMoverArmaAsedioMontadaException;

public class EstadoArmaAsedioMontada implements EstadoArmaAsedio{

    @Override
    public EstadoArmaAsedio proximoEstado() {
        return null;
    }

    @Override
    public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int distanciaDeMovimiento) throws NoSePuedeMoverArmaAsedioMontadaException {
        throw new NoSePuedeMoverArmaAsedioMontadaException();
    }

    @Override
    public void atacar(Atacable objetivo, ArmaDeAsedio arma) {
        objetivo.recibirDanio(arma);
    }

    @Override
    public void desmontarArma(ArmaDeAsedio armaDeAsedio) {
        //Este cambio lo realiza arma de asedio en pausa

    }

    @Override
    public void montarArma(ArmaDeAsedio armaDeAsedio) {
        throw new ArmaDeAsedioYaSeEncuentraMontadaException();
    }
}
