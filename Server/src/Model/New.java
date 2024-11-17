package Model;

import java.time.LocalDateTime;

public class New {
    private int idNew;
    private String titleNew;
    private String contentNew;
    private LocalDateTime dateNew;
    private byte[] imageNew;
    
	public New(int idNew, String titleNew, String contentNew, LocalDateTime timestampNew, byte[] imageNew) {
		super();
		this.idNew = idNew;
		this.titleNew = titleNew;
		this.contentNew = contentNew;
		this.dateNew = timestampNew;
		this.imageNew=imageNew;
	}

	public int getIdNew() {
		return idNew;
	}

	public void setIdNew(int idNew) {
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
 
	public LocalDateTime getDateNew() {
		return dateNew;
	}

	public void setDateNew(LocalDateTime dateNew) {
		this.dateNew = dateNew;
	}

	public byte[] getImageNew() {
		return imageNew;
	}

	public void setImageNew(byte[] imageNew) {
		this.imageNew = imageNew;
	}

	public void displayNews() { /* logic here */ }
}
