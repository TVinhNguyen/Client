package Controller_UI;



import java.util.Map;

import Controller.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
	public void clickLogin(MouseEvent e){
		try {
			Alert alert;
			if(username.getText().isEmpty() || password.getText().isEmpty())
			{
				alert=new Alert(AlertType.ERROR);
				alert.setTitle("Thiếu thông tin đăng nhập !");
				alert.setHeaderText(null);
				alert.setContentText("Mời bạn nhập lại .");
				alert.showAndWait();
			}
			else
			{
				    Login loginInstance = new Login();
				    Map<Integer, Integer> isSuccess = loginInstance.login(username.getText(), password.getText());
				    isSuccess.forEach((key, value)->{
				    	Alert alert1;
				    	 if (key==1 || key==2) {
						       Stage currentStage = (Stage) btnLog.getScene().getWindow();
						       currentStage.hide();
						       try {
			                        FXMLLoader loader;
			                        Parent root;
			                        if (key == 1) {
			                        	loader = new FXMLLoader(getClass().getResource("/admin/interfaceAdmin.fxml"));
			                            root = loader.load();
			                            controllerAdmin con = loader.getController();
			                            con.receiveAdminInfo(value);
			                            Stage newStage = new Stage();
			                            newStage.initStyle(StageStyle.UNDECORATED); 
			                            newStage.setTitle("Staff Dashboard");
			                            newStage.setScene(new Scene(root));
			                            newStage.show();
			                        } else if (key == 2) {
			                            loader = new FXMLLoader(getClass().getResource("/admin/interfaceUser.fxml"));
			                            root = loader.load();
			                            controllerUser con = loader.getController();
			                            con.receiveUserInfo(value);
			                            Stage newStage = new Stage();
			                            newStage.initStyle(StageStyle.UNDECORATED); 
			                            newStage.setTitle("Staff Dashboard");
			                            newStage.setScene(new Scene(root));
			                            newStage.show();
			                        }
			                    } catch (Exception ex) {
			                        ex.printStackTrace();
			                    }
				    	 }
				        else if(key==0) {
				    	alert1=new Alert(AlertType.ERROR);
						alert1.setTitle("Sai thông tin đăng nhập !");
						alert1.setHeaderText(null);
						alert1.setContentText("Mời bạn nhập lại .");
						alert1.showAndWait();
				    }
				    }); 
			} 
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	@FXML 
	public void clickClose(ActionEvent e) {
		Stage currentStage = (Stage) btnClose.getScene().getWindow();
	    currentStage.close();
	}
}
