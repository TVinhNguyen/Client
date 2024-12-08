package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.TimeUserComputer;

public class TimeUserComputerDto {
	// Phương thức để lấy tất cả thông tin từ bảng timeusercomputer
    public static List<TimeUserComputer> getAllTimeUserComputers() {
        String query = "SELECT * FROM timeusercomputer";
        List<TimeUserComputer> timeUserComputerList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idUserComputer = resultSet.getInt("idUserComputer");
                long timeUser = resultSet.getLong("timeUser");
                double moneyUser = resultSet.getDouble("moneyUser");
                timeUserComputerList.add(new TimeUserComputer(idUserComputer, timeUser, moneyUser));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return timeUserComputerList;
    }
 // Xóa thông tin từ bảng timeusercomputer theo idUserComputer
    public static String deleteTimeUserComputerById(int idUserComputer) {
        String query = "DELETE FROM timeusercomputer WHERE idUserComputer = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
             statement.setInt(1, idUserComputer);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return "Xóa thành công";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Lỗi khi xóa dữ liệu";
        }
        return "Xóa không thành công";
    }
 // Thêm mới hoặc cập nhật thông tin trong bảng timeusercomputer
    public static String addOrUpdateTimeUserComputer(int idUserComputer, long timeUser, double moneyUser) {
        String query = "INSERT INTO timeusercomputer (timeUser, moneyUser) VALUES (?, ?)";
        boolean check = false;
        for (TimeUserComputer timeUserComputer : getAllTimeUserComputers()) {
            if (timeUserComputer.getIdUserComputer() == idUserComputer) {
                query = "UPDATE timeusercomputer SET timeUser = ?, moneyUser = ? WHERE idUserComputer = ?";
                check = true;
                break;
            }
        }
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
        	 statement.setLong(1, timeUser);
             statement.setDouble(2, moneyUser);
        	if (check) {
               
                statement.setInt(3, idUserComputer); 
            } 
            int result = statement.executeUpdate();
            if (result > 0) {
                return check ? "Cập nhật thông tin thành công !!!" : "Thêm thông tin thành công !!!";
            } else {
                return check ? "Cập nhật thông tin không thành công !!!" : "Thêm thông tin không thành công !!!";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Có lỗi khi thêm hoặc cập nhật thông tin thời gian sử dụng máy !!!";
        }
    }
   public static TimeUserComputer checkIdTakeTimeUserComputer(int id)
   {
	   try {
		for(var time:getAllTimeUserComputers())
		{
			if(time.getIdUserComputer()==id)
			{
				return time;
			}
		}
	} catch (Exception e) {
		e.getMessage();
	}
	   return null;
   }
}
