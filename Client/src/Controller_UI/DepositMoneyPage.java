package Controller_UI;

import Controller.CommandHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DepositMoneyPage {
    private CommandHandler commandHandler;
    public DepositMoneyPage() 
    {
    	this.commandHandler = new CommandHandler();
    }
    public Scene createScene() {
        // Hiệu ứng bóng cho giao diện
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetY(5);
        shadowEffect.setColor(Color.color(0, 0, 0, 0.5));

        // Tạo nhãn tiêu đề
        Label titleLabel = new Label("Nạp Tiền");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));  // Kích thước lớn hơn cho tiêu đề
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setEffect(shadowEffect);

        // Nhãn và TextField cho nhập số tiền
        Label promptLabel = new Label("Nhập số tiền muốn nạp (VNĐ):");
        promptLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));  // Tăng cỡ chữ cho phù hợp giao diện lớn
        promptLabel.setTextFill(Color.LIGHTGRAY);

        TextField amountField = new TextField();
        amountField.setPromptText("Số tiền...");
        amountField.setStyle("-fx-background-color: #333333; -fx-text-fill: white; -fx-prompt-text-fill: #aaaaaa; -fx-background-radius: 8;");
        amountField.setFont(Font.font("Arial", FontWeight.NORMAL, 20));  
        amountField.setMaxWidth(250); 

        Button confirmButton = new Button("Xác Nhận");
        confirmButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        confirmButton.setStyle("-fx-background-color: #ff3333; -fx-text-fill: white; -fx-background-radius: 10;");
        confirmButton.setEffect(new DropShadow(3, Color.DARKRED));
        confirmButton.setPrefWidth(140);

        confirmButton.setOnMouseEntered(e -> confirmButton.setStyle("-fx-background-color: #ff6666; -fx-text-fill: white; -fx-background-radius: 10;"));
        confirmButton.setOnMouseExited(e -> confirmButton.setStyle("-fx-background-color: #ff3333; -fx-text-fill: white; -fx-background-radius: 10;"));
        
        confirmButton.setOnAction(e -> {	
        	if(isValidAmount(amountField.getText()))
        	{
            commandHandler.depositMoney(amountField.getText());
            System.out.println("Đã nạp " + amountField.getText() + " VNĐ!");
            ((Stage) confirmButton.getScene().getWindow()).close();
        	} else 
        	{
        		AlertMessage alert = new AlertMessage();
        		alert.showAlert("số tiền phải nhỏ hơn 10,000,000đ");
        	}
        });

        Button cancelButton = new Button("Hủy");
        cancelButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        cancelButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white; -fx-background-radius: 10;");
        cancelButton.setEffect(new DropShadow(3, Color.BLACK));
        cancelButton.setPrefWidth(140);

        cancelButton.setOnMouseEntered(e -> cancelButton.setStyle("-fx-background-color: #555555; -fx-text-fill: white; -fx-background-radius: 10;"));
        cancelButton.setOnMouseExited(e -> cancelButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white; -fx-background-radius: 10;"));

        cancelButton.setOnAction(e -> ((Stage) cancelButton.getScene().getWindow()).close());

        VBox mainLayout = new VBox(20, titleLabel, promptLabel, amountField, confirmButton, cancelButton);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setStyle("-fx-background-color: #1a1a1a; -fx-padding: 30; -fx-background-radius: 12; -fx-border-radius: 12; -fx-border-width: 2; -fx-border-color: #ff3333;");
        mainLayout.setEffect(shadowEffect);

        Scene scene = new Scene(mainLayout, 600, 300);  
        scene.setFill(Color.TRANSPARENT);

        return scene;
    }
    public boolean isValidAmount(String input) {
        try {
            int number = Integer.parseInt(input);
            return number > 0 && number < 10000000;
        } catch (NumberFormatException e) {
            return false; 
        }
    }
}
