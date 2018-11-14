package edificios;

import unidades.UnidadEstaMuertaException;

public abstract class Edificio {
	
	protected int vida;
	protected int costo;
	
	
	public int getVida() {
		return vida;
	}
	
	public void recibirDanioConValor(int danio)   {
        if (vida <= 0) {
            throw new UnidadFueDestruidaException();
        }
        vida -= danio;
    }
	
	public void repararseASimismo(int varlorARepararse, int vidaMaxima) {
		vida += varlorARepararse;
		if(vida >= vidaMaxima) {
			vida = vidaMaxima;
		}
		
	}
	
	

}
