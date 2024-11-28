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

	    // Thêm một tin nhắn
	    public void addMessage(ChatMessage message) {
	        chatMessages.add(message);
	    }

	    // Xoá tin nhắn theo ID (hoặc có thể dựa vào chỉ số, đây chỉ là ví dụ)
	    public boolean removeMessage(ChatMessage message) {
	        return chatMessages.remove(message);
	    }

	    // Cập nhật tin nhắn
	    public boolean updateMessage(ChatMessage updatedMessage) {
	        for (int i = 0; i < chatMessages.size(); i++) {
	            if (chatMessages.get(i).getTimestamp().equals(updatedMessage.getTimestamp())) {
	                chatMessages.set(i, updatedMessage);
	                return true;
	            }
	        }
	        return false;
	    }

	    // Lấy tin nhắn theo ID hoặc timestamp
	    public Optional<ChatMessage> getMessageByTimestamp(LocalDateTime timestamp) {
	        return chatMessages.stream()
	                .filter(message -> message.getTimestamp().equals(timestamp))
	                .findFirst();
	    }

	    // Lấy tất cả tin nhắn
	    public List<ChatMessage> getAllMessages() {
	        return new ArrayList<>(chatMessages);
	    }

	    // Tìm kiếm tin nhắn theo nội dung
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
