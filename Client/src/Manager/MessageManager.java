package Manager;
import Model.ChatMessage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageManager {
	 private static MessageManager instance;
	    private List<ChatMessage> chatMessages;

	    private MessageManager() {
	        this.chatMessages = new ArrayList<>();
	    }

	    public static MessageManager getInstance() {
	        if (instance == null) {
	            instance = new MessageManager();
	        }
	        return instance;
	    }

	    public void addMessage(ChatMessage message) {
	        chatMessages.add(message);
	    }

	    public boolean removeMessage(ChatMessage message) {
	        return chatMessages.remove(message);
	    }

	    public boolean updateMessage(ChatMessage updatedMessage) {
	        for (int i = 0; i < chatMessages.size(); i++) {
	            if (chatMessages.get(i).getTimestamp().equals(updatedMessage.getTimestamp())) {
	                chatMessages.set(i, updatedMessage);
	                return true;
	            }
	        }
	        return false;
	    }

	    public Optional<ChatMessage> getMessageByTimestamp(LocalDateTime timestamp) {
	        return chatMessages.stream()
	                .filter(message -> message.getTimestamp().equals(timestamp))
	                .findFirst();
	    }

	    public List<ChatMessage> getAllMessages() {
	        return new ArrayList<>(chatMessages);
	    }

	    public List<ChatMessage> searchMessagesByContent(String content) {
	        List<ChatMessage> result = new ArrayList<>();
	        for (ChatMessage message : chatMessages) {
	            if (message.getContent().toLowerCase().contains(content.toLowerCase())) {
	                result.add(message);
	            }
	        }
	        return result;
	    }
}
