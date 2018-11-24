package modelo.edificios.cuartel;

import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

public class EstadoCuartelConstruido implements EstadoCuartel {

	@Override
	public void recibirDanio(Edificio cuartel, int danio) {
        cuartel.reducirVida(danio);
	}

	@Override
	public Espadachin crearEspadachin(Oro oro) {
        return new Espadachin(oro);
	}

	@Override
	public Arquero crearArquero(Oro oro) {
        return new Arquero(oro);
	}
	
	@Override
	public void avanzarTurno(Edificio cuartel) {
        // Cuartel no pasa turnos mientras esta construido.
    }

	@Override
	public void repararse(Edificio cuartel) {
		cuartel.repararseAsimismo();
	}





}
