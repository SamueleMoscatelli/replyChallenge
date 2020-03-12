package replyChallenge;

public abstract class Worker {
	
	String company;
	int bonus;
	String position;
	Worker(String c,int b,String pos)
	{
		company=c;
		bonus=b;
		position=pos;
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
	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}	

}
