package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			 Parent root = FXMLLoader.load(getClass().getResource("MainClient.fxml"));
			    primaryStage.initStyle(StageStyle.UNDECORATED);  // Tắt thanh tiêu đề
			    primaryStage.setResizable(false);
		        primaryStage.setTitle("Hello World");
		        primaryStage.setScene(new Scene(root));
		        primaryStage.show();

		     // Lấy kích thước màn hình
		        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
		        // Đặt vị trí của Stage ở góc phải trên cùng
		        primaryStage.setX(screenBounds.getMaxX() - primaryStage.getWidth());
		        primaryStage.setY(screenBounds.getMinY());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
