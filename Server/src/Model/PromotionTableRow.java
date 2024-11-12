package Model;

import java.sql.Date;

import javafx.scene.control.Button;

public class PromotionTableRow {
	    private int idPromotion;
	    private String namePromotion;
	    private String applicableLevel;
	    private Date startDate;
	    private Date endDate;
	    private String statusPromotion;
	    private Button showPromotion;
		public PromotionTableRow(int idPromotion, String namePromotion, String applicableLevel, Date startDate,
		Date endDate, String statusPromotion, Button showPromotion) {
			this.idPromotion = idPromotion;
			this.namePromotion = namePromotion;
			this.applicableLevel = applicableLevel;
			this.startDate = startDate;
			this.endDate = endDate;
			this.statusPromotion = statusPromotion;
			this.showPromotion = showPromotion;
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
		public String getApplicableLevel() {
			return applicableLevel;
		}
		public void setApplicableLevel(String applicableLevel) {
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
		public String getStatusPromotion() {
			return statusPromotion;
		}
		public void setStatusPromotion(String statusPromotion) {
			this.statusPromotion = statusPromotion;
		}
		public Button getShowPromotion() {
			return showPromotion;
		}
		public void setShowPromotion(Button showPromotion) {
			this.showPromotion = showPromotion;
		}
	    
}
