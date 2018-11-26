package modelo.unidades.armadeasedio;

import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;

public interface EstadoArmaAsedio {

	void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento);

    void atacar(Colocable colocable, ArmaDeAsedio arma);
	void montarArma(ArmaDeAsedio armaDeAsedio);
	void desmontarArma(ArmaDeAsedio armaDeAsedio);
	EstadoArmaAsedio proximoEstado();
}
