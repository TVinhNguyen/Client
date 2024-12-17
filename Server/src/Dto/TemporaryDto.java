package Dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
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
	            int turn=resultSet.getInt("turn");
	            int idCustomer = resultSet.getInt("idCustomer");
	            int idProduct = resultSet.getInt("idProduct");
	            int numberProduct = resultSet.getInt("numberProduct");
	            int idStaff = resultSet.getInt("idStaff");
	            
	            // Xử lý timeOrder có thể là NULL
	            Timestamp timestamp = resultSet.getTimestamp("timeOrder");
	            LocalDateTime timeOrder = (timestamp != null) ? timestamp.toLocalDateTime() : null;

	            int idComputer = resultSet.getInt("idComputer");

	            // Thêm đối tượng Temporary vào danh sách
	            temporaryList.add(new Temporary(idtemporary,turn ,idCustomer, idProduct, numberProduct, idStaff, timeOrder, idComputer));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return temporaryList;
	}

	//cập nhật và thêm thông tin 
	public static String addEndUpdateTemporary(int idtemporary,Integer turn ,Integer idCustomer, Integer idProduct, 
	        Integer numberProduct, Integer idStaff, LocalDateTime timeOrder, Integer idComputer) {

	    if (idCustomer != null && idCustomer == 0) {
	        idCustomer = null;
	    }
	    if (idProduct != null && idProduct == 0) {
	        idProduct = null;
	    }
	    if (idStaff != null && idStaff == 0) {
	        idStaff = null;
	    }
	    if (idComputer != null && idComputer == 0) {
	        idComputer = null;
	    }
	    if (turn != null && turn == 0) {
	    	turn = null;
	    }
	    String query;
	    boolean isUpdate = false;

	    // Kiểm tra nếu idtemporary = 0 thì sẽ thực hiện thêm mới
	    if (idtemporary != 0) {
	        // Cập nhật bản ghi nếu idtemporary khác 0
	        query = "UPDATE temporary SET turn = ?, idCustomer = ?, idProduct = ?, numberProduct = ?, "
	                + "idStaff = ?, timeOrder = ?, idComputer = ? WHERE idtemporary = ?";
	        isUpdate = true;
	    } else {
	        // Thêm mới bản ghi nếu idtemporary = 0
	        query = "INSERT INTO temporary (turn, idCustomer, idProduct, numberProduct, idStaff, timeOrder, idComputer) "
	                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
	    }

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {

	        // Thiết lập các tham số cho câu lệnh SQL
	    	int paramIndex = 1;

	        if (turn == null) {
	            statement.setNull(paramIndex++, Types.INTEGER);
	        } else {
	            statement.setInt(paramIndex++, turn);
	        }

	        if (idCustomer == null) {
	            statement.setNull(paramIndex++, Types.INTEGER);
	        } else {
	            statement.setInt(paramIndex++, idCustomer);
	        }

	        if (idProduct == null) {
	            statement.setNull(paramIndex++, Types.INTEGER);
	        } else {
	            statement.setInt(paramIndex++, idProduct);
	        }

	        if (numberProduct == null) {
	            statement.setNull(paramIndex++, Types.INTEGER);
	        } else {
	            statement.setInt(paramIndex++, numberProduct);
	        }

	        if (idStaff == null) {
	            statement.setNull(paramIndex++, Types.INTEGER);
	        } else {
	            statement.setInt(paramIndex++, idStaff);
	        }

	        if (timeOrder == null) {
	            statement.setNull(paramIndex++, Types.TIMESTAMP);
	        } else {
	            statement.setTimestamp(paramIndex++, Timestamp.valueOf(timeOrder));
	        }

	        if (idComputer == null) {
	            statement.setNull(paramIndex++, Types.INTEGER);
	        } else {
	            statement.setInt(paramIndex++, idComputer);
	        }

	        if (isUpdate) {
	            statement.setInt(paramIndex++, idtemporary); // Tham số cuối cùng là idtemporary khi cập nhật
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
