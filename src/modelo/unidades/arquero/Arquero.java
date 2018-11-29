package modelo.unidades.arquero;

import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidades.Atacante;
import modelo.excepciones.ColocableFueraDeRangoDeAtaqueException;
import modelo.juego.Oro;
import modelo.unidades.Colocable;
import modelo.unidades.Unidad;

public class Arquero extends Unidad implements Atacante {

    private EstadoArquero estado = new EstadoArqueroDisponible();
    private static final int RANGO_DE_ATAQUE = 3;
	
	public Arquero(Oro oro) {
        this.vida = 75;
        this.costo = 75;
        oro.restarOro(costo);
	}
	
	public void avanzarTurno() {
		estado.avanzarTurno(this);
	}

	@Override
    public void atacar(Colocable colocable) {
        if (colocable.calcularDistanciaA(this.posicion) > RANGO_DE_ATAQUE) {
            throw new ColocableFueraDeRangoDeAtaqueException();
        }
        estado.atacar(colocable, this);
		this.estarOcupado();
	}

	@Override
    public void moverHacia(Posicion destino, Mapa mapa) {
        estado.moverArqueroDesdeHacia(this, this.posicion, destino, mapa, this.distanciaDeMovimiento);
        this.estarOcupado();
    }

	public void estarDisponible() {
		 estado = new EstadoArqueroDisponible();		
	}
	
	public void estarOcupado() {
		 estado = new EstadoArqueroOcupado();		
	}

}
