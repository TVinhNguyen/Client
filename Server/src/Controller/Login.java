package Controller;

import java.security.MessageDigest;
import java.sql.SQLException;

import Dto.LoginDto;
import Model.Staff;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Login {
	
	public String hashPassword(String password) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] hashedBytes = md.digest(password.getBytes());
	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashedBytes) {
	            sb.append(String.format("%02x", b));
	        }
	        return sb.toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public boolean login(String username, String password) throws SQLException {
	    String hashedPassword = hashPassword(password);
	    Staff user = LoginDto.loginstaff(username, hashedPassword);
	    
	    if (user != null) {
	        if (user.getRole().equals("admin")) {
	            redirectToAdminDashboard();
	        } else {
	            redirectToStaffDashboard();
	        }
	        return true;
	    }
	    return false;
	}
	
	public void redirectToAdminDashboard() {
	    loginSuccess("/admin/interfaceAdmin.fxml");
	}

	public void redirectToStaffDashboard() {
	    loginSuccess("/admin/interfaceUser.fxml");
	}
	
	public void loginSuccess(String link) {
	    try {
	        Parent newRoot = FXMLLoader.load(getClass().getResource(link));
	        
	        // Tạo Stage mới và hiển thị
	        Stage newStage = new Stage();
	        newStage.initStyle(StageStyle.UNDECORATED);
	        newStage.setTitle("Dashboard");
	        newStage.setScene(new Scene(newRoot));
	        newStage.show();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
}
