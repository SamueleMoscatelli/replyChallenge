package replyChallenge;

import java.util.ArrayList;

public class Developer extends Worker{
	
	
	

	private int nskills;
	private ArrayList<String> skills=new ArrayList<String>();
	private String position;
	
	Developer(String co, int bo, int nsk,ArrayList<String> sk,String pos){
		super(co,bo);
		this.setNskills(nsk);
		this.setNskills(nsk);
		this.setSkills(sk);
		this.position=pos;
	}

	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}	

	public int getNskills() {
		return nskills;
	}

	public void setNskills(int nskills) {
		this.nskills = nskills;
	}

	public ArrayList<String> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
	
	

}
