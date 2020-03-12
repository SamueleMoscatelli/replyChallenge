package replyChallenge;

public abstract class Worker {
	
	String company;
	int bonus;
	
	Worker(String c,int b)
	{
		company=c;
		bonus=b;
	}
	
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
