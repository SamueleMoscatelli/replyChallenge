package replyChallenge;

public class ProjectManager {

	public ProjectManager() {
		
	}
	
	public ProjectManager(String company, int bonus, String pos) {
		this.company=company;
		this.bonus=bonus;
		this.position=pos;
	}
	
	private String company;
	private int bonus;
	private String position;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	
}
