package Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Session {
    private static final double RATE_PER_HOUR = 10.0; 
    private String sessionId;
    private LocalDateTime  startTime;
    private LocalDateTime  endTime;
    private UserAccount user;
    private Computer computer;
    
    public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public UserAccount getUser() {
		return user;
	}
	public void setUser(UserAccount user) {
		this.user = user;
	}
	  public void startSession() {
	        startTime = LocalDateTime.now();
	        System.out.println("Session ID: " + sessionId + " started at: " + startTime);
	    }

	    public void endSession() {
	        endTime = LocalDateTime.now();
	        System.out.println("Session ID: " + sessionId + " ended at: " + endTime);
	    }

	    public long getSessionDurationInMinutes() {
	        if (startTime != null && endTime != null) {
	            return Duration.between(startTime, endTime).toMinutes();
	        }
	        return 0;
	    }

	    public double calculateSessionCost() {
	        long durationInMinutes = getSessionDurationInMinutes();
	        double cost = (durationInMinutes / 60.0) * RATE_PER_HOUR;
	        System.out.println("Session ID: " + sessionId + " cost: " + cost + " VND");
	        return cost;
	    }
}