package pacman;

public class Casella {
	
	System.out.println("Comentari afegit per Andrei");
	
	//definim el tipus de caselles que hi ha
	public static final int TIPUS_BUIDA = 1;
	public static final int TIPUS_MUR = 2;
	public static final int TIPUS_PUNT = 3;
	public static final int TIPUS_PUNT_ESPECIAL = 4;
	
	//variable on representem el tipus de casella
	private int tipus;
	
	//constructor casella
	public Casella(int tipus){
		this.tipus = tipus;
	}
	
	//comprovar si la casella �s ocupable. Ser� ocupable sempre que no hi hagi un mur
	// true = �s ocupable
	// false = no �s ocupable
	public boolean esOcupable(){
		return tipus !=TIPUS_MUR;   
	}
	
	//comprovar si la casella �s un punt
	// true = �s un punt
	// false = no �s un punt
	public boolean esPunt(){
		return tipus == TIPUS_PUNT;   
	} 
	
	//comprovar si la casella �s un mur
	// true = �s un mur
	// false = no �s un mur
	public boolean esMur(){
		return tipus == TIPUS_MUR;   
	}
	
	//comprovar si la casella est� buida
	// true = est� buida
	// false = est� plena
	public boolean esBuit(){
		return tipus == TIPUS_BUIDA;  
	}
	
	//comprovar si la casella �s un punt especial
	// true = �s punt especial
	// false = no �s punt especial
	public boolean esPuntEspecial(){     
		return tipus == TIPUS_PUNT_ESPECIAL;    
	}

	//seleccionar el tipus d'una casella. Aquest ser� el nou tipus que tindr� la casella
	public void setTipusCasella(int tipusCasella) {
		this.tipus = tipusCasella;
	}
	
	//retornar el tipus d'una casella
	public int getTipusCasella() {
		return this.tipus;
	}
	
	//Per obtenir la representaci� d'una casella en forma de cadena de text:
	public String toString(){
		switch(tipus){
			case TIPUS_BUIDA:
				return " ";
			case TIPUS_MUR:
				return "#";
			case TIPUS_PUNT:
				return ".";
			case TIPUS_PUNT_ESPECIAL:
				return "*";
			default:
				return "";
		}
	}
}
