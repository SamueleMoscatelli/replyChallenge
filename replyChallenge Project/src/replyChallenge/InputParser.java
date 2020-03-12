package replyChallenge;

import java.io.FileNotFoundException;

public class InputParser 
{
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		FileHandler file=new FileHandler("C:\\Users\\Maurizio Maldini\\Downloads\\a_solar.txt");
		String row_col=file.getLine();
		int rowSize = Integer.parseInt(row_col.split(" ")[0]);
		int colSize = Integer.parseInt(row_col.split(" ")[1]);
		char[][] room=new char[colSize][rowSize];
		for(int i=0;i<colSize;++i)
		{
			String temp=file.getLine();
			int j=0;
			while(j<temp.length()){
			room[i][j]=temp.charAt(j++);
			}
		}
		
		
	}
	
}
