package replyChallenge;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner; 

public class FileHandler
{
	File file;
	Scanner scanner;
	
	FileHandler(String path) throws FileNotFoundException
	{
		file=new File(path);
		scanner=new Scanner(file);
	}
	
	void changeFile(String path) throws FileNotFoundException
	{
		scanner.close();
		file=new File(path);
		scanner= new Scanner(file);
	}
	
	String getLine()
	{
	      if (scanner.hasNextLine()) {
	        return scanner.nextLine();
	      }
	      return null;
	}
	
	void closeScanner()
	{
		scanner.close();
	}
	
	public static void main(String[] args) throws IOException
	{
		FileHandler test= new FileHandler("C:\\Users\\Maurizio Maldini\\Desktop\\test.txt");
		try {
			FileWrite.getInstance().createFile("C:\\Users\\Maurizio Maldini\\Desktop\\out1.txt");

			String var=test.getLine();
			while(var!=null)
			{
				var+="\n";
				System.out.print(var);
				FileWrite.getInstance().append(var);
				var=test.getLine();
			}
			test.changeFile("C:\\Users\\Maurizio Maldini\\Desktop\\test.txt");
			FileWrite.getInstance().createFile("C:\\Users\\Maurizio Maldini\\Desktop\\out2.txt");
			var=test.getLine();
			while(var!=null)
			{
				var+="\n";
				System.out.print(var);
				FileWrite.getInstance().append(var);
				var=test.getLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
