package modelo.edificios;

public interface EstadoEdificio {

    void repararse(Edificio edificio);
    void recibirDanio(Edificio edificio, int danio);
    void avanzarTurno(Edificio edificio);
}