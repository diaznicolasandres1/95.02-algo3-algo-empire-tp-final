package modelo;

import modelo.mapa.Mapa;
import modelo.unidades.Unidad;

public class Posicion {

	private int posX;
	private int posY;

    public Posicion(int posX, int posY) {

        if (!this.sonCoordenadasValidas(posX, posY)) {
            throw new CoordenadasInvalidasException();
        }

        this.posX = posX;
        this.posY = posY;
    }

    public boolean estaDentroDelRango(Posicion otraPosicion, int rango) {
        if (!this.esRangoValido(rango)) {
            throw new RangoInvalidoException();
        }
        return otraPosicion.estaDentroDelRangoConXeY(this.posX, this.posY, rango);
    }

    public void moverUnidadHacia(Unidad unidad, Mapa mapa, Posicion destino, int rangoMovimiento) {

        if (!this.estaDentroDelRango(destino, rangoMovimiento)) {
            throw new PosicionFueraDeRangoException();
        }
        destino.moverUnidadConXeY(unidad, mapa, this.posX, this.posY);
    }

    public void descolocarColocable(Mapa mapa) {
        mapa.descolocarColocable(this.posY, this.posX);
    }

    private void moverUnidadConXeY(Unidad unidad, Mapa mapa, int xDeOrigen, int yDeOrigen) {
        mapa.moverUnidadDesdeHasta(unidad, yDeOrigen, xDeOrigen, this.posY, this.posX);
    }

    private boolean esRangoValido(int rango) {
        return rango > 0;
    }

    private boolean sonCoordenadasValidas(int posX, int posY) {
        return (posX >= 0 && posY >= 0);
    }

    private boolean estaDentroDelRangoConXeY(int posX, int posY, int rango) {

        int diferenciaEnX = this.posX - posX;
        int diferenciaEnY = this.posY - posY;
        boolean enRangoX = (diferenciaEnX <= rango) && (diferenciaEnX >= -rango);
        boolean enRangoY = (diferenciaEnY <= rango) && (diferenciaEnY >= -rango);
        return enRangoX && enRangoY;
	}
}

