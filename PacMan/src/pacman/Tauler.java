package pacman;

public class Tauler {

	//la classe Tauler representa el taulell del joc
	
	//variable per guardar la informació de les caselles del tauler del joc:
	private Casella[][] caselles;
	
	//variable per guardar la informació de la llista dels fantasmes del joc:
	private Fantasma[] fantasmes;
	
	//variable per guardar la informació del jugador del joc:
	private Jugador prota;
	
	//variable on guardar l'amplada del taulell:
	private int amplada;
	
	//variable on guardar l'altura del taulell:
	private int altura;
	
	//variable per guardar els punts de la partida actual del jugador:
	private int punts;
	
	//variable per guardar les vides que li queden al protagonista:
	private int vides;
	
	//variables que defineixen la posició inicial del jugador:
	private int jugadorXInicial, jugadorYInicial, jugadorDireccioInicial;
	
	//variables que defineixen la posició inicial dels fantasmes:
	private int[] fantasmesXInicial, fantasmesYInicial, fantasmesDireccioInicial;
	
	//constant per guardar l'increment de punts (cada vegada que el jugador "menji" un se sumaran 10 punts):
	private static final int INCREMENT_PUNTS = 10;
	
	//constant per guardar el numero de vides inicials que té el jugador (tindrà 3):
	private static final int VIDES_INICIALS = 3;
	
	//definim l'amplada i l'altura del taulell:
	private static final int AMPLADA = 19;
	private static final int ALTURA = 17;
	
	//constructor del taulell per defecte:
	public Tauler(){
		this.amplada = AMPLADA;
		this.altura = ALTURA;
		int mur = Casella.TIPUS_MUR;
		int punt = Casella.TIPUS_PUNT;
		int punt_especial = Casella.TIPUS_PUNT_ESPECIAL;
        int[][] taulell = new int[][] {  //taulell abans era tmp
                {mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur},
                {mur,punt,punt,punt,punt,punt,punt,punt,punt,mur,punt,punt,punt,punt,punt,punt,punt,punt,mur},
                {mur,punt,mur,mur,punt,mur,mur,mur,punt,mur,punt,mur,mur,mur,punt,mur,mur,punt,mur},
                {mur,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,mur},
                {mur,punt,mur,mur,punt,mur,punt,mur,mur,mur,mur,mur,punt,mur,punt,mur,mur,punt,mur},
                {mur,punt,punt,punt,punt,mur,punt,punt,punt,mur,punt,punt,punt,mur,punt,punt,punt,punt,mur},
                {mur,mur,mur,mur,punt,mur,mur,mur,punt,mur,punt,mur,mur,mur,punt,mur,mur,mur,mur},
                {mur,mur,mur,mur,punt,mur,punt,punt,punt,punt,punt,punt,punt,mur,punt,mur,mur,mur,mur},
                {mur,mur,mur,mur,punt,punt,punt,mur,mur,mur,mur,mur,punt,punt,punt,mur,mur,mur,mur},
                {mur,mur,mur,mur,punt,mur,punt,punt,punt,punt,punt,punt,punt,mur,punt,mur,mur,mur,mur},
                {mur,mur,mur,mur,punt,mur,mur,mur,punt,mur,punt,mur,mur,mur,punt,mur,mur,mur,mur},
                {mur,punt,punt,punt,punt,mur,punt,punt,punt,mur,punt,punt,punt,mur,punt,punt,punt,punt,mur},
                {mur,punt,mur,mur,punt,mur,punt,mur,mur,mur,mur,mur,punt,mur,punt,mur,mur,punt,mur},
                {mur,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,punt,mur},
                {mur,punt,mur,mur,punt,mur,mur,mur,punt,mur,punt,mur,mur,mur,punt,mur,mur,punt,mur},
                {mur,punt,punt,punt,punt,punt,punt,punt,punt,mur,punt,punt,punt,punt,punt,punt,punt,punt,mur},
                {mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur,mur}
        };
        
        //creació de les caselles:
        this.caselles = new Casella[this.altura][this.amplada];
        for(int i=0;i<this.altura;i++){
        	caselles[i] = new Casella[this.amplada];
        	for(int j=0;j<this.amplada;j++){
        		caselles[i][j] = new Casella(taulell[i][j]);
        	}
        }
        
        //creació dels fantasmes:
        this.fantasmes = new Fantasma[3];
        fantasmes[0] = new Fantasma(1, 1, Fantasma.DIRECCIO_BAIX);
        fantasmes[1] = new Fantasma(6, 5, Fantasma.DIRECCIO_DALT);
        fantasmes[2] = new Fantasma(6, 15, Fantasma.DIRECCIO_DALT);
        
        //creació del jugador:
        this.prota = new Jugador(9, 7, Jugador.DIRECCIO_DRETA);
        this.punts = 0; //al principi el jugador no té cap punt
        this.vides = VIDES_INICIALS; //al principi el jugador té 3 vides
        
        //Si els fantasmes maten al jugador, guardem les seves posicions d'inici:
        jugadorXInicial = prota.getPosicioX();
        jugadorYInicial = prota.getPosicioY();
        jugadorDireccioInicial = prota.getDireccio();
        fantasmesXInicial = new int[fantasmes.length];
        fantasmesYInicial = new int[fantasmes.length];
        fantasmesDireccioInicial = new int[fantasmes.length];
        for(int i=0; i<fantasmes.length;i++){
        	fantasmesXInicial[i] = fantasmes[i].getPosicioX();
        	fantasmesYInicial[i] = fantasmes[i].getPosicioY();
        	fantasmesDireccioInicial[i] = fantasmes[i].getDireccio();
        }
		
	}
	
