package Model;


public class Computer {
	private int idComputer;
	private String nameComputer;
	private int statusComputer;
	public static int HourlyRate = 10000;
	public Computer(int idComputer, String nameComputer,int statusComputer) {
		super();
		this.idComputer = idComputer;
		this.nameComputer = nameComputer;
		this.statusComputer = statusComputer;
	}
	
	public static int getHourlyRate() {
		return HourlyRate;
	}

	public static void setHourlyRate(int getHourlyRate) {
		Computer.HourlyRate = getHourlyRate;
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

	
}