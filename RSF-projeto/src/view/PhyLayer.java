/**
 * Classe PhyLayer
 * Essa classe simula a implementa��o da camada f�sica e de roteamento.
 * A partir no nodeCount � gerado uma matriz com os n�s distribuidos de
 * forma aleat�ria. Descobre-se seus vizinhos e � mandado o RREQ por inunda��o
 * para cada n� ligado ao n� src. Se o destino foi alcan�ado o usu�rio saber�.
 */
package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhyLayer {
	
	/*Inicializando arquivo de log*/
	Printer ConsoleFile = new Printer(Common.logFile);
	
	public PhyLayer() throws IOException {

		String[][] topology = new String [Common.NetworkArea][Common.NetworkArea];
		
		List<Integer> numeros = new ArrayList<Integer>();
		for (int i = 0; i < (Common.NetworkArea*Common.NetworkArea); i++) { //Sequencia da mega sena
		    numeros.add(i);
		}
		
		//Embaralha o array
		Collections.shuffle(numeros);
		
		//Atribui uma mensagem as posi�oes definidas no array auxiliar
		//Usamos da lista apenas o n�mero de n�s pedido
		for(int k = 0; k < Common.nodeCount; k++){
			//System.out.println(numeros.get(k));
			topology[numeros.get(k)/Common.NetworkArea][numeros.get(k)%Common.NetworkArea] = Integer.toString(k);
		}
		
		//Imprime a topologia da rede
		
		System.out.println("Disposi��o dos n�s na rede:");
		for(int i = 0; i < Common.NetworkArea; i++) {
			for(int j = 0; j < Common.NetworkArea; j++) {
				ConsoleFile.print(topology[i][j]+"\t");
			}
			ConsoleFile.print("\n");
		}
		
		Neighbords.calculateNeighbors(topology);
		ConsoleFile.println("\n");
		Node[] arrayNodes = new Node[Common.nodeCount];
		
		for(int i = 0; i < Common.nodeCount; i++) {
			arrayNodes[i] = new Node(Neighbords.getVizinhos(Integer.toString(i), topology), Integer.toString(i)); 
		}
		
		//broadcast
		sendMessage(arrayNodes, arrayNodes[Integer.parseInt(Common.src)], "RREQ");
		
		ConsoleFile.print("\nConteudo dos n�s:");
		for(int i = 0; i < Common.nodeCount; i++) {
			ConsoleFile.println("\nNodeID: " + arrayNodes[i].id + "\nVizinhos: ");
			for(int j = 0; j < arrayNodes[i].neighbords.length; j++) {
				ConsoleFile.println(arrayNodes[i].neighbords[j]);
			}
			ConsoleFile.println("PKT: " + arrayNodes[i].pkt);
			System.out.println(arrayNodes[i].bcFlag);
		}
		
	}

	private void sendMessage(Node[] arrayNodes, Node node, String msg) {
		// TODO Auto-generated method stub
		//node.setPkt(msg);
		for (int i = 0; i < node.neighbords.length; i++) { 
			if(!arrayNodes[Integer.parseInt(node.neighbords[i])].isBcFlag()) {
				arrayNodes[Integer.parseInt(node.neighbords[i])].setPkt(msg);
				arrayNodes[Integer.parseInt(node.neighbords[i])].setBcFlag(true);
				sendMessage(arrayNodes, arrayNodes[Integer.parseInt(node.neighbords[i])], msg);
				if(node.id.equals(Common.dest)) {
					ConsoleFile.println("DESTINO ALCAN�ADO!!!");
				}
			}
		}
	}

}
