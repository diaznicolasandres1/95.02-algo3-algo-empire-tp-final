package modelo.unidades;

import modelo.Posicion;
import modelo.mapa.Mapa;

public abstract class Unidad implements Colocable {

	protected int vida;
	protected int costo;
    protected Posicion posicion;
    protected int rangoMovimiento = 1;
	
	public int getVida() {
		return vida;
	}
	
	public void recibirDanio(int danio)   {
        if (vida <= 0) {
            throw new UnidadEstaMuertaException();
        }
        vida -= danio;
    }

    public void moverHacia(Posicion posicion) {
        this.posicion.moverUnidadHacia(this, posicion, rangoMovimiento);
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void colocarseEn(Mapa mapa, int fila, int columna) {
        mapa.colocarUnidad(this, fila, columna);
        this.setPosicion(new Posicion(columna, fila));
    }

    @Override
    public void descolocarseDe(Mapa mapa) {
        this.posicion.descolocarUnidadDe(mapa);
    }

    public void avanzarTurno() {

    }
}
