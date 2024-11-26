package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.New;

public class NewDto {
//lấy tất cả thông tin của new
	  public static List<New> getAllNews(){
	        String query = "SELECT * FROM New";
	        List<New> newsList = new ArrayList<>();
	        try (Connection connection = DBConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {

	            while (resultSet.next()) {
	                int idNew = resultSet.getInt("idNew");
	                String titleNew = resultSet.getString("titleNew");
	                String contentNew = resultSet.getString("contentNew");
	                LocalDateTime timestampNew = resultSet.getTimestamp("timestampNew").toLocalDateTime();
	                byte[] imageNew = resultSet.getBytes("imageNew");
	                newsList.add(new New(idNew, titleNew, contentNew, timestampNew, imageNew));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return newsList;
	    }
	  public static String addEndUpdateNew(int idNew, String titleNew, String contentNew, LocalDateTime timestampNew, byte[] imageNew) {
		    String query = "INSERT INTO New (titleNew, contentNew, timestampNew, imageNew) VALUES (?, ?, ?, ?)";
		    boolean check = false;
		    for (var news : getAllNews()) {
		        if (news.getIdNew()==idNew) {
		            query = "UPDATE New SET titleNew = ?, contentNew = ?, timestampNew = ?, imageNew = ? WHERE idNew = ?";
		            check = true;
		            break;
		        }
		    }
		    try (Connection conn = DBConnection.getConnection();
		         PreparedStatement statement = conn.prepareStatement(query)) {
		        statement.setString(1, titleNew);
		        statement.setString(2, contentNew);
		        statement.setTimestamp(3, Timestamp.valueOf(timestampNew));
		        statement.setBytes(4, imageNew);
		        if (check) {
		            statement.setInt(5, idNew);
		        }
		        int result = statement.executeUpdate();
		        if (result > 0) {
		            return check ? "Cập nhật bài viết thành công !!!" : "Thêm bài viết thành công !!!";
		        } else {
		            return check ? "Cập nhật bài viết không thành công !!!" : "Thêm bài viết không thành công !!!";
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return "Có lỗi khi thêm hoặc cập nhật bài viết !!!";
		    }
		}

}
