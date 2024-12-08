package Controller_UI;


import Controller.Client;
import Controller.CommandHandler;
import Model.UserAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerLogin {
	private Client client;
	public ControllerLogin() {
		client = Client.getInstance();
		
	}
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button login;
	public void dangnhap(ActionEvent e) {
		String username = usernameField.getText();
		String password = passwordField.getText();
		 if (isValidLogin(username, password) != false) {
			 try {
				 	
				 	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/client.fxml"));
				 
			        Parent newRoot = loader.load();
			        
			        Stage newStage = new Stage();
			        newStage.initStyle(StageStyle.UNDECORATED);
			        newStage.setTitle("Dashboard");
			        newStage.setScene(new Scene(newRoot));

			        newStage.show();

			    } catch(Exception ex) {
			        ex.printStackTrace();
			    }
	        } else {
	        }
	}
	  private boolean isValidLogin(String username, String password) {
		  	CommandHandler.loginUser(username, password, client.getComputer().getIdComputer());
		  	try {
			Thread.sleep(1000);
			if(client.getUser() != null) {
				Stage currentStage = (Stage) login.getScene().getWindow();
			    currentStage.close();
				return true;
				
			}
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  	
		  	return false;
	  }
		  	
}
