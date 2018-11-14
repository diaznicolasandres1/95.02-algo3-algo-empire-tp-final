package unidades;

public abstract class Unidad {
	protected int vida;
	protected int costo;
	
	
	public int getVida() {
		return vida;
	}
	
	public void recibirDanio(int danio)   {
        if (vida <= 0) {
            throw new UnidadEstaMuertaException();
        }
        vida -= danio;
    }
	

	
}
