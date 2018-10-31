package view;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Printer {
	private FileWriter fileWriter;
	
	public Printer(File file) throws IOException {
		this.fileWriter = new FileWriter(file); //here you should do some exceptions handling
	}
	
	/*Print without \n*/
	public void print(String msg) {
		try {
			System.out.print(msg);
			fileWriter.write(msg);
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*Print with \n*/
	public void println(String msg) {
		try {
			System.out.print(msg + "\n");
			fileWriter.write(msg + "\n");
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}