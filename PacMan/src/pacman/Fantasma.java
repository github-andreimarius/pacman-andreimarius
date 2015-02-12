package packman;

import java.util.Random;

/**
 * Classe: Fanstasma
 * Descripci�: Aquesta classe representa un fantasma al joc del Pacman
 * 
 */

public class Fantasma {

    /** Variables pr�pies del fantasma per la posici� i la direcci� */
    protected int posicioX;
    protected int posicioY;
    protected int direccio;

    /** Constants per les 4 direccions possibles */
    protected static final int DIRECCIO_AMUNT = 0;
    protected static final int DIRECCIO_AVALL = 1;
    protected static final int DIRECCIO_ESQUERRA = 2;
    protected static final int DIRECCIO_DRETA = 3;

    /** Variable per l'identificador �nic del fantasma */
    private int idFantasma;

    /** Comptador est�tic per portar el compte de quants fantasmes s'han creat fins ara */
    private static int comptadorFantasmes = 0;

    /**
     * Constructor d'un determinat fantasma. Cada fantasma t� un identificador �nic, una
     * posici� i una direcci� inicial
     * @param posicioX Posici� inicial X del fantasma
     * @param posicioY Posici� inicial Y del fantasma
     * @param direccio Direcci� inicial del fantasma
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
     * M�tode per indicar al fantasma que es mogui. Per aix� se li indiquen les caselles 
     * del tauler, la resta de fantasmes i el jugador
     * @param caselles Caselles del tauler
     * @param enemics Tots els enemics del joc
     * @param prota jugador
     */
    public void moute(Casella[][] caselles, Fantasma[] enemics, Jugador prota) {
        // Si ja est� a sobre del jugador, no se mueve
        if(coincideix(prota.getPosicioX(), prota.getPosicioY())) {
            return;
        }

        int seguentX = 0, seguentY = 0;
        // Si no es pot moure en la direcci� actual, la canvia
        // Intenta canviar de direcci� 4 vegades aleat�riament mentres no es pugui
        // moure en aquesta direcci�
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


            // Si no pot avan�ar a la seg�ent casella, canvia la direcci�
            if(!esOcupable(seguentX, seguentY, caselles, enemics)) {
                // Les 4 primeres vegades prova aleatoriament
                if(vegades < 4) {
                    direccio = new Random(System.currentTimeMillis()).nextInt(4);
                }
                // les 4 vegades seg�ents prova totes les direccions
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
     * Metode privat que comprova si una casella �s trepitjable pel fantasma
     * Per a aix� comprova que la casella sigui trepitjable i que a m�s no hi hagi cap altre fantasma a sobre
     * @param x Posici� x de la casella a comprovar
     * @param y Posici� y de la casella a comprovar
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
     * Retorna l'identificador �nic del fantasma
     * @return l'identificador �nico del fantasma
     */
    public int getIdFantasma() {
    	return idFantasma;
        //retorna ID fantasma
    }

    /**
     * Comprova si la posici� d'aquest fantasma coincideix amb la d'un altre
     * @param Fantasma amb el que comparar la posici�
     * @return true si coincideixen, false si no
     */
    public boolean coincideix(Fantasma fant) {
        return fant.getPosicioX() == posicioX && fant.getPosicioY() == posicioY;
    }

    /**
     * Comprova si la posici� d'aquest fantasma coincideix amb una donada
     * @param x Posici� x donada
     * @param y Posici� y donada
     * @return true si coincideixen, false si no
     */
    public boolean coincideix(int x, int y) {
        return x == posicioX && y == posicioY;
    }

    /**
     * Retorna la posici� x del fantasma
     * @return La posici� x del fantasma
     */
    public int getPosicioX() {
    	return posicioX;
        //retorna posicioX;
    }

    /**
     * Retorna la posici� y del fantasma
     * @return La posici� y del fantasma
     */
    public int getPosicioY() {
    	return posicioY;
        //obt� posicioY
    }

    /**
     * Estableix la posici� X del fantasma
     * @param posicioX La posici� X
     */
    public void setPosicioX(int posicioX) {
    	this.posicioX = posicioX;
        //estableix posicioX
    }

    /**
     * Estableix la posici� Y del fantasma
     * @param posicioY La posici� Y
     */
    public void setPosicioY(int posicioY) {
    	this.posicioY = posicioY;
        //estableix posicioY
    }

    /**
     * Estableix la direcci� del fantasma
     * @param direccio La direcci�
     */
    public void setDireccio(int direccio) {
    	this.direccio = direccio;
        //estableix direcci�
    }

    /**
     * Retorna la direcci� actual del fantasma
     * @return La direcci� actual del fantasma
     */
    public int getDireccio() {
    	return direccio;
        //retorna direccio;
    }
}
