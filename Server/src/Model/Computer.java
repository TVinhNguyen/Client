package Model;

public class Computer {
	private int idComputer;
	private String nameComputer;
	private int statusComputer;
	public Computer(int idComputer, String nameComputer,int statusComputer) {
		super();
		this.idComputer = idComputer;
		this.nameComputer = nameComputer;
		this.statusComputer = statusComputer;
	}
	public int getIdComputer() {
		return idComputer;
	}

	public void setIdComputer(int idComputer) {
		this.idComputer = idComputer;
	}

	public String getNameComputer() {
		return nameComputer;
	}
	public void setNameComputer(String nameComputer) {
		this.nameComputer = nameComputer;
	}
	public int getStatusComputer() {
		return statusComputer;
	}
	public void setStatusComputer(int statusComputer) {
		this.statusComputer = statusComputer;
	}

	/*
	 * public void assignUser() { setStatus(true); } public void releaseUser() {
	 * setStatus(false); } public double calculateUsageCost(long duration) { logic
	 * here return 0.0; }
	 */
}