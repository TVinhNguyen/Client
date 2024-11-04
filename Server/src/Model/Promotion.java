package Model;

import java.sql.Date;

public class Promotion {
    private String idPromotion;
    private String namePromotion;
    private double applicableLevel;
    private Date startDate;
    private Date endDate;
    private boolean statusPromotion;
	public String getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(String idPromotion) {
		this.idPromotion = idPromotion;
	}
	public String getNamePromotion() {
		return namePromotion;
	}
	public void setNamePromotion(String namePromotion) {
		this.namePromotion = namePromotion;
	}
	public double getApplicableLevel() {
		return applicableLevel;
	}
	public void setApplicableLevel(double applicableLevel) {
		this.applicableLevel = applicableLevel;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isStatusPromotion() {
		return statusPromotion;
	}
	public void setStatusPromotion(boolean statusPromotion) {
		this.statusPromotion = statusPromotion;
	}
    
}