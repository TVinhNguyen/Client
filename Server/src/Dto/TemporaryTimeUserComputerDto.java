package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.TemporaryTimeUserComputer;

public class TemporaryTimeUserComputerDto {
	//lấy tất cả thông tin của bảng
	public static List<TemporaryTimeUserComputer> getAllTemporaryTimeUsers() {
	    List<TemporaryTimeUserComputer> timeUsers = new ArrayList<>();
	    String query = "SELECT * FROM temporarytimeusercomputer";

	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement statement = connection.prepareStatement(query)) {

	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            int idComputer = resultSet.getInt("idComputer");
	            int idCustomer = resultSet.getInt("idCustomer");
	            int idTimeUserComputer = resultSet.getInt("idTimeUserComputer");
	            LocalDateTime timeOrder = resultSet.getTimestamp("timeOrder").toLocalDateTime();
	            timeUsers.add(new TemporaryTimeUserComputer(id, idComputer, idCustomer, idTimeUserComputer, timeOrder));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return timeUsers;
	}
	// Thêm và cập nhật TemporaryTimeUserComputer
	public static String addEndUpdateTemporaryTimeUserComputer(int id, Integer idComputer, Integer idCustomer,
	    Integer idTimeUserComputer,  LocalDateTime timeOrder) {
	    if(idComputer==0)
	    {
	    	idComputer=null;
	    }
	    if(idCustomer==0)
	    {
	    	idCustomer=null;
	    }
	    if(idTimeUserComputer==0)
	    {
	    	idTimeUserComputer=null;
	    }
	    String query = "INSERT INTO temporarytimeusercomputer (idComputer, idCustomer, idTimeUserComputer, "
	                 + "timeOrder) VALUES (?, ?, ?, ?)";
	    boolean isUpdate = false;
	    
	    for (var userTime : getAllTemporaryTimeUsers()) {
	        if (userTime.getId() == id) {
	            query = "UPDATE temporarytimeusercomputer SET idComputer = ?, idCustomer = ?, "
	                  + "idTimeUserComputer = ?, timeOrder = ? WHERE id = ?";
	            isUpdate = true;
	            break;
	        }
	    }
	    
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {
	        
	        statement.setInt(1, idComputer);
	        statement.setInt(2, idCustomer);
	        statement.setInt(3, idTimeUserComputer);
	        statement.setTimestamp(4, java.sql.Timestamp.valueOf(timeOrder)); 
	        if (isUpdate) {
	            statement.setInt(5, id); 
	        }
	        int result = statement.executeUpdate();
	        if (result > 0) {
	            return isUpdate ? "Cập nhật thông tin thành công !!!" : "Thêm thông tin thành công !!!";
	        } else {
	            return isUpdate ? "Cập nhật thông tin không thành công !!!" : "Thêm thông tin không thành công !!!";
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Có lỗi khi thêm hoặc cập nhật thông tin !!!";
	    }
	}
	// Xóa thông tin theo ID
	public static String deleteTemporaryTimeUserComputer(int id) {
	    String query = "DELETE FROM temporarytimeusercomputer WHERE id = ?";
	    
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) { 
	        statement.setInt(1, id); 
	        int result = statement.executeUpdate();
	        if (result > 0) {
	            return "Xóa thông tin thành công !!!";
	        } else {
	            return "Xóa thông tin không thành công !!!";
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Có lỗi khi xóa thông tin !!!";
	    }
	}
}
