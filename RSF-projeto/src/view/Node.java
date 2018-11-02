/**
 * Classe Node
 * Essa classe implementa a estrutura de um nó.
 * A variável -bcFlag- é usada para indicar se um dado pacote 
 * já passou pelo nó (evitar loop de roteamento).
 * O -pkt- inicialmente foi pensado como arrayList para 
 * atribuir os cabeçalhos dos nós por onde o pacote passa (não implementado).
 */
package view;

import java.util.ArrayList;

public class Node {
	boolean bcFlag;
	String[] neighbords;
	String id;
	ArrayList<String> pkt = new ArrayList<String>(); 
	
	public Node(String[] neighbords, String id) {
		super();
		this.neighbords = neighbords;
		this.id = id;
	}

	public ArrayList<String> getPkt() {
		return pkt;
	}

	public void setPkt(String pkt) {
		this.pkt.add(pkt);
	}
	
	public boolean isBcFlag() {
		return bcFlag;
	}

	public void setBcFlag(boolean bcFlag) {
		this.bcFlag = bcFlag;
	}

	
}
