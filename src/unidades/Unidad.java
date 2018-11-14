package unidades;

import modelo.Posicion;

public abstract class Unidad {

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
}
