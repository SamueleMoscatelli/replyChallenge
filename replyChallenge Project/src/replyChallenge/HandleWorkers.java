package replyChallenge;

import java.util.ArrayList;

import javafx.concurrent.Worker;

public class HandleWorkers {
	
	public int pickDeveloper(ArrayList<Worker> workers, Worker w){
		int tp=0;
		int wp=0;
		int bp=0;
		for(int i=0;i<workers.size();i++) {
			wp=0;
			bp=0;
			if (workers.get(i) instanceof Developer) {
				wp=calculateWp((Developer)workers.get(i),(Developer)w);
			}
			bp=calculateBp(workers.get(i),w);
			tp=tp+wp+bp;
		}
		return tp;
	}
	
	public int pickManager(ArrayList<Worker> workers, Worker w){
		int tp=0;
		int wp=0;
		int bp=0;
		for(int i=0;i<workers.size();i++) {
			wp=0;
			bp=0;
			if (workers.get(i) instanceof Developer) {
				wp=calculateWp((Developer)workers.get(i),(Developer)w);	
			}
			bp=calculateBp(workers.get(i),w);
			tp=tp+wp+bp;
		}
		return tp;
	}
	
	public int calculateWp(Developer d1, Developer d2) {
		int wp=0;
		ArrayList<String> skills1= d1.getSkills();
		ArrayList<String> skills2= d2.getSkills();
		ArrayList<String> common = new ArrayList<String>();
		ArrayList<String> notcommon = new ArrayList<String>();
		for (int i=0; i<skills1.size(); i++) {
			boolean flag=true;
			for (int j=0; j<skills2.size(); j++) {
				if (skills1.get(i).equals(skills2.get(j))) {
					flag=false;
					common.add(skills1.get(i));
					skills2.remove(j);
					break;
				}
			}
			if (flag) {
				notcommon.add(skills1.get(i));
			}
		}
		for (int k=0; k<skills2.size(); k++) {
			notcommon.add(skills2.get(k));
		}
		return common.size()*notcommon.size();
	}
	
	public int calculateBp(Worker w1, Worker w2) {
		if (w1.getCompany().equals(w2.getCompany())) {
			return w1.getBonus()*w2.getBonus();
		}
		else
			return 0;
	}
	public Worker maxManager(ArrayList<Worker> neighbours,ArrayList<Worker> all)
	{
		int max=0;
		Worker res=null;
		for(int i=0;i<all.size();++i)
		{
			Worker work=all.get(i);
			if(work instanceof ProjectManager&&((ProjectManager)work).getPosition().equals("X"))
			{
				int temp= pickManager(neighbours, all.get(i));
				if(temp>max)
				{
					max=temp;
					res=all.get(i);
				}
			}
		}
		return res;
	}

	public int maxDeveloper(ArrayList<Worker> neighbours,ArrayList<Worker> all)
	{
		int max=0;
		Worker res=null;
		for(int i=0;i<all.size();++i)
		{
			Worker work=all.get(i);
			if(work instanceof Developer&&((Developer)work).getPosition().equals("X"))
			{
				int temp= pickDeveloper(neighbours, all.get(i));
				if(temp>max)
				{
					max=temp;
					res=all.get(i);
				}
			}
		}
		return res;
	}
	
}
