package packman;

import java.util.Random;

/**
 * Classe: Fanstasma
 * Descripció: Aquesta classe representa un fantasma al joc del Pacman
 * 
 */

public class Fantasma {

    /** Variables pròpies del fantasma per la posició i la direcció */
    protected int posicioX;
    protected int posicioY;
    protected int direccio;

    /** Constants per les 4 direccions possibles */
    protected static final int DIRECCIO_AMUNT = 0;
    protected static final int DIRECCIO_AVALL = 1;
    protected static final int DIRECCIO_ESQUERRA = 2;
    protected static final int DIRECCIO_DRETA = 3;

    /** Variable per l'identificador únic del fantasma */
    private int idFantasma;

    /** Comptador estàtic per portar el compte de quants fantasmes s'han creat fins ara */
    private static int comptadorFantasmes = 0;

    /**
     * Constructor d'un determinat fantasma. Cada fantasma té un identificador únic, una
     * posició i una direcció inicial
     * @param posicioX Posició inicial X del fantasma
     * @param posicioY Posició inicial Y del fantasma
     * @param direccio Direcció inicial del fantasma
     */

    public Fantasma(int posicioX, int posicioY, int direccio) {
    	this.posicioX = posicioX;
        this.posicioY = posicioY;
        this.direccio = direccio;
		//constructor de les variables
		comptadorFantasmes++;
        	this.idFantasma = comptadorFantasmes;
    }

    /**
     * Mètode per indicar al fantasma que es mogui. Per això se li indiquen les caselles 
     * del tauler, la resta de fantasmes i el jugador
     * @param caselles Caselles del tauler
     * @param enemics Tots els enemics del joc
     * @param prota jugador
     */
    public void moute(Casella[][] caselles, Fantasma[] enemics, Jugador prota) {
        // Si ja està a sobre del jugador, no se mueve
        if(coincideix(prota.getPosicioX(), prota.getPosicioY())) {
            return;
        }

        int seguentX = 0, seguentY = 0;
        // Si no es pot moure en la direcció actual, la canvia
        // Intenta canviar de direcció 4 vegades aleatòriament mentres no es pugui
        // moure en aquesta direcció
        // Si no ho aconsegueix, intenta unes altres 4 vegades, pero ara totes les direccions possibles

        for(int vegades = 0; vegades < 8; vegades++) {
            switch(direccio) {
                case DIRECCIO_AMUNT:
                	seguentX = posicioX;
                    seguentY = posicioY-1;
                    break;
                case DIRECCIO_AVALL:
                	seguentX = posicioX;
                    seguentY = posicioY+1;
                    break;

                case DIRECCIO_ESQUERRA:
                	seguentX = posicioX-1;
                    seguentY = posicioY;
                    break;

                case DIRECCIO_DRETA:
                	seguentX = posicioX+1;
                    seguentY = posicioY;
                    break;

            }


            // Si no pot avançar a la següent casella, canvia la direcció
            if(!esOcupable(seguentX, seguentY, caselles, enemics)) {
                // Les 4 primeres vegades prova aleatoriament
                if(vegades < 4) {
                    direccio = new Random(System.currentTimeMillis()).nextInt(4);
                }
                // les 4 vegades següents prova totes les direccions
                else {
                    direccio++;
                    if(direccio > 4) {
                        direccio = 0;
                    }
                }
            } else {
                break;
            }
        }

        // Es mou
        switch(direccio) {
            case DIRECCIO_AMUNT:
                if(caselles[posicioY-1][posicioX].esOcupable()) {
                    posicioY = posicioY - 1;
                    //modifica la posicio Y
                }
                break;
            case DIRECCIO_AVALL:
                if(caselles[posicioY+1][posicioX].esOcupable()) {
                	posicioY = posicioY + 1;
                    //modifica la posicio Y
                }
                break;
            case DIRECCIO_ESQUERRA:
            	if(caselles[posicioY][posicioX-1].esOcupable()) {
                    posicioX = posicioX - 1;
                }
                break;
            case DIRECCIO_DRETA:
                if(caselles[posicioY][posicioX+1].esOcupable()) {
                    posicioX = posicioX + 1;
                }
                break;
        }
    }

    /**
     * Metode privat que comprova si una casella és trepitjable pel fantasma
     * Per a això comprova que la casella sigui trepitjable i que a més no hi hagi cap altre fantasma a sobre
     * @param x Posició x de la casella a comprovar
     * @param y Posició y de la casella a comprovar
     * @param caselles Caselles del tauler
     * @param enemics Tots els enemics del tauler
     * @return true si es trepitjable, false si no
     */
    private boolean esOcupable(int x, int y, Casella[][] caselles, Fantasma[] enemics) {
        boolean trepitjable = caselles[y][x].esOcupable();
        for(int i=0; i<enemics.length; i++) {
            if(enemics[i].coincideix(x, y)) {
            	trepitjable = false;
                break;
            }
        }
        return trepitjable;
    }

    /**
     * Retorna l'identificador únic del fantasma
     * @return l'identificador único del fantasma
     */
    public int getIdFantasma() {
    	return idFantasma;
        //retorna ID fantasma
    }

    /**
     * Comprova si la posició d'aquest fantasma coincideix amb la d'un altre
     * @param Fantasma amb el que comparar la posició
     * @return true si coincideixen, false si no
     */
    public boolean coincideix(Fantasma fant) {
        return fant.getPosicioX() == posicioX && fant.getPosicioY() == posicioY;
    }

    /**
     * Comprova si la posició d'aquest fantasma coincideix amb una donada
     * @param x Posició x donada
     * @param y Posició y donada
     * @return true si coincideixen, false si no
     */
    public boolean coincideix(int x, int y) {
        return x == posicioX && y == posicioY;
    }

    /**
     * Retorna la posició x del fantasma
     * @return La posició x del fantasma
     */
    public int getPosicioX() {
    	return posicioX;
        //retorna posicioX;
    }

    /**
     * Retorna la posició y del fantasma
     * @return La posició y del fantasma
     */
    public int getPosicioY() {
    	return posicioY;
        //obté posicioY
    }

    /**
     * Estableix la posició X del fantasma
     * @param posicioX La posició X
     */
    public void setPosicioX(int posicioX) {
    	this.posicioX = posicioX;
        //estableix posicioX
    }

    /**
     * Estableix la posició Y del fantasma
     * @param posicioY La posició Y
     */
    public void setPosicioY(int posicioY) {
    	this.posicioY = posicioY;
        //estableix posicioY
    }

    /**
     * Estableix la direcció del fantasma
     * @param direccio La direcció
     */
    public void setDireccio(int direccio) {
    	this.direccio = direccio;
        //estableix direcció
    }

    /**
     * Retorna la direcció actual del fantasma
     * @return La direcció actual del fantasma
     */
    public int getDireccio() {
    	return direccio;
        //retorna direccio;
    }
}
