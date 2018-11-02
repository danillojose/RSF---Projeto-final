/**
 * Classe Node
 * Essa classe implementa a estrutura de um n�.
 * A vari�vel -bcFlag- � usada para indicar se um dado pacote 
 * j� passou pelo n� (evitar loop de roteamento).
 * O -pkt- inicialmente foi pensado como arrayList para 
 * atribuir os cabe�alhos dos n�s por onde o pacote passa (n�o implementado).
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
