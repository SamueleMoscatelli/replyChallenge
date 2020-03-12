package replyChallenge;

import java.util.ArrayList;

public class prova {

	
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
}
