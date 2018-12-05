package modelo.unidades.armadeasedio;

import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Atacable;
import modelo.unidades.Unidad;
import modelo.excepciones.ArmaDeAsedioYaSeEncuentraDesmontadaException;
import modelo.excepciones.NoSePuedeAtacarConArmaAsedioDesmontadaException;

public class EstadoArmaAsedioDesmontada implements EstadoArmaAsedio {

    public void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int distanciaDeMovimiento) {
        origen.moverUnidadHacia(unidad, mapa, destino, distanciaDeMovimiento);
    }

    @Override
    public void atacar(Atacable atacable, ArmaDeAsedio arma) {
        throw new NoSePuedeAtacarConArmaAsedioDesmontadaException();
    }

    @Override
    public void montarArma(ArmaDeAsedio armaDeAsedio) {
        // Este cambio lo realiza arma de asedio en pausa
    }

    @Override
    public void desmontarArma(ArmaDeAsedio armaDeAsedio) {
        throw new ArmaDeAsedioYaSeEncuentraDesmontadaException();
    }

    @Override
    public EstadoArmaAsedio proximoEstado() {
        return this;
    }

}
