package Model;

public class Computer {
    private String computerId;
    private boolean status;
    private double hourlyRate;

    public String getComputerId() {
		return computerId;
	}
	public void setComputerId(String computerId) {
		this.computerId = computerId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public void assignUser() { setStatus(true); }
    public void releaseUser() { setStatus(false); }
    public double calculateUsageCost(long duration) { /* logic here */ return 0.0; }
}