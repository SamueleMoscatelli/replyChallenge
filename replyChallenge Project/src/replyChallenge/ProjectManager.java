package replyChallenge;

public class ProjectManager extends Worker{

	public ProjectManager() {
		
	}
	
	public ProjectManager(String company, int bonus) {
		this.company=company;
		this.bonus=bonus;
	}
	
	private String company;
	private int bonus;
	
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
