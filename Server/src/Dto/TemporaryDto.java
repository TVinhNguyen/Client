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
	public static String addEndUpdateTemporary(int idtemporary, Integer idCustomer, Integer idProduct, 
	        int numberProduct, Integer idStaff, LocalDateTime timeOrder, Integer idComputer) {

	    // Chuyển idCustomer, idProduct, idStaff, idComputer về null nếu giá trị = 0
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

	    String query;
	    boolean isUpdate = false;

	    // Kiểm tra nếu idtemporary = 0 thì sẽ thực hiện thêm mới
	    if (idtemporary != 0) {
	        // Nếu idtemporary != 0, thực hiện kiểm tra sự tồn tại của bản ghi và cập nhật
	        query = "UPDATE temporary SET idCustomer = ?, idProduct = ?, numberProduct = ?, "
	                + "idStaff = ?, timeOrder = ?, idComputer = ? WHERE idtemporary = ?";
	        isUpdate = true;
	    } else {
	        // Nếu idtemporary = 0, thực hiện thêm mới
	        query = "INSERT INTO temporary (idCustomer, idProduct, numberProduct, idStaff, timeOrder, idComputer) "
	                + "VALUES (?, ?, ?, ?, ?, ?)";
	    }

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {

	        // Thiết lập các tham số cho câu lệnh SQL
	        if (idCustomer == null) {
	            statement.setNull(1, Types.INTEGER);
	        } else {
	            statement.setInt(1, idCustomer);
	        }

	        if (idProduct == null) {
	            statement.setNull(2, Types.INTEGER);
	        } else {
	            statement.setInt(2, idProduct);
	        }

	        statement.setInt(3, numberProduct);

	        if (idStaff == null) {
	            statement.setNull(4, Types.INTEGER);
	        } else {
	            statement.setInt(4, idStaff);
	        }

	        statement.setTimestamp(5, Timestamp.valueOf(timeOrder));

	        if (idComputer == null) {
	            statement.setNull(6, Types.INTEGER);
	        } else {
	            statement.setInt(6, idComputer);
	        }

	        if (isUpdate) {
	            statement.setInt(7, idtemporary); // Chỉ khi cập nhật, mới có idtemporary
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
