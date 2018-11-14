package modelo;

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
        return otraPosicion.wrapperEstaDentroDelRango(this.posX, this.posY, rango);
    }

    private boolean esRangoValido(int rango) {
        return rango > 0;
    }

    private boolean sonCoordenadasValidas(int posX, int posY) {
        return (posX >= 0 && posY >= 0);
    }

    private boolean wrapperEstaDentroDelRango(int posX, int posY, int rango) {

        int diferenciaEnX = this.posX - posX;
        int diferenciaEnY = this.posY - posY;
        boolean enRangoX = (diferenciaEnX <= rango) && (diferenciaEnX >= -rango);
        boolean enRangoY = (diferenciaEnY <= rango) && (diferenciaEnY >= -rango);
        return enRangoX && enRangoY;
	}
}

