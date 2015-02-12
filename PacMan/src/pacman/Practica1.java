package pacman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pacman.*;

public class Practica1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	//Aquí es desenvoluparà el joc del pacman:
		
		//Primer de tot creem el tauler:
		Tauler taulell = new Tauler();
		System.out.println("BENVINGUT AL JOC DEL PACMAN !!\n");
		
		while(!taulell.partidaGuanyada()){ //mentre no hagim guanyat, contiua el joc:
			System.out.println(taulell.toString());
			InputStreamReader entrada = new InputStreamReader(System.in);
			BufferedReader lectura = new BufferedReader(entrada);
			//Demanar el moviment a realitzar pel protagonista:
			System.out.println("Introdueix el moviment que vols realitzar W/A/S/D o Q per sortir!");
			String teclaPulsada = "";
			try{
				teclaPulsada = lectura.readLine(); //llegim el moviment entrat
			}catch(IOException e){
				System.out.println("Error al llegir les dades introduïdes per teclat!");
				System.exit(-1);
			}
			taulell.seguentMoviment(teclaPulsada); //demanem el següent moviment
			if(taulell.partidaPerduda()){ //si ens ha atrapat un fantasma
				if(taulell.getVides() == 0){ //i si no ens queden mes vides, hem perdut el joc
					System.out.println("\n NO ET QUEDEN VIDES!! HAS PERDUT :( \n");
					System.exit(-1);
				}
				else{
					//en canvi, si ens atrapa un fantasma, però encara ens queda vides, perdem una i retornem a la posició inicial
					System.out.println("\n T'HA ATRAPAT UN FANTASMA! HAS PERDUT UNA VIDA !\n");
					taulell.perdVida();
				}
			}
		}
		System.out.println("\nFELICITATS!! HAS GUANYAT EL JOC DEL PACMAN :)");
		System.exit(0);
	}

}
