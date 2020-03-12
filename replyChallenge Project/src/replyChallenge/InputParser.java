package replyChallenge;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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
		int devCount=Integer.parseInt(file.getLine());
		ArrayList<Developer> developers = new ArrayList<Developer>();
		for(int i=0; i<devCount;++i)
		{
			String temp=file.getLine();
			String[] values=temp.split(" ");
			String company=values[0];
			int bonus=Integer.parseInt(values[1]);
			int nsk= Integer.parseInt(values[2]);
			ArrayList<String> skills=new ArrayList<String>();
			for(int j=0;j<nsk;++j)
			{
				skills.add(values[3+j]);
			}
			developers.add(new Developer(company,bonus,nsk,skills,""));
		}
		int pManagerCount=Integer.parseInt(file.getLine());
		ArrayList<ProjectManager> pManagers= new ArrayList<ProjectManager>();
		for(int i=0;i<pManagerCount;++i)
		{
			String temp=file.getLine();
			String[] values= temp.split(" ");
			String company=values[0];
			int bonus= Integer.parseInt(values[1]);
			ProjectManager pm=new ProjectManager(company,bonus,"");
			pManagers.add(pm);
		}
		System.out.println("end");
	}
	
}
