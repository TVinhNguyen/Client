package Model;

import java.time.LocalDateTime;

public class ChatMessage {
    private String sender;
    private String content;
    private LocalDateTime timestamp;
    private boolean isUser;

    public ChatMessage(String sender, String content, boolean isUser) {
        this.sender = sender;
        this.content = content;
        this.isUser = isUser;
        this.timestamp = LocalDateTime.now();
    }
	public boolean isUser() {
		return isUser;
	}
	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}
	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	@Override
    public String toString() {
        return "[" + timestamp + "] " + sender + ": " + content;
    }
}
