/**
 * Classe Neighbords
 * Essa classe retorna um array com a vizinhança de uma matriz.
 */
package view;

public final class Neighbords {
	
    public static void calculateNeighbors(String[][] matrix) {
    	
        if (matrix == null) {
            throw new NullPointerException("A matriz de entrada não pode ser nula.");
        }
        
        System.out.println("Vizinhança dos nós (NodeX --> Vizinhos)");
        
        for (int currentRow = 0, 
                 rowCount = matrix.length, 
                 columnCount = matrix[0].length; currentRow < rowCount; currentRow++) {
            for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
                if(matrix[currentRow][currentColumn]!= null) {
	            	System.out.println(matrix[currentRow][currentColumn] 
	                                   + " --> " 
	                                   + collectNeighbors(matrix, rowCount, columnCount, currentRow, currentColumn));
	            	
	            	
            	}
            }
        }
    }

    static String[] getVizinhos(String id, String[][] matrixx){
    	String noAtual;
    	String noVizinho;
    	String[] noVizinho_ind = new String[Common.nodeCount];
    	
    	if (matrixx == null) {
            throw new NullPointerException("Matriz nula.");
        }
        
        for (int currentRow = 0, 
                 rowCount = matrixx.length, 
                 columnCount = matrixx[0].length; currentRow < rowCount; currentRow++) {
            for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
                if(matrixx[currentRow][currentColumn]!= null) {
                	
                	noAtual = matrixx[currentRow][currentColumn];
                	if(noAtual.equals(id)) {
                		noVizinho = collectNeighbors(matrixx, rowCount, columnCount, currentRow, currentColumn);
                		noVizinho_ind = noVizinho.split(" ");
                		return noVizinho_ind;
	            	}
                	else
                		noAtual = null;
            	}
            }
        }
		return null;
    }
   
    private static String collectNeighbors(String[][] matrix, int rowCount, int columnCount, int originCellRow, int originCellColumn) {
        StringBuilder neighbors = new StringBuilder();
        for (int neighborRow = Math.max(0, originCellRow - 1), 
                 neighborRowLimit = Math.min(rowCount, originCellRow + 2), 
                 neighborColumnLimit = Math.min(columnCount, originCellColumn + 2); neighborRow < neighborRowLimit; neighborRow++) {
            for (int neighborColumn = Math.max(0, originCellColumn - 1); neighborColumn < neighborColumnLimit; neighborColumn++) {
                if ((neighborRow != originCellRow || neighborColumn != originCellColumn) && matrix[neighborRow][neighborColumn] != null) {
                    neighbors.append(matrix[neighborRow][neighborColumn] + " ");
                }
            }
        }
        return neighbors.toString();
    }

}