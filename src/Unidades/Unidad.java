package Unidades;

public abstract class Unidad {
	protected int vida;
	protected int costo;
	
	
	public int getVida() {
		return vida;
	}
	
	public void recibirDanio(int danio) throws UnidadEstaMuertaException  {
        if (vida <= 0) {
            throw new UnidadEstaMuertaException();
        }
        vida -= danio;
    }
	

	 public abstract void estarOcupado();
	 public abstract void estarDisponible();
}
