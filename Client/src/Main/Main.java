package Main;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			 Parent root = FXMLLoader.load(getClass().getResource("/application/login.fxml"));
			    primaryStage.initStyle(StageStyle.DECORATED);  
		        primaryStage.setTitle("Hello World");
		        primaryStage.setScene(new Scene(root));
		        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
