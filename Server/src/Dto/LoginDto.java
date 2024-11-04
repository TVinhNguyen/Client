package Dto;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.Login;
import DatabaseConnection.DBConnection;
import Model.Staff;

public class LoginDto {

	public static Staff loginstaff(String username , String password ) throws SQLException {
	    String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
        
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();


            if (resultSet.next()) {
                Staff staff = new Staff(null,null,null,null);
                staff.setIdStaff(resultSet.getInt("idUser"));
                staff.setName(resultSet.getString("name"));
                staff.setPhone(resultSet.getString("phone"));
                staff.setNameAccount(resultSet.getString("username"));
                staff.setPasswordAccount(resultSet.getString("password"));
                staff.setRole(resultSet.getString("role"));
                staff.setAddressStaff(resultSet.getString("address"));
                staff.setTimeStartWork(resultSet.getDate("timeStartWork"));
                staff.setDayWork(resultSet.getInt("dayWork"));
                
                return staff;
            }
        }

        return null;  // Nếu không tìm thấy, trả về null
    }
}
