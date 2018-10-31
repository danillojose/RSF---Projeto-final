package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {

	static String msg = "Node";
	
	public static void main(String[] args) throws IOException {
		/*Inicializando arquivo de log*/
		Printer ConsoleFile = new Printer(Common.logFile);

		String[][] topology = new String [Common.NetworkArea][Common.NetworkArea];
		
		List<Integer> numeros = new ArrayList<Integer>();
		for (int i = 0; i < (Common.NetworkArea*Common.NetworkArea); i++) { //Sequencia da mega sena
		    numeros.add(i);
		}
		
		//Embaralha o array
		Collections.shuffle(numeros);
		
		//Atribui uma mensagem as posiçoes definidas no array auxiliar
		//Usamos da lista apenas o número de nós pedido
		for(int k = 0; k < Common.nodeCount; k++){
			//System.out.println(numeros.get(k));
			topology[numeros.get(k)/Common.NetworkArea][numeros.get(k)%Common.NetworkArea] = msg + k;
		}
		
		//Imprime a topologia da rede
		
		System.out.println("Disposição dos nós na rede:");
		for(int i = 0; i < Common.NetworkArea; i++) {
			for(int j = 0; j < Common.NetworkArea; j++) {
				ConsoleFile.print(topology[i][j]+"\t");
			}
			ConsoleFile.print("\n");
		}
		
		ConsoleFile.println("\n");
		Neighbords.calculateNeighbors(topology);
		
	}

}
