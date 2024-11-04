package Controller_UI;

import java.sql.SQLException;

import Controller.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class controllerLogin {
	@FXML 
	private TextField username;
	@FXML 
	private PasswordField password;
	@FXML
	private Button btnLog;
	@FXML
	private Button btnClose;
	@FXML
	public void clickLogin(MouseEvent e) throws SQLException {
	    Stage currentStage = (Stage) btnLog.getScene().getWindow();
	    currentStage.close();
	    Login loginInstance = new Login();

	    boolean isSuccess = loginInstance.login(username.getText(), password.getText());

	    if (isSuccess) {
	        System.out.println("Login successful!");
	    } else {
	        System.out.println("Login failed.");
	    }

	}
	@FXML 
	public void clickClose(ActionEvent e) {
		Stage currentStage = (Stage) btnClose.getScene().getWindow();
	    currentStage.close();
	}
}
