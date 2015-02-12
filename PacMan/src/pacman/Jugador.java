package packman;

/**
 * Classe: Jugador
 * Descripci�: Aquesta classe representa el protagonista del joc Pacman
 */

public class Jugador {

    /** Variables propies del protagonista per la posici� i direcci� */
    protected int posicioX;
    protected int posicioY;
    protected int direccio;

    /** Constants per les 4 direccions possibles */
    protected static final int DIRECCIO_AMUNT = 0;
    protected static final int DIRECCIO_AVALL = 1;
    protected static final int DIRECCIO_ESQUERRA = 2;
    protected static final int DIRECCIO_DRETA = 3;

    /**
     * Constructor que rep tota la informaci� sobre el jugador
     * @param posicioX Posici� X inicial del jugador
     * @param posicioY Posici� Y inicial del jugador
     * @param direccio Direcci� inicial del jugador 
     */
    public Jugador(int posicioX, int posicioY, int direccio) {
        this.posicioX = posicioX;
        this.posicioY = posicioY;
        this.direccio = direccio;
    }

    /**
     * M�tode que indica al jugador que es mogui. Per aix� se li passen com 
     * par�metre les caselles del tauler
     * @param caselles Les caselles del tauler
     * @param teclaPolsada Tecla polsada per l'usuari final
     */
    public void moute(Casella[][] caselles, String teclaPolsada) {

        // Modifica la direcci� si s'ha polsat una de les tecles de canvi de direcci�
        if(teclaPolsada.equals("W") || teclaPolsada.equals("w")) {
            //que vagi amunt
        }
        else if(teclaPolsada.equals("S") || teclaPolsada.equals("s")) {
            //que vagi avall
        }


//cas dreta i esquerra
        else if(teclaPolsada.equals("A") || teclaPolsada.equals("a")) {
            direccio = DIRECCIO_ESQUERRA;
        }
        
        else if(teclaPolsada.equals("D") || teclaPolsada.equals("d")) {
            direccio = DIRECCIO_DRETA;
        }

//cas que si apretes la Q surti

        else if(teclaPolsada.equals("Q") || teclaPolsada.equals("q")) {
            System.exit(-1);
        }



        // Es mou
        //switch(direccio) {
        switch(direccio) {
        case DIRECCIO_AMUNT:
            if(caselles[posicioY-1][posicioX].esOcupable()) {
                posicioY = posicioY - 1;
            }
            break;
        case DIRECCIO_AVALL:
            if(caselles[posicioY+1][posicioX].esOcupable()) {
                posicioY = posicioY + 1;
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

		/* igual que als fantasmes, mirar si pot anar amunt, avall, dreta o esquerra */



    /**
     * Comprova si la posici� del jugador coincideix amb la de un altre donat
     * @param un altre Jugador amb el que comparar la posici�
     * @return true si coincideixen, false si no.
     */
    public boolean coincide(Jugador altre) {
        return altre.getPosicioX() == posicioX && altre.getPosicioY() == posicioY;
    }
	//igual que als fantasmes	

    /**
     * Comprova si la posici� d'aquest jugador coincideix amb una donada
     * @param x Posici� x donada
     * @param y Posici� y donada
     * @return true si coincideixen, false si no
     */
    public boolean coincide(int x, int y) {
        return x == posicioX && y == posicioY;
    }
	//igual que als fantasmes

    /**
     * Retorna la posici� x del jugador
     * @return La posici� x del jugador
     */
    public int getPosicioX() {
        return posicioX;
    }
    /**
     * Retorna la posici� y del jugador
     * @return La posici� y del jugador
     */
    public int getPosicioY() {
        return posicioY;
    }
    /**
     * Estableix la posici� X del jugador
     * @param posicioX La posici� X
     */
    public void setPosicioX(int posicioX) {
        this.posicioX = posicioX;
    }
    /**
     * Estableix la posici� Y del jugador
     * @param posicioY La posici� Y
     */
    public void setPosicioY(int posicioY) {
        this.posicioY = posicioY;
    }
    /**
     * Estableix la direcci� del jugador
     * @param direccio La direcci�
     */
    public void setDireccio(int direccio) {
        this.direccio = direccio;
    }
    /**
     * Retorna la direcci� actual del jugador
     * @return La direcci� actual del jugador
     */
    public int getDireccio() {
        return direccio;
    }
}
    

