package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DatabaseConnection.DBConnection;
import Model.Temporary;

public class TemporaryDto {
	//liệt kê tất cả thông tin trong bảng
	public static List<Temporary> getAllTemporary() {
	    List<Temporary> temporaryList = new ArrayList<>();
	    String query = "SELECT * FROM temporary";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {

	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int idtemporary = resultSet.getInt("idtemporary");
	            int idCustomer = resultSet.getInt("idCustomer");
	            int idProduct = resultSet.getInt("idProduct");
	            int numberProduct = resultSet.getInt("numberProduct");
	            int idStaff = resultSet.getInt("idStaff");
	            LocalDateTime timeOrder = resultSet.getTimestamp("timeOrder").toLocalDateTime();
	            int idComputer = resultSet.getInt("idComputer");
	            temporaryList.add(new Temporary(idtemporary, idCustomer, idProduct, numberProduct, idStaff, timeOrder, idComputer));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return temporaryList;
	}
	//cập nhật và thêm thông tin 
	public static String addEndUpdateTemporary(int idtemporary, int idCustomer, int idProduct, 
		    int numberProduct, int idStaff, LocalDateTime timeOrder, int idComputer) {
		    
		    String query = "INSERT INTO temporary (idCustomer, idProduct, numberProduct, idStaff, timeOrder, idComputer) "
		                 + "VALUES (?, ?, ?, ?, ?, ?)";
		    boolean isUpdate = false;
		    for (var temp : getAllTemporary()) {
		        if (temp.getIdTemporary() == idtemporary) {
		            query = "UPDATE temporary SET idCustomer = ?, idProduct = ?, numberProduct = ?, "
		                  + "idStaff = ?, timeOrder = ?, idComputer = ? WHERE idtemporary = ?";
		            isUpdate = true;
		            break;
		        }
		    }
		    try (Connection conn = DBConnection.getConnection();
		         PreparedStatement statement = conn.prepareStatement(query)) {

		        statement.setInt(1, idCustomer);
		        statement.setInt(2, idProduct);
		        statement.setInt(3, numberProduct);
		        statement.setInt(4, idStaff);
		        statement.setTimestamp(5, Timestamp.valueOf(timeOrder));
		        statement.setInt(6, idComputer);
		        if (isUpdate) {
		            statement.setInt(7, idtemporary); 
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
	//xóa thông tin bảng
	public static String deleteTemporary(int idtemporary) {
	    String query = "DELETE FROM temporary WHERE idtemporary = ?";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setInt(1, idtemporary); 
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
