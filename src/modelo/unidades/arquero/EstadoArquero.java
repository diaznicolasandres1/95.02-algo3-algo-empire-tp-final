package modelo.unidades.arquero;

import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Atacable;

public interface EstadoArquero {
	
	void avanzarTurno(Arquero arquero);

    void atacar(Atacable objetivo, Arquero arquero);

    void moverArqueroDesdeHacia(Arquero arquero, Posicion origen, Posicion destino, Mapa mapa, int distanciaDeMovimiento);
}
