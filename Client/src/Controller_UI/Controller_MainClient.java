package Controller_UI;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller_MainClient extends Controller_Form {
	@FXML
	private Label Money_User;
	@FXML
	private Label Time_User;
	@FXML
	private Label RemainTime_User;
	@FXML
	private Label Price;
	@FXML
	private VBox service_user;
	@FXML
	private VBox combo_user;
	@FXML
	private VBox recharge_user;
	@FXML
	private VBox message_user;
	@FXML
	private VBox lockDevice_user;
	@FXML
	private VBox logOut_user;
	
	@FXML
	public void Click_Service() {
		try {
			Stage FoodMenu_Stage = new Stage();
			 Parent root = FXMLLoader.load(getClass().getResource("../application/FoodMenu_Client.fxml"));
			 FoodMenu_Stage.initStyle(StageStyle.UNDECORATED);  // Tắt thanh tiêu đề
			 FoodMenu_Stage.setResizable(false);
		     FoodMenu_Stage.setScene(new Scene(root));
		     FoodMenu_Stage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}
	@FXML
	public void Click_Combo() {
		
	}
	@FXML
	public void Click_Recharge() {
		try {
			Stage Recharge_Stage = new Stage();
			 Parent root = FXMLLoader.load(getClass().getResource("../application/Recharge_Client.fxml"));
			 Recharge_Stage.initStyle(StageStyle.UNDECORATED);  // Tắt thanh tiêu đề
			 Recharge_Stage.setResizable(false);
		     Recharge_Stage.setScene(new Scene(root));
		     Recharge_Stage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	
	}
	@FXML
	public void Click_Message() {
		try {
			Stage Message_Stage = new Stage();
			 Parent root = FXMLLoader.load(getClass().getResource("../application/Chat_Client.fxml"));
			 Message_Stage.initStyle(StageStyle.UNDECORATED);  // Tắt thanh tiêu đề
			 Message_Stage.setResizable(false);
		     Message_Stage.setScene(new Scene(root));
		     Message_Stage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}
	@FXML
	public void Click_lockDevice() {
		
	}
	@FXML
	public void Click_Logout() {
		
	}
	
}
