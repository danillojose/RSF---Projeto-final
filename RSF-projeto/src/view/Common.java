package view;

import java.io.File;

public final class Common {
	public static final int nodeCount = 7;		//quantidade de nós
	public static final int NetworkArea = Math.round((float)nodeCount/2);
	public static final File logFile = new File("LogFile.log");
	
	public static final int rlHeaderLen = 10;
}

