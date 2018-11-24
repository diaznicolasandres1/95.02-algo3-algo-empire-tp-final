package modelo.unidades.armadeasedio;

import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;
import modelo.excepciones.ArmaDeAsedioYaSeEncuentraDesmontadaException;
import modelo.excepciones.NoSePuedeAtacarConArmaAsedioDesmontadaException;

public class EstadoArmaAsedioDesmontada implements EstadoArmaAsedio {

    public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int distanciaDeMovimiento) {
        origen.moverUnidadHacia(unidad, mapa, destino, distanciaDeMovimiento);
    }

    @Override
    public void atacar(Colocable colocable, ArmaDeAsedio arma) {
        throw new NoSePuedeAtacarConArmaAsedioDesmontadaException();
    }

    @Override
    public void montarArma(ArmaDeAsedio armaDeAsedio) {

    }

    @Override
    public void desmontarArma(ArmaDeAsedio armaDeAsedio) {
        throw new ArmaDeAsedioYaSeEncuentraDesmontadaException();
    }

    @Override
    public EstadoArmaAsedio proximoEstado() {
        return null;
    }

}
