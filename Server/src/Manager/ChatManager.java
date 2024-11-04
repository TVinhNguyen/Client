package Manager;

import java.util.List;

import Model.ChatMessage;

public class ChatManager {
	private List<ChatMessage> Chats;

	public void addChat(ChatMessage chat) { Chats.add(chat); }
	public void deleteChat(String id) { /* logic */ }
	public ChatMessage findChat(String id) 
	{ 
		return null;
	}
}
