package Controller_UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Controller.Client;
import Manager.MessageManager;  // Import ChatMessageManager
import Model.ChatMessage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class ControllerChat {
    private Client client = Client.getInstance();
    private MessageManager chatMessageManager = MessageManager.getInstance();  

    public static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }

    @FXML
    private ListView<ChatMessage> chatListView;

    @FXML
    private TextField inputField;

    @FXML
    private Button sendButton;

    private ObservableList<ChatMessage> chatMessages;

    @FXML
    public void initialize() {
        chatMessages = FXCollections.observableArrayList();
        chatListView.setItems(chatMessages);
        chatListView.setCellFactory(lv -> new ListCell<ChatMessage>() {
            @Override
            protected void updateItem(ChatMessage item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                    setStyle(null);
                } else {
                    Label timestampLabel = new Label(formatDateTime(item.getTimestamp()));
                    timestampLabel.getStyleClass().add("timestamp-label");

                    Label contentLabel = new Label(item.getContent());
                    contentLabel.getStyleClass().add("content-label");

                    VBox messageBox = new VBox(3, timestampLabel, contentLabel);

                    if (item.isUser()) {
                        messageBox.getStyleClass().add("client-message");
                    } else {
                        messageBox.getStyleClass().add("server-message");
                    }

                    setGraphic(messageBox);
                }
            }
        });

        loadPreviousMessages();

        sendButton.setOnAction(event -> sendMessage());
        inputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                sendMessage();
            }
        });
    }

    private void loadPreviousMessages() {
        List<ChatMessage> previousMessages = chatMessageManager.getAllMessages();
        chatMessages.addAll(previousMessages);
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        
        ChatMessage newMessage = new ChatMessage(client.getUser().getUsername(), message, true);
        if (!message.isEmpty()) {
            chatMessages.add(newMessage);  
            inputField.clear();

            String messageForm = "SEND_MESSAGE " + this.client.getUser().getUsername() + ":" + message;
            client.sendMessage(messageForm);

            chatMessageManager.addMessage(newMessage);
        }
    }
    public void getMessage(ChatMessage message)
    {
    	 Platform.runLater(() -> {
    		 chatMessages.add(message);
    	    	MessageManager.getInstance().addMessage(message);
    	    });
    	

    }
}