	//constructor del taulell donats els atributs:
	public Tauler(int ampladaTaulell, int alturaTaulell, Casella[][] caselles, Fantasma[] fantasmes, Jugador prota){
		this.amplada = ampladaTaulell;
		this.altura = alturaTaulell;
		this.caselles = caselles;
		this.fantasmes = fantasmes;
		this.prota = prota;
		this.punts = 0;
		this.vides = VIDES_INICIALS;
		//Si els fantasmes maten al jugador, guardem les seves posicions d'inici:
		jugadorXInicial = prota.getPosicioX();
        jugadorYInicial = prota.getPosicioY();
        jugadorDireccioInicial = prota.getDireccio();
        fantasmesXInicial = new int[fantasmes.length];
        fantasmesYInicial = new int[fantasmes.length];
        fantasmesDireccioInicial = new int[fantasmes.length];
        for(int i=0; i<fantasmes.length;i++){
        	fantasmesXInicial[i] = fantasmes[i].getPosicioX();
        	fantasmesYInicial[i] = fantasmes[i].getPosicioY();
        	fantasmesDireccioInicial[i] = fantasmes[i].getDireccio();
        }
	}
	
	//mètode per realitzar el següent moviment del taulell de joc (moure tant al protagonista com als fantasmes, i incrementar els punts en cas de ser necessari):
	public void seguentMoviment(String teclaPulsada){
		//es mou primer al jugador protagonista:
		prota.moviment(caselles, teclaPulsada);
		//en el cas de que el jugador "menji" punts augmentem el marcador:
		if(caselles[prota.getPosicioY()][prota.getPosicioX()].esPunt()){
			punts += INCREMENT_PUNTS; //punts = punts+INCREMENT_PUNTS
			caselles[prota.getPosicioY()][prota.getPosicioX()].setTipusCasella(Casella.TIPUS_BUIDA);
		}
		//després es mouen els fantasmes:
		for(int i=0; i<fantasmes.length;i++){
			fantasmes[i].moviment(caselles, fantasmes, prota);
		}
	}
	
	//mètode per comprovar si s'ha guanyat la partida:
		public boolean partidaGuanyada(){
			for(int i=0;i<altura;i++){
				for(int j=0;j<amplada;j++){
					if(caselles[i][j].esPunt() || caselles[i][j].esPuntEspecial()){
						return false;
					}
				}
			}
			return true;
		}
		
	//mètode per comprovar si s'ha perdut la partida:
	public boolean partidaPerduda(){
		//comprovem si algun fantasma es troba a la mateixa casella que el jugador:
		for(int i=0;i<fantasmes.length;i++){
			if(fantasmes[i].coincideix(prota.getPosicioX(), prota.getPosicioY())){
				//si es el cas el jugador perd una vida:
				vides = vides-1;
				return true;
			}
		}
		return false;
	}
	
	//mètode per restar una vida al jugador, en cas de que un fantasma l'atrapi:
	public void perdVida(){
		//com he explicat anteriorment, quan el jugador perd una vida tant aquest com els fantasmes tornen a la posició que tenien inicialment:
		prota.setPosicioX(jugadorXInicial);
		prota.setPosicioY(jugadorYInicial);
		prota.setDireccio(jugadorDireccioInicial);
		for(int i=0;i<fantasmes.length;i++){
			fantasmes[i].setPosicioX(fantasmesXInicial[i]);
			fantasmes[i].setPosicioY(fantasmesYInicial[i]);
			fantasmes[i].setDireccio(fantasmesDireccioInicial[i]);
		}
	}
	
	//mètode per representar el tauler de joc en forma de cadena de caràcters:
	public String toString(){
		String representacio = "";
		for(int i=0;i<altura;i++){
			for(int j=0;j<amplada;j++){
				if(prota.coincideix(j,i)){
					representacio +="C"; //símbol del jugador 
				}
				else{
					boolean taulell = true; 
					for(int k=0;k<fantasmes.length;k++){
						if(fantasmes[k].coincideix(j, i)){
							representacio +="?"; //símbol dels fantasmes 
							taulell = false;
						}
					}
					if(taulell){
						representacio += caselles[i][j].toString(); //imprimim les caselles del tauler
					}
				}
			}
			representacio += "\n";
		}
		representacio += "\nPUNTS TOTALS: "+punts+"\n";
		representacio += "VIDES RESTANTS: "+vides+"\n";
		return representacio;
	}
	
	//mètode per retornar el jugador (protagonista del joc):
	public Jugador getJugador(){
		return prota;
	}
	
	//mètode per retornar els fantasmes (enemics del joc):
	public Fantasma[] getFantasmes(){
		return fantasmes;
	}
	
	//mètode per retornar l'amplada del tauler:
	public int getAmplada(){
		return amplada;
	}
	
	//mètode per retornar l'altura del tauler:
	public int getAltura(){
		return altura;
	}
	
	//mètode per retornar les caselles del tauler:
	public Casella[][] getCaselles(){
		return caselles;
	}

	//mètode per retornar el numero de vides que té el jugador:
	public int getVides(){
		return vides;
	}
	
	//mètode per retornar els punts obtinguts pel jugador:
	public int getPunts(){
		return punts;
	}

}
