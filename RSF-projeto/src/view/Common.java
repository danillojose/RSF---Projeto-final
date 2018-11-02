/**
 * Classe Common
 * Essa classe declara e calcula todas as variáveis utilizadas no projeto.
 */
package view;

import java.io.File;

public final class Common {
	public static final int nodeCount = 9;		//quantidade de nós
	public static final String src = "0";
	public static final String dest = "4";
	public static final int NetworkArea = Math.round((float)nodeCount/2);
	public static final File logFile = new File("LogFile.log");
	public static int TTL;
}

