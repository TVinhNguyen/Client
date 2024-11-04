package Controller_UI;


import Controller.Client;
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
		 if (isValidLogin(username, password) != null) {
			 try {
				 	
			        Parent newRoot = FXMLLoader.load(getClass().getResource("/application/client.fxml"));
			        
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
	  private UserAccount isValidLogin(String username, String password) {
		  	String send = "LOGIN_USER " + username + " " + password;
		  	System.out.println(send);
		  	client.sendMessage(send);;
		  	try {
			Thread.sleep(1000);
			String kq;
			if((kq=client.receiMessage())!="") {
				Stage currentStage = (Stage) login.getScene().getWindow();
			    currentStage.close();
				return UserAccount.fromString(kq);
				
			}
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  	
		  ///// nhânj dữ liệu
		  	return null;
	  }
		  	
}
