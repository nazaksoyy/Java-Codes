package file;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class WriteFile {
	private PrintWriter file=null;
	
	public void write(String str){
		file.print(str);
	}
	public void write(int number){
		file.print(number);
	}
	public void writeln(String str){
		file.print(str);
	}
	public void write(Object obj){
		file.print(obj);
	}
	public void writeln(int number){
		file.print(number);
	}
	public void openWFile(String fileName){
		try{
			file = new PrintWriter (new FileOutputStream (fileName),true);
		} catch (FileNotFoundException fileNotFoundException){
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}
	public void closeWFile(){
		if (file != null){
			file.close();
		}
	}
}
