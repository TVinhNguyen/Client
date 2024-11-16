package Controller_UI;

import Controller.CommandHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConfirmExchangePage {
    private final int amount;
    private final int hours;
    private CommandHandler commandHandler;
    public ConfirmExchangePage(int amount, int hours) {
        this.amount = amount;
        this.hours = hours;
        commandHandler = new CommandHandler();
    }

    public Scene createScene() {
        Label titleLabel = new Label("Xác Nhận Đổi Tiền");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setEffect(new DropShadow(5, Color.BLACK));

        Label messageLabel = new Label("Bạn có chắc chắn muốn đổi " + amount + " VNĐ lấy " + hours + " giờ chơi không?");
        messageLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        messageLabel.setTextFill(Color.LIGHTGRAY);

        Button confirmButton = new Button("Xác Nhận");
        confirmButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        confirmButton.setStyle("-fx-background-color: #ff3333; -fx-text-fill: white; -fx-background-radius: 8;");
        confirmButton.setPrefWidth(120);
        confirmButton.setEffect(new DropShadow(5, Color.DARKRED));
        confirmButton.setOnAction(e -> {
        	this.commandHandler.changePlayTime(amount , hours);
        	
            ((Stage) confirmButton.getScene().getWindow()).close();
        });

        Button cancelButton = new Button("Hủy");
        cancelButton.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        cancelButton.setStyle("-fx-background-color: #333333; -fx-text-fill: white; -fx-background-radius: 8;");
        cancelButton.setPrefWidth(120);
        cancelButton.setEffect(new DropShadow(5, Color.BLACK));
        cancelButton.setOnAction(e -> ((Stage) cancelButton.getScene().getWindow()).close());

        VBox mainLayout = new VBox(20, titleLabel, messageLabel, confirmButton, cancelButton);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setStyle("-fx-background-color: #1a1a1a; -fx-padding: 30; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-width: 2; -fx-border-color: #ff3333;");

        Scene scene = new Scene(mainLayout, 600, 300);
        scene.setFill(Color.TRANSPARENT);

        return scene;
    }
}
