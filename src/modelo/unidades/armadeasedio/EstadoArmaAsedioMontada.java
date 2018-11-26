package modelo.unidades.armadeasedio;

import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
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
    public void atacar(Colocable colocable, ArmaDeAsedio arma) {
        colocable.recibirDanio(arma);
    }

    @Override
    public void desmontarArma(ArmaDeAsedio armaDeAsedio) {
    }

    @Override
    public void montarArma(ArmaDeAsedio armaDeAsedio) {
    }
}
