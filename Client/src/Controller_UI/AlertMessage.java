package Controller_UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertMessage{

    public void showAlert(String message) {
        Stage alertStage = new Stage();
        alertStage.initModality(Modality.APPLICATION_MODAL);
        alertStage.setTitle("Thông Báo");

        Label titleLabel = new Label("Thông Báo");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.RED);

        Label messageLabel = new Label(message);
        messageLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        messageLabel.setTextFill(Color.DARKGRAY);

        Button okButton = new Button("OK");
        okButton.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        okButton.setStyle("-fx-background-color: #ff3333; -fx-text-fill: white;");
        okButton.setOnAction(e -> alertStage.close());

        VBox layout = new VBox(20, titleLabel, messageLabel, okButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #1a1a1a; -fx-padding: 20;");

        Scene scene = new Scene(layout, 400, 200);
        alertStage.setScene(scene);
        alertStage.showAndWait();
    }
}

