package Model;

import java.time.LocalDateTime;

public class New {
    private String idNew;
    private String titleNew;
    private String contentNew;
    private LocalDateTime timestampNew;
    private String categoryNew;
    
	public New(String idNew, String titleNew, String contentNew, LocalDateTime timestampNew, String categoryNew) {
		super();
		this.idNew = idNew;
		this.titleNew = titleNew;
		this.contentNew = contentNew;
		this.timestampNew = timestampNew;
		this.categoryNew = categoryNew;
	}

	public String getIdNew() {
		return idNew;
	}

	public void setIdNew(String idNew) {
		this.idNew = idNew;
	}

	public String getTitleNew() {
		return titleNew;
	}

	public void setTitleNew(String titleNew) {
		this.titleNew = titleNew;
	}

	public String getContentNew() {
		return contentNew;
	}

	public void setContentNew(String contentNew) {
		this.contentNew = contentNew;
	}

	public LocalDateTime getTimestampNew() {
		return timestampNew;
	}

	public void setTimestampNew(LocalDateTime timestampNew) {
		this.timestampNew = timestampNew;
	}

	public String getCategoryNew() {
		return categoryNew;
	}

	public void setCategoryNew(String categoryNew) {
		this.categoryNew = categoryNew;
	}

	public void displayNews() { /* logic here */ }
}
