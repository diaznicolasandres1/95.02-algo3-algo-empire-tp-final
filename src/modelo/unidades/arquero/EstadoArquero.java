package modelo.unidades.arquero;

import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Colocable;

public interface EstadoArquero {
	
	void avanzarTurno(Arquero arquero);

    void atacar(Colocable colocable, Arquero arquero);

    void moverArqueroDesdeHacia(Arquero arquero, Posicion origen, Posicion destino, Mapa mapa, int distanciaDeMovimiento);
}
