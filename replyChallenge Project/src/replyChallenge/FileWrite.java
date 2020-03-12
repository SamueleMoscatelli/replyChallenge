package replyChallenge;


import java.io.File;
import java.io.FileWriter;   
import java.io.IOException;

public class FileWrite {

	File file=null;
	FileWriter fw=null;
	private FileWrite()
	{
		
	}
	
	static 
	{
		instance=new FileWrite();
	}
	
	static FileWrite instance;
	
	static FileWrite getInstance()
	{
		return instance;
	}
	
	public void createFile(String fullPath) throws IOException
	{
		if(fw!=null)
		{
			this.close();
		}
		file = new File(fullPath);
		fw=new FileWriter(file);
	}
	
	public void append(String app) throws IOException
	{
		fw.write(app);
	}
	
	public void close() throws IOException
	{
		fw.close();
	}
	
}
