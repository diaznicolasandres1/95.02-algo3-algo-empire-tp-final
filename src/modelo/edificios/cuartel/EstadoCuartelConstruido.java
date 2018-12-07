package modelo.edificios.cuartel;

import modelo.juego.Oro;
import modelo.edificios.Edificio;
import modelo.unidades.arquero.Arquero;
import modelo.unidades.espadachin.Espadachin;

public class EstadoCuartelConstruido implements EstadoCuartel {

	private static final String NOMBRE_ESTADO = "Disponible";

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

	public void reparar(Edificio cuartel) {
		cuartel.incrementarVida();
	}

	@Override
    public String getNombreEstado() {
        return NOMBRE_ESTADO;
    }
}
