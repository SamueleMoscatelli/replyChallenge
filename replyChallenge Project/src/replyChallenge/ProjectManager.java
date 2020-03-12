package replyChallenge;

public class ProjectManager extends Worker{

	
	
	public ProjectManager(String company, int bonus, String pos) {
		super(company,bonus);
		this.setPosition(pos);
	}
	
	
	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	private String position;
	
	

	
}
