package view;

import java.io.IOException;

public final class Neighbords {

    public static void calculateNeighbors(String[][] matrix) throws IOException {
    	Printer ConsoleFile = new Printer(Common.logFile);
    	
        if (matrix == null) {
            throw new NullPointerException("A matriz de entrada não pode ser nula.");
        }
        
        ConsoleFile.println("Vizinhança dos nós (NodeX --> Vizinhos)");
        
        for (int currentRow = 0, 
                 rowCount = matrix.length, 
                 columnCount = matrix[0].length; currentRow < rowCount; currentRow++) {
            for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
                if(matrix[currentRow][currentColumn]!= null) {
	            	ConsoleFile.println(matrix[currentRow][currentColumn] 
	                                   + " --> " 
	                                   + collectNeighbors(matrix, rowCount, columnCount, currentRow, currentColumn));
            	}
            }
        }
    }

    private static String collectNeighbors(String[][] matrix, int rowCount, int columnCount, int originCellRow, int originCellColumn) {
        StringBuilder neighbors = new StringBuilder();
        for (int neighborRow = Math.max(0, originCellRow - 1), 
                 neighborRowLimit = Math.min(rowCount, originCellRow + 2), 
                 neighborColumnLimit = Math.min(columnCount, originCellColumn + 2); neighborRow < neighborRowLimit; neighborRow++) {
            for (int neighborColumn = Math.max(0, originCellColumn - 1); neighborColumn < neighborColumnLimit; neighborColumn++) {
                if ((neighborRow != originCellRow || neighborColumn != originCellColumn) && matrix[neighborRow][neighborColumn] != null) {
                    neighbors.append(" " + matrix[neighborRow][neighborColumn]);
                }
            }
        }
        return neighbors.toString();
    }

}