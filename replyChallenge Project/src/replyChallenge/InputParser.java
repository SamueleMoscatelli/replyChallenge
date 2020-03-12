package replyChallenge;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class InputParser 
{


	public static void main(String[] args) throws IOException
	{
		FileHandler file=new FileHandler("C:\\Users\\Maurizio Maldini\\Downloads\\f_glitch.txt");
		String row_col=file.getLine();
		int rowSize = Integer.parseInt(row_col.split(" ")[0]);
		int colSize = Integer.parseInt(row_col.split(" ")[1]);
		char[][] room=new char[colSize][rowSize];
		Worker[][] roomW=new Worker[colSize][rowSize];
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
		ArrayList<Developer> developers1 = new ArrayList<Developer>();
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
			Developer d=new Developer(company,bonus,nsk,skills,"X");
			developers.add(d);
			developers1.add(d);	
			
		}
		int pManagerCount=Integer.parseInt(file.getLine());
		ArrayList<ProjectManager> pManagers= new ArrayList<ProjectManager>();
		ArrayList<ProjectManager> pManagers1= new ArrayList<ProjectManager>();
		for(int i=0;i<pManagerCount;++i)
		{
			String temp=file.getLine();
			String[] values= temp.split(" ");
			String company=values[0];
			int bonus= Integer.parseInt(values[1]);
			ProjectManager pm=new ProjectManager(company,bonus,"X");
			pManagers.add(pm);
			pManagers1.add(pm);
		}
		System.out.println("end");
		Collections.shuffle(pManagers1);
		Collections.shuffle(developers1);
		int indxD=developers.size()-1;
		int indxM=pManagers.size()-1;
		for(int i=0;i<colSize;i++) {
			for(int j=0;j<rowSize;j++) {
				if((i+j)%2!=0)
					continue;
				if (room[i][j]=='_') {
					if(indxD>0) {
						roomW[i][j]=developers1.get(indxD);
						developers1.get(indxD).setPosition(Integer.toString(j)+" "+Integer.toString(i));
						indxD--;
					}
				}
				else if (room[i][j]=='M') {
					if(indxM>0) {

						roomW[i][j]=pManagers1.get(indxM);
						pManagers1.get(indxM).setPosition(Integer.toString(j)+" "+Integer.toString(i));

						indxM--;
					}
				}
			}
		}
		ArrayList<Worker> disponibili;
		Worker ideale;
		for(int i=0;i<colSize;i++) {
			for(int j=0;j<rowSize;j++) {
				if((i+j)%2==0)
					continue;
				disponibili=new ArrayList<Worker>();
				if (room[i][j]=='_') {
					if(i>0 && roomW[i-1][j]!=null) {
						disponibili.add(roomW[i-1][j]);
					}
					if(j>0 && roomW[i][j-1]!=null) {
						disponibili.add(roomW[i][j-1]);
					}
					if(i<colSize-1 && roomW[i+1][j]!=null) {
						disponibili.add(roomW[i+1][j]);
					}
					if(j<rowSize-1 && roomW[i][j+1]!=null) {
						disponibili.add(roomW[i][j+1]);
					}
					ideale=HandleWorkers.maxDeveloper(disponibili, developers);
					if(ideale!=null)ideale.setPosition(Integer.toString(j)+" "+Integer.toString(i));
				}
				else if (room[i][j]=='M') {
					if(i>0 && roomW[i-1][j]!=null) {
						disponibili.add(roomW[i-1][j]);
					}
					if(j>0 && roomW[i][j-1]!=null) {
						disponibili.add(roomW[i][j-1]);
					}
					if(i<colSize-1 && roomW[i+1][j]!=null) {
						disponibili.add(roomW[i+1][j]);
					}
					if(j<rowSize-1 && roomW[i][j+1]!=null) {
						disponibili.add(roomW[i][j+1]);
					}
					ideale=HandleWorkers.maxManager(disponibili, pManagers);
					if(ideale!=null)ideale.setPosition(Integer.toString(j)+" "+Integer.toString(i));
				}
			}
		}

		FileWrite fw=FileWrite.getInstance();
		fw.createFile("C:\\Users\\Maurizio Maldini\\Downloads\\f_output.txt");
		for(int i=0;i<developers.size();i++) {
			fw.append(developers.get(i).getPosition()+"\n");
		}
		for(int i=0;i<pManagers.size();i++) {
			fw.append(pManagers.get(i).getPosition()+"\n");
		}
		fw.close();
	}

}
