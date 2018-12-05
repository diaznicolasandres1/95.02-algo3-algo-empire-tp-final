package modelo.unidades.arquero;

import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Atacable;
import modelo.unidades.Atacante;
import modelo.excepciones.ColocableFueraDeRangoDeAtaqueException;
import modelo.juego.Oro;
import modelo.unidades.Unidad;

public class Arquero extends Unidad implements Atacante {

    private EstadoArquero estado = new EstadoArqueroDisponible();
    private static final int RANGO_DE_ATAQUE = 3;
	
	public Arquero(Oro oro) {
        this.vida = 75;
        this.costo = 75;
        oro.restarOro(this.costo);
	}

    public void finalizarTurno() {
        this.estado.avanzarTurno(this);
	}

	@Override
    public void atacar(Atacable objetivo) {
        if (objetivo.calcularDistanciaA(this.posicion) > RANGO_DE_ATAQUE) {
            throw new ColocableFueraDeRangoDeAtaqueException();
        }
        this.estado.atacar(objetivo, this);
		this.estarOcupado();
	}

	@Override
    public void moverHacia(Posicion destino, Mapa mapa) {
        this.estado.moverArqueroDesdeHacia(this, this.posicion, destino, mapa, DISTANCIA_DE_MOVIMIENTO);
        this.estarOcupado();
    }

	public void estarDisponible() {
        this.estado = new EstadoArqueroDisponible();
	}
	
	public void estarOcupado() {
        this.estado = new EstadoArqueroOcupado();
	}

}
