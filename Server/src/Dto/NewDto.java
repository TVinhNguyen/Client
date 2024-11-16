package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.New;

public class NewDto {
//lấy tất cả thông tin của new
	  public static List<New> getAllNews() throws SQLException {
	        String query = "SELECT * FROM New";
	        List<New> newsList = new ArrayList<>();
	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {

	            while (resultSet.next()) {
	                String idNew = resultSet.getString("idNew");
	                String titleNew = resultSet.getString("titleNew");
	                String contentNew = resultSet.getString("contentNew");
	                LocalDateTime timestampNew = resultSet.getTimestamp("timestampNew").toLocalDateTime();
	                String categoryNew = resultSet.getString("categoryNew");
	                newsList.add(new New(idNew, titleNew, contentNew, timestampNew, categoryNew));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return newsList;
	    }
}
