package Model;

import java.sql.Date;

public class Promotion {
    private int idPromotion;
    private String namePromotion;
    private int applicableLevel;
    private Date startDate;
    private Date endDate;
    private boolean statusPromotion;
    private String nodePromotion;
	public Promotion(int idPromotion, String namePromotion, int applicableLevel, Date startDate, Date endDate,
			boolean statusPromotion, String nodePromotion) {
		super();
		this.idPromotion = idPromotion;
		this.namePromotion = namePromotion;
		this.applicableLevel = applicableLevel;
		this.startDate = startDate;
		this.endDate = endDate;
		this.statusPromotion = statusPromotion;
		this.nodePromotion = nodePromotion;
	}
	public int getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}
	public String getNamePromotion() {
		return namePromotion;
	}
	public void setNamePromotion(String namePromotion) {
		this.namePromotion = namePromotion;
	}
	public int getApplicableLevel() {
		return applicableLevel;
	}
	public void setApplicableLevel(int applicableLevel) {
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
	public String getNodePromotion() {
		return nodePromotion;
	}
	public void setNodePromotion(String nodePromotion) {
		this.nodePromotion = nodePromotion;
	}
}