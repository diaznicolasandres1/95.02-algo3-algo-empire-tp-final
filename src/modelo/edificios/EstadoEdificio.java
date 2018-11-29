package modelo.edificios;

public interface EstadoEdificio {

    void reparar(Edificio edificio);
    void recibirDanio(Edificio edificio, int danio);
    void avanzarTurno(Edificio edificio);
}