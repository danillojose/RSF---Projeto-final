package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {

	static int nodeCount = 9;		//quantidade de nós
	static int NetworkArea = Math.round((float)nodeCount/2);
	static String msg = "Node";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] topology = new String [NetworkArea][NetworkArea];
		
		List<Integer> numeros = new ArrayList<Integer>();
		for (int i = 0; i < (NetworkArea*NetworkArea); i++) { //Sequencia da mega sena
		    numeros.add(i);
		}
		
		//Embaralha o array
		Collections.shuffle(numeros);
		
		//Atribui uma mensagem as posiçoes definidas no array auxiliar
		//Usamos da lista apenas o número de nós pedido
		for(int k = 0; k < nodeCount; k++){
			//System.out.println(numeros.get(k));
			topology[numeros.get(k)/NetworkArea][numeros.get(k)%NetworkArea] = msg + k;
		}
		
		//Imprime a topologia da rede
		System.out.println("Disposição dos nós na rede:");
		for(int i = 0; i < NetworkArea; i++) {
			for(int j = 0; j < NetworkArea; j++) {
				System.out.print(topology[i][j]+"\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("\n");
		Neighbords.calculateNeighbors(topology);
	}

}
