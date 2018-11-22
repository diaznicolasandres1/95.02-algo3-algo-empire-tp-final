package modelo.edificios;

import modelo.Posicion;
import modelo.mapa.Mapa;
import modelo.unidades.Colocable;

import java.util.ArrayList;

public abstract class Edificio implements Colocable {

	protected int vidaMaxima;
	protected int vida;
	protected int costo;
	protected int tamanio;
	protected int reparacion;
    protected ArrayList<Posicion> posiciones;

	public int getVida() {
		return vida;
	}
	
	
	/*-----Recibir danio-----*/	
	
	public void recibirDanio(int danio)   {
        if (vida <= 0) {
            throw new UnidadFueDestruidaException();
        }
        vida -= danio;
    }	
	
	
	/*-----Repararse a si mismo-----*/
	
    public void repararseAsimismo() {

        if (vida == vidaMaxima) {
			throw new EdificioTieneVidaMaximaException();
		}
		vida += reparacion;
		if (vida >= vidaMaxima) {
			vida = vidaMaxima;
		}
	}
    
    
    
    /*-----Descolocarse-----*/	
    
    @Override
    public void descolocarseDe(Mapa mapa) {
        for (Posicion posicion : this.posiciones) {
            posicion.descolocarColocable(mapa);
        }
    }
    
    
    
    /*-----Colocarse en-----*/	

    @Override
    public void colocarseEn(Mapa mapa, int fila, int columna) {
        mapa.colocarEdificio(this, this.tamanio, fila, columna);
    }
    
    
    
    /*-----Setear posicion de inicio-----*/

    public void agregarPosicion(Posicion posicion) {
        this.posiciones.add(posicion);
    }

    /*-----Calcular distancia----*/
    @Override
    public int calcularDistanciaA(Posicion posicion) {
        int distanciaMinima = Integer.MAX_VALUE;
        for (Posicion unaPosicion : this.posiciones) {
            distanciaMinima = Integer.min(distanciaMinima, posicion.calcularDistanciaA(unaPosicion));
        }
        return distanciaMinima;
    }


	protected abstract void terminoDeCrearse();
	
	@Override
	public void avanzarTurno() {}
}
