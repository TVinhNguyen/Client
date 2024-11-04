package Model;

import java.time.LocalDateTime;

public class Combo {
 private String comboId;
 private String name;
 private LocalDateTime startHour;
 private LocalDateTime endHour;
 private boolean isAvailable;
 private long usageTime;

 
 public String getComboId() {
	return comboId;
}


public void setComboId(String comboId) {
	this.comboId = comboId;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public LocalDateTime getStartHour() {
	return startHour;
}


public void setStartHour(LocalDateTime startHour) {
	this.startHour = startHour;
}


public LocalDateTime getEndHour() {
	return endHour;
}


public void setEndHour(LocalDateTime endHour) {
	this.endHour = endHour;
}


public long getUsageTime() {
	return usageTime;
}


public void setUsageTime(long usageTime) {
	this.usageTime = usageTime;
}


public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}


public boolean isAvailable() { return isAvailable; }
}