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
			
			    Parent root = FXMLLoader.load(getClass().getResource("/admin/interfaceLogin.fxml"));
			    primaryStage.initStyle(StageStyle.UNDECORATED);  // Tắt thanh tiêu đề
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

//import java.security.MessageDigest;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import DatabaseConnection.DBConnection;
//import Model.Staff;
//
//public class Main {
//
//    public static String hashPassword(String password) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            byte[] hashedBytes = md.digest(password.getBytes());
//            StringBuilder sb = new StringBuilder();
//            for (byte b : hashedBytes) {
//                sb.append(String.format("%02x", b));
//            }
//            return sb.toString();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static List<Staff> createUsers() {
//        List<Staff> users = new ArrayList<>();
//        
//        // Tạo 4 nhân viên
//        users.add(new Staff("Nguyen Van A", "0123456789", "nva", hashPassword("password1"), "staff", "123 Main St",Date.valueOf("2023-01-15"), 100));
//        users.add(new Staff("Tran Thi B", "0987654321", "ttb", hashPassword("password2"), "staff", "456 Maple Rd", Date.valueOf("2023-02-20"),85));
//        users.add(new Staff("Le Van C", "0912345678", "lvc", hashPassword("password3"), "staff", "789 Oak Dr",Date.valueOf("2023-03-25") , 75));
//        users.add(new Staff("Pham Thi D", "0923456789", "ptd", hashPassword("password4"), "staff", "101 Pine Ln",Date.valueOf( "2023-04-30"), 60));
//        
//        // Tạo 1 admin
//        users.add(new Staff("Hoang Van E", "0934567890", "hve", hashPassword("password5"), "admin", "202 Cedar Ave",Date.valueOf( "2023-05-10"), 90));
//        
//        return users;
//    }
//
//    public static void insertUsersIntoDatabase(List<Staff> users) {
//        String sql = "INSERT INTO Users (name, phone, username, password, role, address, timeStartWork, dayWork) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (Connection connection = DBConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            for (Staff user : users) {
//                statement.setString(1, user.getName());
//                statement.setString(2, user.getPhone());
//                statement.setString(3, user.getNameAccount());
//                statement.setString(4, user.getPasswordAccount());
//                statement.setString(5, user.getRole());
//                statement.setString(6, user.getAddressStaff());
//                statement.setDate(7, user.getTimeStartWork());
//                statement.setInt(8, user.getDayWork());
//                
//                statement.executeUpdate();
//            }
//
//            System.out.println("Users inserted successfully!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        List<Staff> users = createUsers();
//        insertUsersIntoDatabase(users);
//    }
//}
//
