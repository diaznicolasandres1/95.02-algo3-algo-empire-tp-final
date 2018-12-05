package modelo.unidades.armadeasedio;

import modelo.mapa.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Atacable;
import modelo.unidades.Unidad;

public interface EstadoArmaAsedio {

	void moverUnidadDesdeHacia(Unidad unidad, Mapa mapa, Posicion destino, Posicion origen, int rangoMovimiento);

	void atacar(Atacable atacable, ArmaDeAsedio arma);
	void montarArma(ArmaDeAsedio armaDeAsedio);
	void desmontarArma(ArmaDeAsedio armaDeAsedio);
	EstadoArmaAsedio proximoEstado();
}
