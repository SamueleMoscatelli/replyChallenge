package replyChallenge;

import java.util.ArrayList;

public class Developer {
	private String company;
	private int bonusp;
	private int nskills;
	private ArrayList<String> skills=new ArrayList<String>();
	private String position;
	
	Developer(String co, int bo, int nsk,ArrayList<String> sk,String pos){
		this.setCompany(co);
		this.setBonusp(bo);
		this.setNskills(nsk);
		this.setNskills(nsk);
		this.setSkills(sk);
		this.position=pos;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getBonusp() {
		return bonusp;
	}

	public void setBonusp(int bonusp) {
		this.bonusp = bonusp;
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
